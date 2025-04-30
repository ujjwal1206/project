@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository repository;
    private final RestTemplate restTemplate;

    private static final Map<VehicleType, Double> RATES_PER_HOUR = Map.of(
        VehicleType.CAR, 20.0,
        VehicleType.BIKE, 10.0,
        VehicleType.TRUCK, 30.0
    );

    public Payment initiatePayment(Long bookingId, String modeOfPayment) {
        // Call booking service to get details
        BookingDTO booking = restTemplate.getForObject(
            "http://BOOKING-SERVICE/api/booking/" + bookingId, BookingDTO.class);

        if (booking == null || booking.getInTime() == null || booking.getOutTime() == null) {
            throw new RuntimeException("Invalid booking details");
        }

        // Calculate duration
        long hours = ChronoUnit.HOURS.between(booking.getInTime(), booking.getOutTime());
        if (hours == 0) hours = 1; // minimum 1 hour

        // Get rate
        double rate = RATES_PER_HOUR.getOrDefault(booking.getVehicleType(), 20.0);
        double amount = hours * rate;

        Payment payment = new Payment();
        payment.setBookingId(bookingId);
        payment.setAmount(amount);
        payment.setModeOfPayment(modeOfPayment);
        payment.setPaymentStatus(PaymentStatus.PENDING);
        payment.setPaymentTime(LocalDateTime.now());

        return repository.save(payment);
    }

    public Payment completePayment(Long paymentId, boolean success) {
        Payment payment = repository.findById(paymentId)
                .orElseThrow(() -> new RuntimeException("Payment not found"));

        payment.setPaymentStatus(success ? PaymentStatus.SUCCESS : PaymentStatus.FAILED);
        return repository.save(payment);
    }
}

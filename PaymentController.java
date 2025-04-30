@RestController
@RequestMapping("/api/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/initiate")
    public ResponseEntity<Payment> initiatePayment(
            @RequestParam Long bookingId,
            @RequestParam String modeOfPayment) {
        return ResponseEntity.ok(paymentService.initiatePayment(bookingId, modeOfPayment));
    }

    @PostMapping("/complete")
    public ResponseEntity<Payment> completePayment(
            @RequestParam Long paymentId,
            @RequestParam boolean success) {
        return ResponseEntity.ok(paymentService.completePayment(paymentId, success));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Payment>> getAllPayments() {
        return ResponseEntity.ok(paymentService.getAllPayments());
    }
}

@Entity
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long bookingId;

    private Double amount;

    private String modeOfPayment;

    private PaymentStatus paymentStatus;

    private LocalDateTime paymentTime;
}

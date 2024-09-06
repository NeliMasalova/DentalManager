package pl.pingwit.pingwitdentalmanager.controller.payment;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pingwit.pingwitdentalmanager.service.payment.PaymentService;

@RestController
@RequestMapping("/payment") public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
}

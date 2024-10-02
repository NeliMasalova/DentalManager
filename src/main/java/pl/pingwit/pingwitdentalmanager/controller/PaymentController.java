package pl.pingwit.pingwitdentalmanager.controller;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pingwit.pingwitdentalmanager.dto.PaymentDto;
import pl.pingwit.pingwitdentalmanager.service.PaymentService;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping
    public List<PaymentDto> paymentList() {
        return paymentService.paymentList();
    }

    @PostMapping
    public Long createPayment(@RequestBody PaymentDto inputDto){
        return paymentService.createPayment(inputDto);
    }
}

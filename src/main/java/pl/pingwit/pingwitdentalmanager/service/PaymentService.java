package pl.pingwit.pingwitdentalmanager.service;

import pl.pingwit.pingwitdentalmanager.dto.PaymentDto;

import java.util.List;

public interface PaymentService {
    List<PaymentDto> paymentList();

    Long createPayment(PaymentDto inputDto);
}

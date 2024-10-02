package pl.pingwit.pingwitdentalmanager.service;

import org.springframework.stereotype.Service;
import pl.pingwit.pingwitdentalmanager.converter.PaymentConverter;
import pl.pingwit.pingwitdentalmanager.entity.Appointment;
import pl.pingwit.pingwitdentalmanager.entity.DentalTreatment;
import pl.pingwit.pingwitdentalmanager.entity.Payment;
import pl.pingwit.pingwitdentalmanager.dto.PaymentDto;
import pl.pingwit.pingwitdentalmanager.exceptionhandling.NotFoundException;
import pl.pingwit.pingwitdentalmanager.repository.AppointmentRepository;
import pl.pingwit.pingwitdentalmanager.repository.DentalTreatmentRepository;
import pl.pingwit.pingwitdentalmanager.repository.PaymentRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final PaymentConverter paymentConverter;
    private final AppointmentRepository appointmentRepository;
    private final DentalTreatmentRepository dentalTreatmentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository, PaymentConverter paymentConverter, AppointmentRepository appointmentRepository, DentalTreatmentRepository dentalTreatmentRepository) {
        this.paymentRepository = paymentRepository;
        this.paymentConverter = paymentConverter;
        this.appointmentRepository = appointmentRepository;
        this.dentalTreatmentRepository = dentalTreatmentRepository;
    }

    @Override
    public List<PaymentDto> paymentList() {
        return paymentRepository.findAll().stream()
                .map(paymentConverter::convertToDto)
                .toList();
    }

    @Override
    public java.lang.Long createPayment(PaymentDto inputDto) {
//        System.out.println("Received PaymentDto: " + inputDto);
//
//        if (inputDto.getAppointment() == null) {
//            throw new IllegalArgumentException("Appointment ID must not be null");
//        }
        Appointment appointment = appointmentRepository.findById(inputDto.getId())
                .orElseThrow(() -> new RuntimeException("Appointment not found"));


        List<DentalTreatment> dentalTreatments = dentalTreatmentRepository.findByAppointmentsId(appointment.getId());
        BigDecimal totalAmount = dentalTreatments.stream()
                .map(DentalTreatment::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        Payment payment = new Payment();
        payment.setName(inputDto.getName());
        payment.setDate(inputDto.getDate());
        payment.setTypePayment(inputDto.getTypePayment());
        payment.setAppointment(inputDto.getAppointment());
        payment.setAmount(totalAmount);

        Payment savedPayment = paymentRepository.save(payment);

        updateTotalAmountForVisit(appointment.getId());

        return savedPayment.getId();
    }

    public void updateTotalAmountForVisit(java.lang.Long longId) {
        List<Payment> paymentsForVisit = paymentRepository.findByAppointmentId(longId);

        BigDecimal totalAmount = paymentsForVisit.stream()
                .map(Payment::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        Appointment aAppointment = appointmentRepository.findById(longId)
                .orElseThrow(() -> new NotFoundException("Appointment not found"));

        aAppointment.setAmount(totalAmount);
        appointmentRepository.save(aAppointment);
    }
}
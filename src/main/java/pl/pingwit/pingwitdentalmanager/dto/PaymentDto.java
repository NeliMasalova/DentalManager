package pl.pingwit.pingwitdentalmanager.dto;

import pl.pingwit.pingwitdentalmanager.entity.Appointment;
import pl.pingwit.pingwitdentalmanager.entity.TypePayment;

import java.time.LocalDate;

public class PaymentDto {
    private Long id;
    private String name;

    private Appointment appointment;
    private LocalDate date;
    private TypePayment typePayment;

    public PaymentDto() {
    }

    public PaymentDto(Long id, String name, Appointment appointment, LocalDate date, TypePayment typePayment) {
        this.id = id;
        this.name = name;
        this.appointment = appointment;
        this.date = date;
        this.typePayment = typePayment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public TypePayment getTypePayment() {
        return typePayment;
    }

    public void setTypePayment(TypePayment typePayment) {
        this.typePayment = typePayment;
    }
}

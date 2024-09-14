package pl.pingwit.pingwitdentalmanager.controller.appointment;

import pl.pingwit.pingwitdentalmanager.repository.appointment.AppointmentStatus;
import pl.pingwit.pingwitdentalmanager.repository.dental_service.DentalService;
import pl.pingwit.pingwitdentalmanager.repository.doctor.Doctor;
import pl.pingwit.pingwitdentalmanager.repository.patient.Patient;

import java.time.LocalDate;

public class AppointmentDto {
    private Long id;
    private LocalDate date;
    private AppointmentStatus appointmentStatus;
    private Patient patient;
    private Doctor doctor;
    private DentalService dentalService;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public AppointmentStatus getAppointmentStatus() {
        return appointmentStatus;
    }

    public void setAppointmentStatus(AppointmentStatus appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public DentalService getDentalService() {
        return dentalService;
    }

    public void setDentalService(DentalService dentalService) {
        this.dentalService = dentalService;
    }
}

package pl.pingwit.pingwitdentalmanager.repository.appointment;

import jakarta.persistence.*;
import pl.pingwit.pingwitdentalmanager.repository.doctor.Doctor;
import pl.pingwit.pingwitdentalmanager.repository.patient.Patient;
import pl.pingwit.pingwitdentalmanager.repository.dental_service.DentalService;

import java.time.LocalDate;

@Entity
@Table(name = "appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appointment_id_generator")
    @Column(name = "id")
    private Long id;
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "status")
    private AppointmentStatus appointmentStatus;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
//    @Column(name = "doctor_id")
//    private Doctor doctor;
//    @Column(name = "service_id")
//    private DentalService dentalService;

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

//    public Doctor getDoctor() {
//        return doctor;
//    }
//
//    public void setDoctor(Doctor doctor) {
//        this.doctor = doctor;
//    }
//
//    public DentalService getDentalService() {
//        return dentalService;
//    }
//
//    public void setDentalService(DentalService dentalService) {
//        this.dentalService = dentalService;
//    }
}

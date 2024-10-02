package pl.pingwit.pingwitdentalmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pingwit.pingwitdentalmanager.entity.Appointment;

import java.util.Optional;

public interface AppointmentRepository extends JpaRepository<Appointment, java.lang.Long> {
    Optional<Appointment> findByPatientId(java.lang.Long patientId);
}

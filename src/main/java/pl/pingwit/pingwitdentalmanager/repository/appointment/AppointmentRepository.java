package pl.pingwit.pingwitdentalmanager.repository.appointment;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    Optional<Appointment> findByPatientId(Long patientId);
}

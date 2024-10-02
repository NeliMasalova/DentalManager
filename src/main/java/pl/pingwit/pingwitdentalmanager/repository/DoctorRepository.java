package pl.pingwit.pingwitdentalmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pingwit.pingwitdentalmanager.entity.Appointment;
import pl.pingwit.pingwitdentalmanager.entity.Doctor;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor, java.lang.Long> {
    Optional<Doctor> findById(Appointment id);
}

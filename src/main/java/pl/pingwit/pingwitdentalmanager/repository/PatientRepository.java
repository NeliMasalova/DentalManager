package pl.pingwit.pingwitdentalmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pingwit.pingwitdentalmanager.entity.Appointment;
import pl.pingwit.pingwitdentalmanager.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, java.lang.Long> {

}

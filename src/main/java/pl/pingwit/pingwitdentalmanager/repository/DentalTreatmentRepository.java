package pl.pingwit.pingwitdentalmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pingwit.pingwitdentalmanager.entity.DentalTreatment;

import java.util.List;

public interface DentalTreatmentRepository extends JpaRepository<DentalTreatment, Long> {
    List<DentalTreatment> findByAppointmentsId(Long id);
}

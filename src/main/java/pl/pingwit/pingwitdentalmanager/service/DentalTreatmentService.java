package pl.pingwit.pingwitdentalmanager.service;

import pl.pingwit.pingwitdentalmanager.dto.DentalTreatmentDto;

import java.util.List;

public interface DentalTreatmentService {
    DentalTreatmentDto findTreatmentById(Long id);

    List<DentalTreatmentDto> listTreatments();

    Long createTreatment(DentalTreatmentDto inputDto);
}

package pl.pingwit.pingwitdentalmanager.service;

import pl.pingwit.pingwitdentalmanager.dto.CreatePatientInputDto;
import pl.pingwit.pingwitdentalmanager.dto.PatientDto;
import pl.pingwit.pingwitdentalmanager.dto.PatientShortDto;
import pl.pingwit.pingwitdentalmanager.entity.Patient;

import java.util.List;

public interface PatientService {
    List<PatientShortDto> listPatients();

    Long createPatient(CreatePatientInputDto inputDto);

    PatientDto getPatient(Long id);

    void deletePatient(Long id);

    void updatePatient(Long id, Patient inputDto);
}

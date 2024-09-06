package pl.pingwit.pingwitdentalmanager.service.patient;

import pl.pingwit.pingwitdentalmanager.controller.patient.CreatePatientInputDto;
import pl.pingwit.pingwitdentalmanager.controller.patient.PatientDto;
import pl.pingwit.pingwitdentalmanager.controller.patient.PatientShortDto;

import java.util.List;

public interface PatientService {
    List<PatientShortDto> listPatients();

    Long createPatient(CreatePatientInputDto inputDto);

    PatientDto getPatient(Long id);
}

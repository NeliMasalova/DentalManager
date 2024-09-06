package pl.pingwit.pingwitdentalmanager.service.patient;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.pingwit.pingwitdentalmanager.controller.patient.CreatePatientInputDto;
import pl.pingwit.pingwitdentalmanager.controller.patient.PatientDto;
import pl.pingwit.pingwitdentalmanager.controller.patient.PatientShortDto;
import pl.pingwit.pingwitdentalmanager.converter.pacient.PatientConverter;
import pl.pingwit.pingwitdentalmanager.repository.patient.Patient;
import pl.pingwit.pingwitdentalmanager.repository.patient.PatientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;
    private final PatientConverter patientConverter;

    public PatientServiceImpl(PatientRepository patientRepository, PatientConverter patientConverter) {
        this.patientRepository = patientRepository;
        this.patientConverter = patientConverter;
    }

    @Override
    public List<PatientShortDto> listPatients() {
        return patientRepository.findAll().stream()
                .map(patientConverter::convertToShortDto)
                .toList();
    }

    @Override
    public Long createPatient(CreatePatientInputDto inputDto) {
        Patient savedPatient = patientRepository.save(patientConverter.convertToEntity(inputDto));
        return savedPatient.getId();
    }

    @Override
    public PatientDto getPatient(Long id) {
        Patient patient = patientRepository.findById(id).orElseThrow();
        return patientConverter.convertToDto(patient);
    }
}

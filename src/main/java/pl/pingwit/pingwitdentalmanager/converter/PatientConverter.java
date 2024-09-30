package pl.pingwit.pingwitdentalmanager.converter;

import org.springframework.stereotype.Component;
import pl.pingwit.pingwitdentalmanager.dto.CreatePatientInputDto;
import pl.pingwit.pingwitdentalmanager.dto.PatientDto;
import pl.pingwit.pingwitdentalmanager.dto.PatientShortDto;
import pl.pingwit.pingwitdentalmanager.entity.Patient;

@Component
public class PatientConverter {
    public PatientDto convertToDto(Patient patient){
        PatientDto patientDto = new PatientDto();
        patientDto.setId(patient.getId());
        patientDto.setName(patient.getName());
        patientDto.setSurname(patient.getSurname());
        patientDto.setBirthdate(patient.getBirthdate());
        patientDto.setPhone(patient.getPhone());
        return patientDto;
    }

    public Patient convertToEntity(CreatePatientInputDto inputDto) {
        return new Patient(inputDto.getName(),
                inputDto.getSurname(),
                inputDto.getBirthdate(),
                inputDto.getEmail(),
                inputDto.getPhone(),
                inputDto.getAddress());
    }

    public PatientShortDto convertToShortDto(Patient patient) {
        return new PatientShortDto(patient.getName(),
                patient.getSurname(),
                patient.getBirthdate(),
                patient.getPhone());
    }
}

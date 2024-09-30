package pl.pingwit.pingwitdentalmanager.converter;

import org.springframework.stereotype.Component;
import pl.pingwit.pingwitdentalmanager.dto.DoctorDto;
import pl.pingwit.pingwitdentalmanager.entity.Doctor;

@Component
public class DoctorConverter {
    public DoctorDto convertToDto(Doctor doctor) {
        return new DoctorDto(
                doctor.getName(),
                doctor.getSurname(),
                doctor.getSpecialty(),
                doctor.getPhone(),
                doctor.getRate());
    }

    public Doctor convertToEntity(DoctorDto inputDto) {
        Doctor doctor = new Doctor();
        doctor.setName(inputDto.getName());
        doctor.setSurname(inputDto.getSurname());
        doctor.setSpecialty(inputDto.getSpecialty());
        doctor.setRate(inputDto.getRate());
        doctor.setPhone(inputDto.getPhone());
        return doctor;
    }
}

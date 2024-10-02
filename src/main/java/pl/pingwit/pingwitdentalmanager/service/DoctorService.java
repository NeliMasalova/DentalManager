package pl.pingwit.pingwitdentalmanager.service;

import pl.pingwit.pingwitdentalmanager.dto.DoctorDto;
import pl.pingwit.pingwitdentalmanager.entity.Doctor;

import java.util.List;

public interface DoctorService {
    List<DoctorDto> listDoctors();

    Long createDoctor(DoctorDto inputDto);

    DoctorDto getDoctor(Long id);

    void deleteDoctor(Long id);

    void updateDoctorRate(Long id, Doctor inputDto);
}

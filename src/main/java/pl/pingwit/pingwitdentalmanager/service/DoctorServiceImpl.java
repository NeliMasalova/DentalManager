package pl.pingwit.pingwitdentalmanager.service;

import org.springframework.stereotype.Service;
import pl.pingwit.pingwitdentalmanager.converter.DoctorConverter;
import pl.pingwit.pingwitdentalmanager.dto.DoctorDto;
import pl.pingwit.pingwitdentalmanager.entity.Doctor;
import pl.pingwit.pingwitdentalmanager.exceptionhandling.NotFoundException;
import pl.pingwit.pingwitdentalmanager.repository.DoctorRepository;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepository doctorRepository;
    private final DoctorConverter doctorConverter;

    public DoctorServiceImpl(DoctorRepository doctorRepository, DoctorConverter doctorConverter) {
        this.doctorRepository = doctorRepository;
        this.doctorConverter = doctorConverter;
    }

    @Override
    public List<DoctorDto> listDoctors() {
        return doctorRepository.findAll().stream()
                .map(doctorConverter::convertToDto)
                .toList();
    }

    @Override
    public Long createDoctor(DoctorDto inputDto) {
        Doctor savedDoctor = doctorRepository.save(doctorConverter.convertToEntity(inputDto));
        return savedDoctor.getId();
    }

    @Override
    public DoctorDto getDoctor(Long id) {
        Doctor doctor = doctorRepository.findById(id).
                orElseThrow(() -> new NotFoundException("Doctor with such id not found! Please, try again."));
        return doctorConverter.convertToDto(doctor);

    }

    @Override
    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }

    @Override
    public void updateDoctorRate(Long id, Doctor inputDto) {
        Doctor doctor = doctorRepository.findById(id).
                orElseThrow(() -> new NotFoundException("Doctor with such id not found! Please, try again."));

        if (inputDto.getName() != null) {
            doctor.setName(inputDto.getName());
        }
        if (inputDto.getSurname() != null) {
            doctor.setSurname(inputDto.getSurname());
        }
        if (inputDto.getPhone() != null) {
            doctor.setPhone(inputDto.getPhone());
        }
        if (inputDto.getSpecialty() != null) {
            doctor.setSpecialty(inputDto.getSpecialty());
        }
        if (inputDto.getRate() != null) {
            doctor.setRate(inputDto.getRate());
        }
        doctorRepository.save(doctor);
    }
}

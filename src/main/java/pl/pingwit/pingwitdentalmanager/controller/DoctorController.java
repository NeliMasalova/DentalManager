package pl.pingwit.pingwitdentalmanager.controller;

import org.springframework.web.bind.annotation.*;
import pl.pingwit.pingwitdentalmanager.dto.DoctorDto;
import pl.pingwit.pingwitdentalmanager.entity.Doctor;
import pl.pingwit.pingwitdentalmanager.service.DoctorService;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
    public List<DoctorDto> listDoctors() {
        return doctorService.listDoctors();
    }

    @GetMapping("/{id}")
    public DoctorDto getDoctor(@PathVariable(name = "id")Long id) {
        return doctorService.getDoctor(id);
    }

    @PostMapping
    public Long createDoctor(@RequestBody DoctorDto inputDto) {
        return doctorService.createDoctor(inputDto);
    }

    @PutMapping("/{id}")
    public void updateDoctor(@RequestBody Doctor inputDto, @PathVariable(name = "id") Long id) {
        doctorService.updateDoctorRate(id, inputDto);
    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable(name = "id") Long id) {
        doctorService.deleteDoctor(id);
    }
}
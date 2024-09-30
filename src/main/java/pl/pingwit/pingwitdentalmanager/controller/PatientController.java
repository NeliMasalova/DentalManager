package pl.pingwit.pingwitdentalmanager.controller;

import org.springframework.web.bind.annotation.*;
import pl.pingwit.pingwitdentalmanager.dto.CreatePatientInputDto;
import pl.pingwit.pingwitdentalmanager.dto.PatientDto;
import pl.pingwit.pingwitdentalmanager.dto.PatientShortDto;
import pl.pingwit.pingwitdentalmanager.entity.Patient;
import pl.pingwit.pingwitdentalmanager.service.PatientService;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public List<PatientShortDto> listPatients() {
        return patientService.listPatients();
    }

    @GetMapping("/{id}")
    public PatientDto getPatient(@PathVariable(name = "id") Long id) {
        return patientService.getPatient(id);
    }

    @PostMapping
    public Long createPatient(@RequestBody CreatePatientInputDto inputDto) {
        return patientService.createPatient(inputDto);
    }

    @PutMapping("/{id}")
    public void updatePatient(@RequestBody Patient inputDto, @PathVariable(name = "id") Long id) {
        patientService.updatePatient(id, inputDto);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable(name = "id") Long id) {
        patientService.deletePatient(id);
    }
}
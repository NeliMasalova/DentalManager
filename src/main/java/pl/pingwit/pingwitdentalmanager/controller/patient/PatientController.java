package pl.pingwit.pingwitdentalmanager.controller.patient;

import org.springframework.web.bind.annotation.*;
import pl.pingwit.pingwitdentalmanager.service.patient.PatientService;

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
}
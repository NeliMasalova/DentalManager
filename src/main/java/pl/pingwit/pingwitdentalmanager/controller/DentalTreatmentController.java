package pl.pingwit.pingwitdentalmanager.controller;

import org.springframework.web.bind.annotation.*;
import pl.pingwit.pingwitdentalmanager.converter.DentalTreatmentConverter;
import pl.pingwit.pingwitdentalmanager.dto.DentalTreatmentDto;
import pl.pingwit.pingwitdentalmanager.service.DentalTreatmentService;

import java.util.List;

@RestController
@RequestMapping("/service")
public class DentalTreatmentController {
    private final DentalTreatmentService dentalTreatmentService;

    public DentalTreatmentController(DentalTreatmentService dentalTreatmentService) {
        this.dentalTreatmentService = dentalTreatmentService;
    }

    @GetMapping("/{id}")
    public DentalTreatmentDto findTreatmentById(@PathVariable(name = "id") Long id) {
        return dentalTreatmentService.findTreatmentById(id);
    }

    @GetMapping
    public List<DentalTreatmentDto> listTreatments() {
        return dentalTreatmentService.listTreatments();
    }

    @PostMapping
    public Long createTreatment(@RequestBody DentalTreatmentDto inputDto) {
        return dentalTreatmentService.createTreatment(inputDto);
    }
}

package pl.pingwit.pingwitdentalmanager.controller;

import org.springframework.web.bind.annotation.*;
import pl.pingwit.pingwitdentalmanager.dto.AppointmentDto;
import pl.pingwit.pingwitdentalmanager.service.AppointmentService;

import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping
    public List<AppointmentDto> listAppointments() {
        return appointmentService.listAppointments();
    }

    @GetMapping("/{id}")
    public AppointmentDto getAppointmentByPatientId(@PathVariable(name = "id") Long patientId) {
        return appointmentService.getAppointmentByPatientId(patientId);
    }

    @PostMapping
    public Long createAppointment(@RequestBody AppointmentDto inputDto) {
        return appointmentService.createAppointment(inputDto);
    }

    @DeleteMapping
    public void deleteAppointment(@PathVariable(name = "id") Long id) {
        appointmentService.deleteAppointment(id);
    }
}
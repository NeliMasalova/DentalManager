package pl.pingwit.pingwitdentalmanager.controller.appointment;

import org.springframework.web.bind.annotation.*;
import pl.pingwit.pingwitdentalmanager.service.appointment.AppointmentService;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }
//TODO
//    @GetMapping
//    public List<AppointmentDto> listAppointments() {
//        return appointmentService.listAppointments();
//    }

    @GetMapping("/{id}")
    public AppointmentDto getAppointmentByPatientId(@PathVariable(name = "id") Long patientId) {
        return appointmentService.getAppointmentByPatientId(patientId);
    }

    @PostMapping
    public Long createAppointment(@RequestBody AppointmentDto inputDto) {
        return appointmentService.createAppointment(inputDto);
    }

    //TODO deleteAppointment
}

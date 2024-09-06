package pl.pingwit.pingwitdentalmanager.controller.appointment;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pingwit.pingwitdentalmanager.service.appointment.AppointmentService;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }
}

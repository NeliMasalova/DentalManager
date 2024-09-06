package pl.pingwit.pingwitdentalmanager.controller.doctor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pingwit.pingwitdentalmanager.service.doctor.DoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }
}

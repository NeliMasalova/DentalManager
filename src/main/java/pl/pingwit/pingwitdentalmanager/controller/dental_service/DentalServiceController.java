package pl.pingwit.pingwitdentalmanager.controller.dental_service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pingwit.pingwitdentalmanager.service.dental_service.DentalService;

@RestController
@RequestMapping("/service")
public class DentalServiceController {
    private final DentalService dentalService;

    public DentalServiceController(DentalService dentalService) {
        this.dentalService = dentalService;
    }
}

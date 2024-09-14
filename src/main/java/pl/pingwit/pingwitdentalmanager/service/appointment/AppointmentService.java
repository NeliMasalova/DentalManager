package pl.pingwit.pingwitdentalmanager.service.appointment;

import pl.pingwit.pingwitdentalmanager.controller.appointment.AppointmentDto;

public interface AppointmentService {
    AppointmentDto getAppointmentByPatientId(Long patientId);

    Long createAppointment(AppointmentDto inputDto);
}

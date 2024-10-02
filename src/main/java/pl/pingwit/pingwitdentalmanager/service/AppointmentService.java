package pl.pingwit.pingwitdentalmanager.service;

import pl.pingwit.pingwitdentalmanager.dto.AppointmentDto;

import java.util.List;

public interface AppointmentService {
    AppointmentDto getAppointmentByPatientId(Long patientId);

    Long createAppointment(AppointmentDto inputDto);

    void deleteAppointment(Long id);

    List<AppointmentDto> listAppointments();
}

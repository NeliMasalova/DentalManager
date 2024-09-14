package pl.pingwit.pingwitdentalmanager.service.appointment;

import pl.pingwit.pingwitdentalmanager.controller.appointment.AppointmentDto;
import pl.pingwit.pingwitdentalmanager.converter.AppointmentConverter;
import pl.pingwit.pingwitdentalmanager.repository.appointment.Appointment;
import pl.pingwit.pingwitdentalmanager.repository.appointment.AppointmentRepository;

public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final AppointmentConverter appointmentConverter;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository, AppointmentConverter appointmentConverter) {
        this.appointmentRepository = appointmentRepository;
        this.appointmentConverter = appointmentConverter;
    }

    @Override
    public AppointmentDto getAppointmentByPatientId(Long patientId) {
        Appointment appointment = appointmentRepository.findByPatientId(patientId).orElseThrow();
        return appointmentConverter.mapToDto(appointment);
    }

    @Override
    public Long createAppointment(AppointmentDto inputDto) {
        Appointment appointment = appointmentConverter.mapToEntity(inputDto);
        Appointment savedAppointment = appointmentRepository.save(appointment);
        return savedAppointment.getId();
    }
}
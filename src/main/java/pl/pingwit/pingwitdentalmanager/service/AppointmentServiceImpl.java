package pl.pingwit.pingwitdentalmanager.service;


import org.springframework.stereotype.Service;
import pl.pingwit.pingwitdentalmanager.dto.AppointmentDto;
import pl.pingwit.pingwitdentalmanager.converter.AppointmentConverter;
import pl.pingwit.pingwitdentalmanager.entity.Appointment;
import pl.pingwit.pingwitdentalmanager.exceptionhandling.NotFoundException;
import pl.pingwit.pingwitdentalmanager.repository.AppointmentRepository;

import java.util.List;


@Service
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final AppointmentConverter appointmentConverter;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository, AppointmentConverter appointmentConverter) {
        this.appointmentRepository = appointmentRepository;
        this.appointmentConverter = appointmentConverter;
    }

    @Override
    public AppointmentDto getAppointmentByPatientId(java.lang.Long patientId) {
        Appointment aAppointment = appointmentRepository.findByPatientId(patientId).
                orElseThrow(() -> new NotFoundException("Patient with such id not found. Please, try again."));
        return appointmentConverter.mapToDto(aAppointment);
    }

    @Override
    public java.lang.Long createAppointment(AppointmentDto inputDto) {
        Appointment aAppointment = appointmentConverter.mapToEntity(inputDto);
        Appointment savedAppointment = appointmentRepository.save(aAppointment);
        return savedAppointment.getId();
    }

    @Override
    public void deleteAppointment(java.lang.Long id) {
        appointmentRepository.deleteById(id);
    }

    @Override
    public List<AppointmentDto> listAppointments() {
        return appointmentRepository.findAll().stream()
                .map(appointmentConverter::mapToDto)
                .toList();
    }

    //    @PostConstruct
//    private void init() {
//        System.out.println(".");
//    }
}
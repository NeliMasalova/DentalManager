package pl.pingwit.pingwitdentalmanager.converter;

import pl.pingwit.pingwitdentalmanager.controller.appointment.AppointmentDto;
import pl.pingwit.pingwitdentalmanager.repository.appointment.Appointment;
import pl.pingwit.pingwitdentalmanager.repository.dental_service.DentalServiceRepository;
import pl.pingwit.pingwitdentalmanager.repository.doctor.Doctor;
import pl.pingwit.pingwitdentalmanager.repository.doctor.DoctorRepository;
import pl.pingwit.pingwitdentalmanager.repository.patient.Patient;
import pl.pingwit.pingwitdentalmanager.repository.patient.PatientRepository;
import pl.pingwit.pingwitdentalmanager.repository.dental_service.DentalService;

public class AppointmentConverter {
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    private final DentalServiceRepository dentalServiceRepository;
    public AppointmentConverter(PatientRepository patientRepository, DoctorRepository doctorRepository, DentalServiceRepository dentalServiceRepository) {
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
        this.dentalServiceRepository = dentalServiceRepository;
    }

    public AppointmentDto mapToDto(Appointment appointment) {
        AppointmentDto dto = new AppointmentDto();
        dto.setId(appointment.getId());
        dto.setDate(appointment.getDate());
        dto.setAppointmentStatus(appointment.getAppointmentStatus());
        dto.setPatient(appointment.getPatient());
        dto.setDoctor(appointment.getDoctor());
        dto.setDentalService(appointment.getDentalService());
        return dto;
    }

    public Appointment mapToEntity(AppointmentDto inputDto) {
        Appointment appointment = new Appointment();
        appointment.setDate(inputDto.getDate());
        appointment.setAppointmentStatus(inputDto.getAppointmentStatus());
        Patient patient = patientRepository.findById(inputDto.getPatient().getId()).orElseThrow();
        Doctor doctor = doctorRepository.findById(inputDto.getDoctor().getId()).orElseThrow();
        DentalService dentalService = dentalServiceRepository.findById(inputDto.getDentalService().getId()).orElseThrow();
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        appointment.setDentalService(dentalService);

        return appointment;
    }
}
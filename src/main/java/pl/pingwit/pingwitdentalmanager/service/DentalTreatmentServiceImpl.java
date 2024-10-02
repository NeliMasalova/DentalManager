package pl.pingwit.pingwitdentalmanager.service;

import org.springframework.stereotype.Service;
import pl.pingwit.pingwitdentalmanager.converter.DentalTreatmentConverter;
import pl.pingwit.pingwitdentalmanager.dto.DentalTreatmentDto;
import pl.pingwit.pingwitdentalmanager.entity.DentalTreatment;
import pl.pingwit.pingwitdentalmanager.exceptionhandling.NotFoundException;
import pl.pingwit.pingwitdentalmanager.repository.DentalTreatmentRepository;

import java.util.List;

@Service
public class DentalTreatmentServiceImpl implements DentalTreatmentService {
    private final DentalTreatmentConverter dentalTreatmentConverter;
    private final DentalTreatmentRepository dentalTreatmentRepository;

    public DentalTreatmentServiceImpl(DentalTreatmentConverter dentalTreatmentConverter, DentalTreatmentRepository dentalTreatmentRepository) {
        this.dentalTreatmentConverter = dentalTreatmentConverter;
        this.dentalTreatmentRepository = dentalTreatmentRepository;
    }

    @Override
    public DentalTreatmentDto findTreatmentById(Long id) {
        DentalTreatment dentalTreatment = dentalTreatmentRepository.findById(id).
                orElseThrow(() -> new NotFoundException("Treatment with such id not found! Please, try again."));
        return dentalTreatmentConverter.convertToDto(dentalTreatment);
    }

    @Override
    public List<DentalTreatmentDto> listTreatments() {
        return dentalTreatmentRepository.findAll().stream()
                .map(dentalTreatmentConverter::convertToDto)
                .toList();
    }

    @Override
    public Long createTreatment(DentalTreatmentDto inputDto) {
        DentalTreatment saveDentalTreatment = dentalTreatmentRepository.save(dentalTreatmentConverter.convertToEntity(inputDto));
        return saveDentalTreatment.getId();
    }
}

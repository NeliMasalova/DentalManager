package pl.pingwit.pingwitdentalmanager.converter;

import org.springframework.stereotype.Component;
import pl.pingwit.pingwitdentalmanager.dto.DentalTreatmentDto;
import pl.pingwit.pingwitdentalmanager.entity.DentalTreatment;

@Component
public class DentalTreatmentConverter {
    public DentalTreatmentDto convertToDto(DentalTreatment treatment) {
        return new DentalTreatmentDto(
                treatment.getName(),
                treatment.getDescription(),
                treatment.getPrice());
    }

    public DentalTreatment convertToEntity(DentalTreatmentDto inputDto) {
        DentalTreatment dentalTreatment = new DentalTreatment();
        dentalTreatment.setName(inputDto.getName());
        dentalTreatment.setDescription(inputDto.getDescription());
        dentalTreatment.setPrice(inputDto.getPrice());

        return dentalTreatment;
    }
}

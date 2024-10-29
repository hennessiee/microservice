package micro.facilityservice.business.impl;

import lombok.RequiredArgsConstructor;
import micro.facilityservice.business.CreateFacilityUseCase;
import micro.facilityservice.domain.facility.CreateFacilityResponse;
import micro.facilityservice.domain.facility.CreateFacilityRequest;
import micro.facilityservice.persistence.FacilityRepository;
import micro.facilityservice.persistence.entity.FacilityEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateFacilityUseCaseImpl implements CreateFacilityUseCase {
    private final FacilityRepository facilityRepository;

    public CreateFacilityResponse createFacility(CreateFacilityRequest request){
        FacilityEntity facilityEntity =new FacilityEntity();
        facilityEntity.setName(request.getName());
        facilityEntity.setDescription(request.getDescription());
        facilityEntity.setRegion(request.getRegion());
        facilityEntity.setAddress(request.getAddress());

        FacilityEntity savedFacilityEntity= facilityRepository.save(facilityEntity);



        return new CreateFacilityResponse(savedFacilityEntity.getId());
    }

}

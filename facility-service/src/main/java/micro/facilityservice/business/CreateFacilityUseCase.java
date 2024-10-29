package micro.facilityservice.business;

import micro.facilityservice.domain.facility.CreateFacilityRequest;
import micro.facilityservice.domain.facility.CreateFacilityResponse;

public interface CreateFacilityUseCase {
    CreateFacilityResponse createFacility(CreateFacilityRequest request);
}

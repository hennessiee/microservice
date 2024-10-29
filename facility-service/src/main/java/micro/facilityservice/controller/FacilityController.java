package micro.facilityservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import micro.facilityservice.business.CreateFacilityUseCase;
import micro.facilityservice.domain.facility.CreateFacilityRequest;
import micro.facilityservice.domain.facility.CreateFacilityResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins="http://localhost:5173",allowedHeaders="*")
@RequestMapping("/facility")
public class FacilityController {
private final CreateFacilityUseCase createFacilityUseCase;

    @PostMapping("/create")
    public ResponseEntity<CreateFacilityResponse> register(@RequestBody @Valid CreateFacilityRequest createFacilityRequest){
        CreateFacilityResponse response =createFacilityUseCase.createFacility(createFacilityRequest);

        return ResponseEntity.ok(response);
    }
}

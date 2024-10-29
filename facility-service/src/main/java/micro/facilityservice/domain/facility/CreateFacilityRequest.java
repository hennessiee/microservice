package micro.facilityservice.domain.facility;


import lombok.Data;


@Data
public class CreateFacilityRequest {
    String name;
    String description;
    String region;
    String address;
}

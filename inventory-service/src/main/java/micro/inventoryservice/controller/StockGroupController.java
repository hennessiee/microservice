package micro.inventoryservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import micro.inventoryservice.business.CreateStockGroupUseCase;
import micro.inventoryservice.business.GetStockGroupByIdUseCase;
import micro.inventoryservice.domain.stock.GetStockByIdResponse;
import micro.inventoryservice.domain.stockgroup.CreateStockGroupRequest;
import micro.inventoryservice.domain.stockgroup.CreateStockGroupResponse;
import micro.inventoryservice.domain.stockgroup.GetStockGroupByIdResponse;
import micro.inventoryservice.domain.stockgroup.StockGroup;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "*")
@RestController
@RequestMapping("/stockgroup")
@RequiredArgsConstructor
public class StockGroupController {
    private final CreateStockGroupUseCase createStockGroupUseCase;
    private final GetStockGroupByIdUseCase getStockGroupByIdUseCase;

    @PostMapping("/create")
    public ResponseEntity<CreateStockGroupResponse> createStock(@RequestBody @Valid CreateStockGroupRequest createStockGroupRequest){
        CreateStockGroupResponse response =createStockGroupUseCase.createStockGroup(createStockGroupRequest);
        URI location = URI.create("/stockgroup/" + response.getId()); // Replace with the correct URI structure

        return ResponseEntity.created(location).body(response);
    }
    @GetMapping("/{id}")
    public ResponseEntity<StockGroup> getStockGroupById(@PathVariable Long id) {
        StockGroup stockGroupResponse = getStockGroupByIdUseCase.getStockGroupById(id);

        return ResponseEntity.ok(stockGroupResponse);

    }
}

package micro.inventoryservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import micro.inventoryservice.business.CreateStockUseCase;
import micro.inventoryservice.business.GetStockByIdUseCase;

import micro.inventoryservice.domain.stock.CreateStockRequest;
import micro.inventoryservice.domain.stock.CreateStockResponse;
import micro.inventoryservice.domain.stock.GetStockByIdResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "*")
@RestController
@RequestMapping("/stock")
@RequiredArgsConstructor
public class StockController {
    private final CreateStockUseCase createStockUseCase;
    private final GetStockByIdUseCase getStockByIdUseCase;

    @PostMapping("/create")
    public ResponseEntity<CreateStockResponse> createStock(@RequestBody @Valid CreateStockRequest createStockRequest){
        CreateStockResponse response =createStockUseCase.createStock(createStockRequest);

        return ResponseEntity.ok(response);
    }
    @GetMapping("/{id}")
    public ResponseEntity<GetStockByIdResponse> getStockById(@PathVariable Long id) {
        GetStockByIdResponse stockResponse = getStockByIdUseCase.getStockById(id);
        return ResponseEntity.ok(stockResponse);
    }

}

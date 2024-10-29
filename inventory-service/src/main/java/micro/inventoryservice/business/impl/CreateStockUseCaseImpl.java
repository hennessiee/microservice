package micro.inventoryservice.business.impl;

import lombok.RequiredArgsConstructor;
import micro.inventoryservice.business.CreateStockUseCase;

import micro.inventoryservice.domain.stock.CreateStockRequest;
import micro.inventoryservice.domain.stock.CreateStockResponse;
import micro.inventoryservice.persistence.*;
import micro.inventoryservice.persistence.entity.*;

import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CreateStockUseCaseImpl implements CreateStockUseCase {
    private final StockRepository stockRepository;
    private final StockGroupRepository stockGroupRepository;
    public CreateStockResponse createStock(CreateStockRequest request) {
        StockEntity stockEntity = new StockEntity();

        stockEntity.setName(request.getName());
        stockEntity.setDescription(request.getDescription());
        stockEntity.setUnit(request.getUnit());
        stockEntity.setManufacturer(request.getManufacturer());
        stockEntity.setSellingPrice(request.getSellingPrice());
        stockEntity.setCostPrice(request.getCostPrice());
        stockEntity.setQuantity(request.getQuantity());
        stockEntity.setReorderPoint(request.getReorderPoint());
        stockEntity.setType(request.getType());

        // Set the optional StockGroupEntity if the stockGroupId is provided
        if (request.getStockGroupId() != null) {
            StockGroupEntity stockGroup = stockGroupRepository.findById(request.getStockGroupId())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid stock group ID"));
            stockEntity.setStockGroup(stockGroup);
        }
        StockEntity savedStockEntity=stockRepository.save(stockEntity);

        return new CreateStockResponse(savedStockEntity.getId());

    }
}

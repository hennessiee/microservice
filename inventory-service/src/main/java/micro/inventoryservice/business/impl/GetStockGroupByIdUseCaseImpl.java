package micro.inventoryservice.business.impl;

import lombok.RequiredArgsConstructor;
import micro.inventoryservice.business.GetStockGroupByIdUseCase;
import micro.inventoryservice.domain.stockgroup.GetStockGroupByIdResponse;
import micro.inventoryservice.domain.stockgroup.StockGroup;
import micro.inventoryservice.persistence.StockGroupRepository;

import micro.inventoryservice.persistence.entity.StockGroupEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetStockGroupByIdUseCaseImpl implements GetStockGroupByIdUseCase {
    private final StockGroupRepository stockGroupRepository;
    @Override
    public StockGroup getStockGroupById(Long id) {
        StockGroupEntity stockGroupEntity = stockGroupRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Stock not found with id: " + id));
        return new StockGroup(stockGroupEntity);
    }
}

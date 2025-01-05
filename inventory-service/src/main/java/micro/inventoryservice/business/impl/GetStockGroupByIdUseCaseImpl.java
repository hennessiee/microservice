package micro.inventoryservice.business.impl;

import lombok.RequiredArgsConstructor;
import micro.inventoryservice.business.GetStockGroupByIdUseCase;
import micro.inventoryservice.domain.stock.StockDTO;
import micro.inventoryservice.domain.stockgroup.GetStockGroupByIdResponse;
import micro.inventoryservice.domain.stockgroup.StockGroup;
import micro.inventoryservice.domain.stockgroup.StockGroupDTO;
import micro.inventoryservice.persistence.StockGroupRepository;

import micro.inventoryservice.persistence.entity.StockEntity;
import micro.inventoryservice.persistence.entity.StockGroupEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetStockGroupByIdUseCaseImpl implements GetStockGroupByIdUseCase {
    private final StockGroupRepository stockGroupRepository;
    @Override
    public StockGroupDTO getStockGroupById(Long id) {
        StockGroupEntity stockGroupEntity = stockGroupRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Stock not found with id: " + id));

        List<StockEntity> stockEntities = stockGroupEntity.getStocks();
        List<StockDTO> stockDTOs = stockEntities.stream()
                .map(stock -> new StockDTO(stock.getId(), stock.getName(), stock.getQuantity())) // Only required fields
                .toList();
        return new StockGroupDTO(stockGroupEntity.getId(), stockGroupEntity.getName(), stockGroupEntity.getDescription(), stockDTOs);
    }
}

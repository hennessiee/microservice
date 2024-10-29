package micro.inventoryservice.business.impl;

import lombok.RequiredArgsConstructor;
import micro.inventoryservice.business.GetStockByIdUseCase;
import micro.inventoryservice.domain.stock.GetStockByIdResponse;
import micro.inventoryservice.persistence.StockRepository;
import micro.inventoryservice.persistence.entity.StockEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetStockByIdUseCaseImpl implements GetStockByIdUseCase {
    private final StockRepository stockRepository;
    @Override
    public GetStockByIdResponse getStockById(Long id) {
        StockEntity stockEntity = stockRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Stock not found with id: " + id));
        return new GetStockByIdResponse(stockEntity);
    }
}

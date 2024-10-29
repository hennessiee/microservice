package micro.inventoryservice.business;

import micro.inventoryservice.domain.stock.CreateStockRequest;
import micro.inventoryservice.domain.stock.CreateStockResponse;

public interface CreateStockUseCase {
CreateStockResponse createStock(CreateStockRequest request);
}

package micro.inventoryservice.business;

import micro.inventoryservice.domain.stock.GetStockByIdResponse;

public interface GetStockByIdUseCase {
    GetStockByIdResponse getStockById(Long id);
}

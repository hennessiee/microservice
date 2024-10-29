package micro.inventoryservice.business;

import micro.inventoryservice.domain.stockgroup.GetStockGroupByIdResponse;
import micro.inventoryservice.domain.stockgroup.StockGroup;

public interface GetStockGroupByIdUseCase {
    StockGroup getStockGroupById(Long id);

}

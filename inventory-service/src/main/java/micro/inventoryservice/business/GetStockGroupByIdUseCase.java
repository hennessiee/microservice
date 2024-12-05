package micro.inventoryservice.business;

import micro.inventoryservice.domain.stockgroup.GetStockGroupByIdResponse;
import micro.inventoryservice.domain.stockgroup.StockGroup;
import micro.inventoryservice.domain.stockgroup.StockGroupDTO;

public interface GetStockGroupByIdUseCase {
    StockGroupDTO getStockGroupById(Long id);

}

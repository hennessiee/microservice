package micro.inventoryservice.business;

import micro.inventoryservice.domain.stockgroup.CreateStockGroupRequest;
import micro.inventoryservice.domain.stockgroup.CreateStockGroupResponse;

public interface CreateStockGroupUseCase {
    CreateStockGroupResponse createStockGroup(CreateStockGroupRequest request);
}

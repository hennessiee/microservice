package micro.inventoryservice.business.impl;

import lombok.RequiredArgsConstructor;
import micro.inventoryservice.business.CreateStockGroupUseCase;
import micro.inventoryservice.business.impl.producer.StockGroupProducer;
import micro.inventoryservice.domain.stockgroup.CreateStockGroupRequest;
import micro.inventoryservice.domain.stockgroup.CreateStockGroupResponse;
import micro.inventoryservice.persistence.StockGroupRepository;
import micro.inventoryservice.persistence.entity.StockGroupEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateStockGroupUseCaseImpl implements CreateStockGroupUseCase {
    private final StockGroupRepository stockGroupRepository;
    private final StockGroupProducer stockGroupProducer;
    public CreateStockGroupResponse createStockGroup(CreateStockGroupRequest request) {
        StockGroupEntity stockGroupEntity = new StockGroupEntity();
        stockGroupEntity.setName(request.getName());
        stockGroupEntity.setDescription(request.getDescription());
        stockGroupEntity.setUnit(request.getUnit());


        StockGroupEntity savedStockGroup = stockGroupRepository.save(stockGroupEntity);
        stockGroupProducer.sendStockGroupCreatedNotification(savedStockGroup.getId());



        return new CreateStockGroupResponse(savedStockGroup.getId());
    }
}

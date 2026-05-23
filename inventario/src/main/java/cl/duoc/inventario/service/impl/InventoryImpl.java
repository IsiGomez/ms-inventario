package cl.duoc.inventario.service.impl;
import cl.duoc.inventario.dto.remote.ProductDto;
import cl.duoc.inventario.dto.request.InventoryRequestDto;
import cl.duoc.inventario.dto.response.InventoryResponseDto;
import cl.duoc.inventario.mapper.InventoryMapper;
import cl.duoc.inventario.model.Inventory;
import cl.duoc.inventario.repository.InventoryRepository;
import cl.duoc.inventario.service.InventoryService;
import cl.duoc.inventario.service.api.CatalogoClient;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InventoryImpl implements InventoryService {

    private final InventoryRepository repository;

    private final CatalogoClient catalogoClient;

    private final InventoryMapper mapper;

    @Override
    @Transactional(readOnly = true)
    public InventoryResponseDto consultarStock(Long productId){
        Inventory inventory = repository.findByProductId(productId)
                .orElseThrow(() -> new EntityNotFoundException("El producto con ID " + productId + " no esta registrado en el inventario"));

        ProductDto product = catalogoClient.obtenerProductoPorId(productId);

        return mapper.toDto(inventory, product);

    }


    @Override
    @Transactional
    public InventoryResponseDto actualizarStock(InventoryRequestDto request){

        ProductDto product = catalogoClient.obtenerProductoPorId(request.getProductId());

        Optional<Inventory> inventoryExists = repository.findByProductId(request.getProductId());

        Inventory inventory;

        if (inventoryExists.isPresent()){
            inventory = inventoryExists.get();
            inventory.setQuantity(request.getQuantity());
        } else {
            inventory = mapper.toEntity(request);
        }

        repository.save(inventory);

        return mapper.toDto(inventory, product);

    }

}

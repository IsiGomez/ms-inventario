package cl.duoc.inventario.controller;
import cl.duoc.inventario.dto.request.InventoryRequestDto;
import cl.duoc.inventario.dto.response.InventoryResponseDto;
import cl.duoc.inventario.service.InventoryService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService service;

    @Operation(summary = "Obtener el stock de un producto",
            tags = {"Módulo de Inventario → 1. Consultas de Inventario"})
    @GetMapping("/product/{productId}")
    public ResponseEntity<InventoryResponseDto> getStock(@PathVariable Long productId){
        return ResponseEntity.ok(service.consultarStock(productId));
    }

    @Operation(summary = "Actualizar stock de producto",
            tags = {"Módulo de Inventario → 2. Acciones de Inventario"})
    @PatchMapping("/update")
    public ResponseEntity<InventoryResponseDto> updateStock(@Valid @RequestBody InventoryRequestDto request){
        return ResponseEntity.ok(service.actualizarStock(request));
    }

}

package cl.duoc.inventario.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter             @Setter
@AllArgsConstructor @NoArgsConstructor
public class InventoryRequestDto {

    @NotNull(message = "La ID del producto es obligatoria")
    private Long productId;

    @NotNull
    @Min(value = 0, message = "El stock no puede ser menor a 0")
    @Max(value = 150, message = "El stock no puede ser mayor a 150 para un producto")
    private Integer quantity;

}

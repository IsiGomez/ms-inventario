package cl.duoc.inventario.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter             @Setter
@AllArgsConstructor @NoArgsConstructor
public class InventoryResponseDto {

    private Long id;
    private Long productId;
    private String productName;
    private Integer priceUnit;
    private Integer quantity;

}

package cl.duoc.inventario.dto.remote;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter             @Setter
@AllArgsConstructor @NoArgsConstructor
public class ItemCompradoDto {

    private Long productId;
    private Integer quantity;

}

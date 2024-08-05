package br.com.comada.comanda_api.DTOs;

import br.com.comada.comanda_api.entities.Mesa;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Data
@Getter
@Setter
public class PedidoDTO {

    private String pedido;
    private BigDecimal preco;
    private int quantidade;

    private Mesa IdMesa;

}

package br.com.comada.comanda_api.DTOs;

import br.com.comada.comanda_api.entities.Pedido;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MesaDTO {

    private int numero;

    private String titular;

}

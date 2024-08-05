package br.com.comada.comanda_api.entities;

import br.com.comada.comanda_api.DTOs.MesaDTO;
import br.com.comada.comanda_api.DTOs.PedidoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Mesa{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private int numero;

    private String titular;

//    @OneToMany(cascade =CascadeType.ALL, mappedBy = "mesa")
//    private List<Pedido> pedido;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updateAt;

    public Mesa(MesaDTO mesa) {
        setTitular(mesa.getTitular());
        setNumero(mesa.getNumero());
    }

}

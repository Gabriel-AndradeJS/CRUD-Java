package br.com.comada.comanda_api.services;

import br.com.comada.comanda_api.entities.Pedido;
import br.com.comada.comanda_api.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    public ResponseEntity<Pedido> validateCreatePedido(Pedido pedido) {

        if (pedido.getPedidos() == null || pedido.getPedidos().isEmpty()) {
            throw new IllegalArgumentException("Pedido não pode ser nulo ou vazio.");
        }
//        if (pedido.getMesa() == null){
//            throw new IllegalArgumentException("Informe o id da mesa.");
//        }

        if (pedido.getQuantidade() <= 0 ) {
            throw new IllegalArgumentException("Insira a quantidade.");
        }

        repository.save(pedido);

        return ResponseEntity.ok(pedido);

    }


    public List<Pedido> findAllPedidos() {
        List<Pedido> all = this.repository.findAll();
        return all;
    }

    public ResponseEntity<Void> delete(Long id) {
        this.repository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    public Pedido atualizarPedido(Long id, Pedido pedido)  {
        Pedido newPedido = this.repository.findById(id).get();

        if (newPedido == null){
            throw new NullPointerException("Esse pedido não existe");
        }

        newPedido.setPedidos(pedido.getPedidos());

        return this.repository.save(newPedido);
    }

    public Iterable<Pedido> buscaPaginada(int pagina, int qtd) {
        Pageable page = PageRequest.of(pagina, qtd);
        return this.repository.findAll(page);
    }


}

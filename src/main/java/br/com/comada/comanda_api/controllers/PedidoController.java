package br.com.comada.comanda_api.controllers;

import br.com.comada.comanda_api.entities.Pedido;
import br.com.comada.comanda_api.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comanda/pedidos")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public List<Pedido> allPedidos() {
        return this.pedidoService.findAllPedidos();
    }
    @GetMapping("/{pagina}/{qtd}")
    public Iterable<Pedido> pedidosPaginado(@PathVariable int pagina, @PathVariable int qtd){
        return this.pedidoService.buscaPaginada(pagina, qtd);
    }

    @PostMapping
    public ResponseEntity<Pedido> createPedido(@RequestBody Pedido pedido){
        return this.pedidoService.validateCreatePedido(pedido);
    }

    @PutMapping("/{id}")
    public Pedido updatePedido(@PathVariable Long id, @RequestBody Pedido pedido){
        return this.pedidoService.atualizarPedido(id, pedido);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePedido(@PathVariable Long id) {
        return this.pedidoService.delete(id);
    }
}

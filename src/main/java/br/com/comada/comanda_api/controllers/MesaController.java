package br.com.comada.comanda_api.controllers;

import br.com.comada.comanda_api.entities.Mesa;
import br.com.comada.comanda_api.DTOs.MesaDTO;
import br.com.comada.comanda_api.services.MesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comanda/mesa")
public class MesaController {

    @Autowired
    private MesaService mesaService;

    @GetMapping
    public List<Mesa> allMesa() {
        List<Mesa> mesas = this.mesaService.findAllMesa();
        return mesas;
    }

    @GetMapping("/{id}")
    public Mesa findById(@PathVariable Long id) {
        Mesa mesa = this.mesaService.findById(id);
        return mesa;
    }

    @GetMapping(value = "/{numeroPagina}/{qtdPagina}")
    public Iterable<Mesa> MesaPaginada(@PathVariable int numeroPagina, @PathVariable int qtdPagina) {
        Iterable<Mesa> mesas = this.mesaService.mesaPaginadaService(numeroPagina, qtdPagina);
        return mesas;
    }

    @GetMapping("/buscar/{nome}")
    public Mesa buscarPorNomeController(@PathVariable String nome) {
        return this.mesaService.buscarNomeMesa(nome);
    }

    @PostMapping
    public ResponseEntity<MesaDTO> createMesa(@RequestBody MesaDTO mesa) {
        return this.mesaService.validateCreateMesa(mesa);
    }

    @PutMapping("/{id}")
    public Mesa updateMesa(@PathVariable Long id, @RequestBody Mesa mesa) {
      return  this.mesaService.atualizarMesa(id, mesa);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirMesa(@PathVariable Long id) {
      return   this.mesaService.deleteMesa(id);
    }
}

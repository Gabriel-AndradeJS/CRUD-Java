package br.com.comada.comanda_api.services;

import br.com.comada.comanda_api.entities.Mesa;
import br.com.comada.comanda_api.DTOs.MesaDTO;
import br.com.comada.comanda_api.repositories.MesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.http.HttpResponse;
import java.util.List;

@Service
public class MesaService {

    @Autowired
    private MesaRepository repository;
    public ResponseEntity<MesaDTO> validateCreateMesa(MesaDTO mesa) {

        if (mesa.getTitular() == null || mesa.getTitular().isEmpty() || mesa.getNumero() <= 0) {
            throw new IllegalArgumentException("A mesa precisa de um número válido e o nome do titular.");
        }

        Mesa newMesa = new Mesa(mesa);
        this.repository.save(newMesa);
        return ResponseEntity.ok(mesa);
    }

    public List<Mesa> findAllMesa() {
        List<Mesa> allMesa = this.repository.findAll();
        return allMesa;
    }

    public Iterable<Mesa> mesaPaginadaService(int numero, int qtd) {
        if(qtd >= 15) qtd = 15;
        Pageable page = PageRequest.of(numero, qtd);
       return this.repository.findAll(page);
    }

    public Mesa buscarNomeMesa(String nome) {
        return this.repository.findByTitularContainingIgnoreCase(nome);
    }

    public Mesa atualizarMesa(Long id, Mesa mesa){
       Mesa newMesa =  this.repository.findById(id).get();
        newMesa.setNumero(mesa.getNumero());
        newMesa.setTitular(mesa.getTitular());
       return this.repository.save(newMesa);
    }

    public ResponseEntity<Void> deleteMesa(Long id) {
        this.repository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    public Mesa findById(Long id) {

        Mesa mesa = this.repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mesa não encontrada"));

        return mesa;
    }
}

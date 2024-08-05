package br.com.comada.comanda_api.repositories;

import br.com.comada.comanda_api.entities.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface MesaRepository extends JpaRepository<Mesa, Long>{
    Mesa findByTitularContainingIgnoreCase(String parteNome);
}

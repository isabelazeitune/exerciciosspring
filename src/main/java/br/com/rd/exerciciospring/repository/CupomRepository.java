package br.com.rd.exerciciospring.repository;

import br.com.rd.exerciciospring.entity.Cupom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CupomRepository extends JpaRepository<Cupom, Long> {

    List<Cupom> findByIdClienteAndDtVenda(Long idCliente, String dtVenda);
    List<Cupom> findByIdCliente(Long idCliente);
    List<Cupom> findByDtVenda(String dtVenda);
}
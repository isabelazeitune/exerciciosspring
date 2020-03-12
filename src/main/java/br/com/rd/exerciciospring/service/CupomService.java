package br.com.rd.exerciciospring.service;

import br.com.rd.exerciciospring.entity.Cupom;
import br.com.rd.exerciciospring.entity.CupomItem;
import br.com.rd.exerciciospring.repository.CupomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("CupomService")
public class CupomService {

    @Autowired
    CupomRepository cupomRepository;

    public ResponseEntity save (Cupom cupom) {

        Cupom cupomEntity = new Cupom();
        cupomEntity.setDtVenda(cupom.getDtVenda());
        cupomEntity.setVlVenda(cupom.getVlVenda());
        cupomEntity.setIdCliente(cupom.getIdCliente());

        List<CupomItem> listaItens = new ArrayList<>();

        for(CupomItem cItem: cupom.getCupomItem()) {
            CupomItem it = new CupomItem();
            it.setQtProduto(cItem.getQtProduto());
            it.setVlProduto(cItem.getVlProduto());

            listaItens.add(it);
        }

        cupomEntity.setCupomItem(listaItens);

        Cupom retorno = cupomRepository.save(cupomEntity);

        cupom.setIdCupom(retorno.getIdCupom());
        return ResponseEntity.ok().body(cupom);
    }
}

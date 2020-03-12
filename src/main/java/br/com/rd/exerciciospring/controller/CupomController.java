package br.com.rd.exerciciospring.controller;

import br.com.rd.exerciciospring.entity.Cupom;
import br.com.rd.exerciciospring.repository.CupomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CupomController {

    @Autowired
    CupomRepository cupomRepository;

    @GetMapping("/cupom")
    public ResponseEntity<List<Cupom>> findById(@PathParam("idCliente") Long id,
                                                @PathParam("dtVenda") String dt) {

        List<Cupom> cupom = new ArrayList<>();

        if (id != null && dt != null)
            cupom = cupomRepository.findByIdClienteAndDtVenda(id, dt);
        else if (id != null)
            cupom = cupomRepository.findByIdCliente(id);
        else if (dt != null)
            cupom = cupomRepository.findByDtVenda(dt);

        if (cupom != null && cupom.size() > 0)
            return ResponseEntity.ok().body(cupom);
        else
            return ResponseEntity.badRequest().build();
    }
}

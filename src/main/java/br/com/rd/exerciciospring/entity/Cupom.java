package br.com.rd.exerciciospring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tb_cupom")
public class Cupom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_cupom")
    private Long idCupom;

    @Column(name="id_cliente")
    private Long idCliente;

    @Column(name="dt_venda")
    private String dtVenda;

    @Column(name="vl_venda")
    private BigDecimal vlVenda;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="cupom")
    private List<CupomItem> cupomItem;

}

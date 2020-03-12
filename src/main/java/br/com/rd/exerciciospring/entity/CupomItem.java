package br.com.rd.exerciciospring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tb_cupom_item")
public class CupomItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_cupom_item")
    private Long idCupomItem;

    @Column(name="id_cupom")
    private Long cupom;

    @Column(name="id_produto")
    private Long produto;

    @Column(name="qt_produto")
    private Long qtProduto;

    @Column(name="vl_produto")
    private BigDecimal vlProduto;

}

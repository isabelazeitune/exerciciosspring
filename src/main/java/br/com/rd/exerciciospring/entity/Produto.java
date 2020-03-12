package br.com.rd.exerciciospring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tb_produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_produto")
    private Long idProduto;

    @Column(name="ds_produto")
    private String dsProduto;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="produto")
    private List<CupomItem> produtoItem;
}

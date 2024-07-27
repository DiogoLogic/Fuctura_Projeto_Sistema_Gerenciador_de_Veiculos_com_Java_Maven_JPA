package br.com.fuctura.model.entidades;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "veiculo")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_veiculo")
    private Long codigo;

    @Column(name = "marca", nullable = false, length = 50)
    private String marca;

    @Column(name = "modelo", nullable = false, length = 50)
    private String modelo;

    @Column(name = "ano", nullable = false)
    private Integer ano;

    @Column(name = "preco", nullable = false)
    private BigDecimal preco;

    @ManyToOne
    @JoinColumn(name = "tipo_codigo")
    private Tipo tipo;

    @ManyToOne
    @JoinColumn(name = "loja_codigo")
    private Loja loja;
}

package br.com.fuctura.model.entidades;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "loja")
public class Loja {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_loja")
    private Integer codigoLoja;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;
    
    @Column(name = "cnpj", nullable = false, unique = true, length = 14)
    private String cnpj;

    @Column(name = "telefone", length = 15)
    private String telefone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_codigo")
    private Endereco endereco;

    @OneToMany(mappedBy = "loja")
    private List<Vendedor> vendedores;

    @OneToMany(mappedBy = "loja")
    private List<Venda> vendas;
}

package br.com.fuctura.model.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "Endereco")
@NoArgsConstructor
@Data
public class Endereco {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "codigo_endereco")
	    private Long codigo;

	    @Column(name = "cep", nullable = false, length = 8)
	    private String cep;

	    @Column(name = "logradouro", nullable = false, length = 255)
	    private String logradouro;

	    @Column(name = "complemento", length = 100)
	    private String complemento;

	    @Column(name = "numero")
	    private Integer numero;
}

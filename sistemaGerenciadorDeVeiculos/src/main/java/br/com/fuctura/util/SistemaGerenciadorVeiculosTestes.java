package br.com.fuctura.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.fuctura.execeptions.CepInvalidoException;
import br.com.fuctura.model.entidades.Endereco;



public class SistemaGerenciadorVeiculosTestes {

    private EnderecoService enderecoService;

    @BeforeEach
    public void setup() {
        enderecoService = new EnderecoService();
    }

    @Test
    public void testBuscarEnderecoPorCepValido() throws Exception { // Removido throws CepInvalidoException
        String cepValido = "01001000"; // CEP válido sem hífen

        Endereco endereco = enderecoService.buscarEnderecoPorCep(cepValido);

        assertNotNull(endereco, "O endereço não deve ser nulo para um CEP válido.");
        assertEquals("01001000", endereco.getCep().replaceAll("-", ""));
        assertEquals("Praça da Sé", endereco.getLogradouro());
        assertEquals("lado ímpar", endereco.getComplemento()); 

        // Verifica se o número existe antes de comparar
        if (endereco.getNumero() != null) {
            //assertEquals(Integer.valueOf(1), endereco.getNumero());
        } else {
            System.out.println("Aviso: A API não retornou o número do endereço.");
        }
        System.out.println(endereco);
    }

    @Test
    public void testBuscarEnderecoPorCepInvalido() {
        String cepInvalido = "00000000"; // CEP inválido

        assertThrows(CepInvalidoException.class, () -> {
            enderecoService.buscarEnderecoPorCep(cepInvalido);
        }); // Espera que uma CepInvalidoException seja lançada
    }
}
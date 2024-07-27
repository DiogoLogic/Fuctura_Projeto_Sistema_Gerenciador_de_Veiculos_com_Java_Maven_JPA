package br.com.fuctura.controller;

public class EnderecoController {

    private final EnderecoRepository enderecoRepository;

    public EnderecoController(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public void salvar(Endereco endereco) {
        enderecoRepository.salvar(endereco);
    }

    public void atualizar(Endereco endereco) {
        enderecoRepository.atualizar(endereco);
    }

    public void deletar(Endereco endereco) {
        enderecoRepository.deletar(endereco);
    }

    public Endereco buscarPorCEP(String cep) {
        return enderecoRepository.buscarPorCEP(cep);
    }

    public List<Endereco> listar() {
        return enderecoRepository.listar();
    }
}

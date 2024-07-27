package br.com.fuctura.controller;

import java.util.List;

import br.com.fuctura.model.entidades.Vendedor;
import br.com.fuctura.repository.impl.VendedorRepository;

public class VendedorController {

    private final VendedorRepository vendedorRepository;

    public VendedorController(VendedorRepository vendedorRepository) {
        this.vendedorRepository = vendedorRepository;
    }

    public void salvar(Vendedor vendedor) {
        vendedorRepository.salvar(vendedor);
    }

    public void atualizar(Vendedor vendedor) {
        vendedorRepository.atualizar(vendedor);
    }

    public void deletar(Vendedor vendedor) {
        vendedorRepository.deletar(vendedor);
    }

    public Vendedor buscarPorCPF(String cpf) {
        return vendedorRepository.buscarPorCPF(cpf);
    }

    public List<Vendedor> listar() {
        return vendedorRepository.listar();
    }
}

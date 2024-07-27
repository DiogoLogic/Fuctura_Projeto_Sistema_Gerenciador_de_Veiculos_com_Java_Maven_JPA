package br.com.fuctura.repository.interfaces;

import br.com.fuctura.model.entidades.Venda;
import java.util.List;

public interface IVendaRepository {

    void salvar(Venda venda);

    void atualizar(Venda venda);

    void deletar(Venda venda);

    Venda buscarPorId(Long id);

    List<Venda> listar();
}

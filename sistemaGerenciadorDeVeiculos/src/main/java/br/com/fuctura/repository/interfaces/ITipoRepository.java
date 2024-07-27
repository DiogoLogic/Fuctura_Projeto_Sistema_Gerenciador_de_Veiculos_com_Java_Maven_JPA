package br.com.fuctura.repository.interfaces;

import br.com.fuctura.model.entidades.Tipo;
import java.util.List;

public interface ITipoRepository {

    void salvar(Tipo tipo);

    void atualizar(Tipo tipo);

    void deletar(Tipo tipo);

    Tipo buscarPorDescricao(String descricao);

    List<Tipo> listar();
}

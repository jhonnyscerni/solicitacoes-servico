package br.com.exemplo.repository;

import br.com.exemplo.model.Solicitacao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import br.com.exemplo.exception.NegocioException;
import br.com.exemplo.util.jpa.Transactional;

public class SolicitacaoRepository implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    public List<Solicitacao> listarTodos() {
        return manager.createQuery("SELECT s FROM Solicitacao s", Solicitacao.class).getResultList();
    }

    @Transactional
    public void salvar(Solicitacao solicitacao) {
        manager.merge(solicitacao);
    }

    public void atualizar(Solicitacao solicitacao) {
        manager.merge(solicitacao);
    }

    @Transactional
    public void deletar(Solicitacao solicitacao) throws NegocioException {
        try {
            solicitacao = buscarPorId(solicitacao.getId());
            manager.remove(solicitacao);
            manager.flush();
        } catch (PersistenceException e) {
            throw new NegocioException("Solicitação não pode ser excluido");
        }
    }


    public List<Solicitacao> listarPorFiltro(String tipoServico, String status) {
        String jpql = "SELECT s FROM Solicitacao s";
        return manager.createQuery(jpql, Solicitacao.class)
                .getResultList();
    }

    public Solicitacao buscarPorId(Long id) {
        return manager.find(Solicitacao.class, id);
    }
}

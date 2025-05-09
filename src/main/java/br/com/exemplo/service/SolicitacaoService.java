package br.com.exemplo.service;

import br.com.exemplo.exception.NegocioException;
import br.com.exemplo.model.Solicitacao;
import br.com.exemplo.repository.SolicitacaoRepository;
import br.com.exemplo.util.jpa.Transactional;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

public class SolicitacaoService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private SolicitacaoRepository solicitacaoRepository;

    public List<Solicitacao> listarTodos() {
        return solicitacaoRepository.listarTodos();
    }

    public void salvar(Solicitacao solicitacao) {
        solicitacaoRepository.salvar(solicitacao);
    }

    public void atualizar(Solicitacao solicitacao) {
        solicitacaoRepository.atualizar(solicitacao);
    }

    public void deletar(Solicitacao solicitacao) throws NegocioException {
        solicitacaoRepository.deletar(solicitacao);
    }

    public List<Solicitacao> listarPorFiltro(String tipoServico, String status) {
        return solicitacaoRepository.listarPorFiltro(tipoServico, status);
    }

    public Solicitacao buscarPorId(Long id) {
        return solicitacaoRepository.buscarPorId(id);
    }
}
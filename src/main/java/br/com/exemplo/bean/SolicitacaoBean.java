package br.com.exemplo.bean;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import javax.inject.Inject;

import br.com.exemplo.model.Solicitacao;
import br.com.exemplo.service.SolicitacaoService;

import java.time.LocalDate;
import java.util.List;

@Named
@ViewScoped
public class SolicitacaoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private SolicitacaoService solicitacaoService;

    private Solicitacao solicitacao;

    private List<Solicitacao> solicitacoes;
    private String tipoServicoFiltro;
    private String statusFiltro;

    @PostConstruct
    public void init() {
        solicitacao = new Solicitacao();
    }

    public String getTipoServicoFiltro() {
        return tipoServicoFiltro;
    }

    public void setTipoServicoFiltro(String tipoServicoFiltro) {
        this.tipoServicoFiltro = tipoServicoFiltro;
    }

    public String getStatusFiltro() {
        return statusFiltro;
    }

    public void setStatusFiltro(String statusFiltro) {
        this.statusFiltro = statusFiltro;
    }

    public List<Solicitacao> getSolicitacoes() {
        return solicitacoes;
    }

    public void listarSolicitacoes() {
        if (tipoServicoFiltro != null && statusFiltro != null) {
            solicitacoes = solicitacaoService.listarPorFiltro(tipoServicoFiltro, statusFiltro);
        } else {
            solicitacoes = solicitacaoService.listarTodos();
        }
    }

    public void salvar() {
        Solicitacao incluir = new Solicitacao();
        incluir.setNomeSolicitante("John Doe");
        incluir.setCpf("123.456.789-00");
        incluir.setTipoServico("Iluminação");
        incluir.setDescricao("Descrição do serviço solicitado.");
        incluir.setDataSolicitacao(LocalDate.now());
        incluir.setStatus("Aguardando Atendimento");
        solicitacaoService.salvar(incluir);
    }

    public void atualizar(Solicitacao solicitacao) {
        solicitacaoService.atualizar(solicitacao);
    }

    public void deletar() {
        try {
            solicitacaoService.deletar(solicitacao);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Solicitação deleted successfully."));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Failed to delete solicitação."));
        }
    }

    public List<Solicitacao> listarPorFiltro(String tipoServico, String status) {
        return solicitacaoService.listarPorFiltro(tipoServico, status);
    }

    public Solicitacao buscarPorId(Long id) {
        return solicitacaoService.buscarPorId(id);
    }

    public Solicitacao getSolicitacao() {
        return solicitacao;
    }

    public void setSolicitacao(Solicitacao solicitacao) {
        this.solicitacao = solicitacao;
    }

    public boolean isEditando() {
        if (this.solicitacao == null) {
            return false;
        }
        return this.solicitacao.getId() != null;
    }
}

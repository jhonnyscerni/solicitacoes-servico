package br.com.exemplo.converter;

import br.com.exemplo.model.Solicitacao;
import br.com.exemplo.repository.SolicitacaoRepository;
import br.com.exemplo.util.cdi.CDIServiceLocator;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@FacesConverter(forClass = Solicitacao.class)
public class SolicitacaoConverter implements Converter {

    //@Inject
    private SolicitacaoRepository solicitacaoRepository;

    public SolicitacaoConverter() {
        solicitacaoRepository = CDIServiceLocator.getBean(SolicitacaoRepository.class);
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Solicitacao retorno = null;

        if (value != null && !value.isEmpty()) {
            Long id = new Long(value);
            retorno = solicitacaoRepository.buscarPorId(id);
        }

        return retorno;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            return ((Solicitacao) value).getId().toString();
        }

        return "";
    }

}

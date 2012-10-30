package br.com.caelum.financas.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Movimentacao;

@ManagedBean
public class BuscaTextualBean {

	@ManagedProperty(name = "em", value = "#{requestScope.em}")
	private EntityManager em;
	private String tags;
	private List<Movimentacao> movimentacoes;

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public void busca() {
		System.out.println("Buscando as movimentacoes associadas as tags");
	}

	public List<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}

}

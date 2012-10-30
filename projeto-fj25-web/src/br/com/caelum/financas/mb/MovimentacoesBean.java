package br.com.caelum.financas.mb;

import java.util.Calendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;


@ManagedBean
public class MovimentacoesBean {
	private List<Movimentacao> movimentacoes;
	private Movimentacao movimentacao = new Movimentacao();
	private Integer contaId;
	private String tags;
//	@ManagedProperty(name="em",value="#{requestScope.em}")
//	private EntityManager em;
	
//	public void setEm(EntityManager em) {
//		this.em = em;
//	}
	
	public void grava() {
		EntityManager em = new  JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		MovimentacaoDAO movimentacaoDao = new MovimentacaoDAO(em);
		ContaDAO contaDao = new ContaDAO(em);
		
	
		Conta contaRelacionada = contaDao.busca(contaId);
		movimentacao.setConta(contaRelacionada);
		
		movimentacaoDao.adiciona(movimentacao);
		
		this.movimentacoes = movimentacaoDao.lista();
		em.getTransaction().commit();
		em.close();
		
		System.out.println("Fazendo a gravacao da movimentacao");
		limpaFormularioDoJSF();
	}
	

	public void remove() {
		EntityManager em = new  JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		MovimentacaoDAO movimentacaoDAO = new MovimentacaoDAO(em);
		Movimentacao movimentacaoParaRemover = movimentacaoDAO.busca(this.movimentacao.getId());
		
		movimentacaoDAO.remove(movimentacaoParaRemover);
		movimentacoes = movimentacaoDAO.lista();
		
		em.getTransaction().commit();
		em.close();
		
		System.out.println("Removendo a movimentacao");
		limpaFormularioDoJSF();
	}

	public List<Movimentacao> getMovimentacoes() {
		if(movimentacoes == null){
			EntityManager em = new  JPAUtil().getEntityManager();
			MovimentacaoDAO movimentacaoDAO = new MovimentacaoDAO(em);
			movimentacoes = movimentacaoDAO.lista();
			em.close();
			
		}
		System.out.println("Listando as movimentacoes");
		return movimentacoes;
	}
	
	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}
	

	public Movimentacao getMovimentacao() {
		if(movimentacao.getData()==null) {
			movimentacao.setData(Calendar.getInstance());
		}
		return movimentacao;
	}

	public void setMovimentacao(Movimentacao movimentacao) {
		this.movimentacao = movimentacao;
	}

	public Integer getContaId() {
		return contaId;
	}

	public void setContaId(Integer contaId) {
		this.contaId = contaId;
	}

	/**
	 * Esse método apenas limpa o formulário da forma com que o JSF espera.
	 * Invoque-o no momento em que precisar do formulário vazio.
	 */
	private void limpaFormularioDoJSF() {
		this.movimentacao = new Movimentacao();
		this.tags = null;
	}

	public TipoMovimentacao[] getTiposDeMovimentacao() {
		return TipoMovimentacao.values();
	}
}

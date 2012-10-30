package br.com.caelum.financas.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.modelo.ValorPorMesEAno;

@ManagedBean
public class MesesComMovimentacaoBean {

	private final Conta conta = new Conta();

	private TipoMovimentacao tipoMovimentacao;
	
	private List<ValorPorMesEAno> valoresPorMesEAno;
	


	@ManagedProperty(name="em",value="#{requestScope.em}")
	private EntityManager em;
	
	public void setEm(EntityManager em) {
		this.em = em;
	}

	public void lista() {
		EntityManager em = new JPAUtil().getEntityManager();
		MovimentacaoDAO movimentacaoDao = new MovimentacaoDAO(em);
		
		this.valoresPorMesEAno = movimentacaoDao.listaMesesComMovimentacoes(conta, tipoMovimentacao);
		
		
		System.out
				.println("Listando as contas pelos valores movimentados no mês");
	}

	public TipoMovimentacao getTipoMovimentacao() {
		return tipoMovimentacao;
	}

	public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}

	public Conta getConta() {
		return conta;
	}
	public List<ValorPorMesEAno> getValoresPorMesEAno() {
		return valoresPorMesEAno;
	}

}

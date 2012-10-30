package br.com.caelum.financas.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;


@ViewScoped
@ManagedBean
public class ContasBean {
	private Conta conta = new Conta();
	private List<Conta> contas;	

	
	
	public void grava() {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		ContaDAO contaDAO = new ContaDAO(em);
		
		if(conta.getId() == null){
			contaDAO.adiciona(conta);
		}else{
			contaDAO.altera(conta);
		}
		
		
		contas = contaDAO.lista();
		
		em.getTransaction().commit();
		em.close();
		
		limpaFormularioDoJSF();
        System.out.println("Gravando a conta");        
	}
	


	public void remove() {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		ContaDAO contaDao = new ContaDAO(em);
		Conta contaParaRemover = contaDao.busca(this.conta.getId());
		
		contaDao.remove(contaParaRemover);
		contas = contaDao.lista();
		
		em.getTransaction().commit();
		em.close();
		
		limpaFormularioDoJSF();
		
		
        System.out.println("Removendo a conta");        	
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
	
	
	public List<Conta> getContas() {
		if(contas == null){
			EntityManager em = new JPAUtil().getEntityManager();
			ContaDAO contaDAO = new ContaDAO(em);
			contas = contaDAO.lista();
			em.close();
			
		}
        System.out.println("Listando as contas");        
		return contas;
	}
	
	/**
	 * Esse método apenas limpa o formulário da forma com que o JSF espera.
	 * Invoque-o no momento em que precisar do formulário vazio.
	 */
	private void limpaFormularioDoJSF() {
        this.conta = new Conta();
	}	
}

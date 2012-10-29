package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;

public class TestaListagemConta {
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		ContaDAO dao = new ContaDAO(em);
		em.getTransaction().begin();
		
		List<Conta> lista = dao.lista();
		for(Conta conta : lista){
			System.out.println(conta.getNumero());
		}
		
		em.getTransaction().commit();
		em.close();
		
	}
	
	
	
}

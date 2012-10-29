package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Movimentacao;

public class TestaBuscaContaDaMovimentacao {
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		MovimentacaoDAO movimentacaoDao = new MovimentacaoDAO(em);
		em.getTransaction().begin();

		Movimentacao encontrado = movimentacaoDao.busca(3);
		System.out.println(encontrado.getConta().getTitular());

		em.getTransaction().commit();
		em.close();
	}
}

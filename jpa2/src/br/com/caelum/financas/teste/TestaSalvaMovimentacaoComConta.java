package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.infra.JPAUtil;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;

public class TestaSalvaMovimentacaoComConta {
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		ContaDAO contaDao = new ContaDAO(em);
		MovimentacaoDAO movimentacaoDao = new MovimentacaoDAO(em);
		em.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setBanco("Banco santander");
		conta.setNumero("9999-9");
		conta.setAgencia("999");
		conta.setTitular("Maria");
		
		//em.persist(conta);
		contaDao.adiciona(conta);

		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setConta(conta);
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("bla bla bla bla");
		movimentacao.setValor(new BigDecimal("100"));
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		
	
		
		//em.persist(movimentacao);
		movimentacaoDao.adiciona(movimentacao);
		em.getTransaction().commit();
		em.close();
	}
}

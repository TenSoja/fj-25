package br.com.caelum.financas.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;

public class ContaDAO {

	private final DAO<Conta> dao;
	
	public ContaDAO(EntityManager em) {
		dao = new DAO<Conta>(em,Conta.class);
	}

	public void adiciona(Conta t) {
		dao.adiciona(t);
	}

	public Conta busca(Integer id) {
		return dao.busca(id);
	}

	public List<Conta> lista() {
		return dao.lista();
	}

	public void remove(Conta t) {
		dao.remove(t);
	}

	
	
}

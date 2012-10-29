package br.com.caelum.financas.dao;

import java.util.List;

import javax.persistence.EntityManager;

public class DAO<T> {

	private final EntityManager em;
	private final Class<T> classe;
	
	public DAO(EntityManager em, Class<T> classe){
		this.em = em;
		this.classe = classe;
		
	}
	public T busca(Integer id){
		return em.getReference(classe, id);
		
	}
	public List<T> lista(){
		return em.createQuery("select e from " + classe.getName() + " e").getResultList();
		
	}
	public void adiciona(T t) {
		this.em.persist(t);
	}
	
	public void remove(T t) {
		this.em.remove(t);
	}
}

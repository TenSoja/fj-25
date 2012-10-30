package br.com.caelum.financas.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CriaEntityManagerFactoryParaAtualizarBanco {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("controlefinancas");
	}
	
}

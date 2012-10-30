package br.com.caelum.financas.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.caelum.financas.modelo.Conta;


@ViewScoped
@ManagedBean
public class ContasBean {
	private Conta conta = new Conta();
	private List<Conta> contas;	

	
	
	public void grava() {
        System.out.println("Gravando a conta");        
	}
	


	public void remove() {
        System.out.println("Removendo a conta");        	
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
	
	
	public List<Conta> getContas() {
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

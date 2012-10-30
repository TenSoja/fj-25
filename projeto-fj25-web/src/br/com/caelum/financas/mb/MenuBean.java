package br.com.caelum.financas.mb;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class MenuBean {

	public String contas() {
		return "contas";
	}
	
	public String estatisticas() {
		return "estatisticas";			
	}
	
	public String mesesComMovimentacao() {
		return "mesesComMovimentacao";
	}
	
	public String movimentacoes() {
		return "movimentacoes";
	}	
	
	public String movimentacoesDaConta() {
		return "movimentacoesDaConta";
	}
	
	public String movimentacoesPorTags() {
		return "movimentacoesPorTags";
	}
	
	public String movimentacoesPorTagsAvancado() {
		return "movimentacoesPorTagsAvancado";
	}
	
	public String movimentacoesPorTitular() {
		return "movimentacoesPorTitular";
	}
	
	public String movimentacoesPorValorETipo() {
		return "movimentacoesPorValorETipo";
	}
	
	public String pesquisaMovimentacoes() {
		return "pesquisaMovimentacoes";
	}
	
	public String qtdeMovimentacoesDaConta() {
		return "qtdeMovimentacoesDaConta";
	}
	
	public String totalMovimentado() {
		return "totalMovimentado";
	}
}

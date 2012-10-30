package br.com.caelum.financas.infra.search;


public enum Semelhanca {
	EXATA(0.9f), MEDIA(0.5f), BAIXA(0.1f);

	private Semelhanca(float valor) {
		this.valor = valor;
	}
	
	private float valor;
		
	public float getValor() {
		return valor;
	}
}

package br.com.caelum.financas.infra.search;


public class ElementoDaBusca {
	private Semelhanca semelhanca = Semelhanca.EXATA;
	private Presenca presenca = Presenca.FACULTATIVO;
	private float multiplicador=1f;
	private String texto;
	
	public ElementoDaBusca() {
	}
	
	public ElementoDaBusca(String string, Presenca presenca,
			Semelhanca semelhanca, float multiplicador) {
		this.texto = string;
		this.presenca = presenca;
		this.semelhanca = semelhanca;
		this.multiplicador = multiplicador;
	}

	@Override
	public String toString() {
		return texto+" ( x"+multiplicador+" - "+semelhanca+" - "+presenca+" )";
	}
	
//	public static BooleanJunction aplicaTodos(List<ElementoDaBusca> elementos, BooleanJunction juncao, EntityManager em) {
//		for (ElementoDaBusca elemento : elementos) {
//			elemento.aplica(juncao, em);
//		}
//		return juncao;
//	}
//	
//	public BooleanJunction aplica(BooleanJunction juncao, EntityManager em) {
//		return presenca.adicionaNaQuery(this, em, juncao);
//	}
//	
//	public static BooleanJunction criaJuncao(EntityManager em) {
//		return Presenca.criaNovo(em);
//	}
	
	public Presenca getPresenca() {
		return presenca;
	}
	public void setPresenca(Presenca obrigacao) {
		this.presenca = obrigacao;
	}
	public Semelhanca getSemelhanca() {
		return semelhanca;
	}
	public void setSemelhanca(Semelhanca semelhanca) {
		this.semelhanca = semelhanca;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public float getMultiplicador() {
		return multiplicador;
	}
	public void setMultiplicador(float multiplicador) {
		this.multiplicador = multiplicador;
	}
}

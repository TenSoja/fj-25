package br.com.caelum.financas.mb;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.caelum.financas.infra.search.ElementoDaBusca;

@ManagedBean
@ViewScoped
public class ElementosEscolhidosBean {
	private List<ElementoDaBusca> elementos = new ArrayList<ElementoDaBusca>();
	
	public void adiciona(ElementoDaBusca elemento) {
		this.elementos.add(elemento);
	}
	
	public void limpa() {
		this.elementos.clear();
	}
	
	public List<ElementoDaBusca> getElementos() {
		return elementos;
	}

	public void desfazUltima() {
		if (!this.elementos.isEmpty()) {
			this.elementos.remove(elementos.size()-1);
		}
	}
}

package br.univel.app;

import java.util.List;

import br.univel.xml.Produto;

public class ProdutoWrapper {

	private List<Produto> lista;
	
	public List<Produto> getLista(){
		return lista;
	}
	
	public void setLista(List<Produto> lista){
		this.lista = lista;
	}
}

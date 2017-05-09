package br.univel.app;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.univel.xml.Produto;

public class MeuTableModel extends AbstractTableModel {

	private List<Produto> listaProduto;
	
	public MeuTableModel(List<Produto> lista){
		if (lista == null){
			this.listaProduto = new ArrayList<>();
		}else{
			this.listaProduto = lista;
		}
	}
	
	@Override
	public int getRowCount() {
		return listaProduto.size();
	}
	
	@Override
	public int getColumnCount() {
		return 2;
	}


	@Override
	public Object getValueAt(int row, int column) {
		
		Produto p = listaProduto.get(row);
		switch (column){
		case 0:
			return p.getId();
		case 1:
			return p.getNome();
		}
		
		return "erro";
	}

}

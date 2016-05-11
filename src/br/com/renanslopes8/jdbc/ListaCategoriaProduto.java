package br.com.renanslopes8.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.renanslopes8.jdbc.dao.CategoriasDAO;
import br.com.renanslopes8.jdbc.modelo.Categoria;
import br.com.renanslopes8.jdbc.modelo.Produto;

public class ListaCategoriaProduto{
	public static void main(String[] args) throws SQLException{
		try(Connection con = new ConnectionPool().getConnection()){
			List<Categoria> categorias = new CategoriasDAO(con).listaComProdutos();
			for(Categoria categoria : categorias) {
				  for(Produto produto : categoria.getProdutos()) {
				    System.out.println("Categoria: "+categoria.getNome() + " - Produto: "+ produto.getNome());
				  }
			}
		}
	}
}

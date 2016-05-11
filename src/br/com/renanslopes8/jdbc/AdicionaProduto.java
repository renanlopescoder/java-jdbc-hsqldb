package br.com.renanslopes8.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.renanslopes8.jdbc.dao.ProdutoDAO;
import br.com.renanslopes8.jdbc.modelo.Produto;

public class AdicionaProduto {
	public static void main(String[] args) throws SQLException {
		Produto notebook = new Produto("Notebook", "Intel I7");
		try (Connection con = new ConnectionPool().getConnection()) {
			ProdutoDAO dao = new ProdutoDAO(con);
			dao.salvaProduto(notebook);
			@SuppressWarnings("unchecked")
			List<Produto> lista = dao.listaProduto();
			for (Produto produto : lista) {
				System.out.println(produto);
			}
		}
	}
}
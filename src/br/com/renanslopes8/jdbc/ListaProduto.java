package br.com.renanslopes8.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.renanslopes8.jdbc.dao.ProdutoDAO;
import br.com.renanslopes8.jdbc.modelo.Produto;

public class ListaProduto {
	public static void main(String[] args) throws SQLException {
		try (Connection con = new ConnectionPool().getConnection()) {
			ProdutoDAO dao = new ProdutoDAO(con);
			List<Produto> lista = dao.listaProduto();
			for (Produto produto : lista) {
				System.out.println(produto);
			}
		}
	}

}

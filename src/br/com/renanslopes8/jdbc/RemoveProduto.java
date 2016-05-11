package br.com.renanslopes8.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import br.com.renanslopes8.jdbc.dao.ProdutoDAO;
import br.com.renanslopes8.jdbc.modelo.Produto;

public class RemoveProduto {
	public static void main(String[] args) throws SQLException {
		try (Connection connection = new ConnectionPool().getConnection()) {
			try (Statement statement = connection.createStatement()) {
				int idProduto = 65;
				String operacao = ">";
				statement.execute("delete from produto where id" + operacao+ idProduto);
				int a = statement.getUpdateCount();
				System.out.println(a + " Produtos foram Removidos");
			}
			ProdutoDAO dao = new ProdutoDAO(connection);
			@SuppressWarnings("unchecked")
			List<Produto> lista = dao.listaProduto();
			for (Produto produto : lista) {
				System.out.println(produto);
			}
		}
	}
}

package br.com.renanslopes8.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.renanslopes8.jdbc.modelo.Categoria;
import br.com.renanslopes8.jdbc.modelo.Produto;

public class CategoriasDAO {

	private final Connection con;

	public CategoriasDAO(Connection con) {
		this.con = con;
	}

	public List<Categoria> lista() throws SQLException {
		List<Categoria> categorias = new ArrayList<>();
		String sql = "select * from Categoria";
		try (PreparedStatement statement = con.prepareStatement(sql)) {
			statement.execute();
			preparaCategoria(statement, categorias);
		}
		return categorias;
	}

	private void preparaCategoria(PreparedStatement statement,
			List<Categoria> categorias) throws SQLException {
		try (ResultSet listaResultado = statement.getResultSet()) {
			while (listaResultado.next()) {
				int id = listaResultado.getInt("id");
				String nome = listaResultado.getString("nome");
				Categoria categoria = new Categoria(id, nome);
				categorias.add(categoria);
			}
		}
	}

	public List<Categoria> listaComProdutos() throws SQLException {
		List<Categoria> categorias = new ArrayList<>();
		Categoria ultima = null;
		
		String sql = "select c.id as c_id, c.nome as c_nome, p.id as p_id, p.nome as p_nome, p.descricao as p_descricao from Categoria as c join Produto as p on p.categoria_id = c.id order by c.id";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.execute();
			try (ResultSet rs = stmt.getResultSet()) {
				while (rs.next()) {
					int id = rs.getInt("c_id");
					String nome = rs.getString("c_nome");
					if(ultima==null || !ultima.getNome().equals(nome)){
						Categoria categoria = new Categoria(id, nome);
	                    categorias.add(categoria);
	                    ultima = categoria;
	                }
                    int idDoProduto = rs.getInt("p_id");
                    String nomeDoProduto =rs.getString("p_nome");
                    String descricaoDoProduto = rs.getString("p_descricao");
                    Produto p = new Produto(nomeDoProduto, descricaoDoProduto);
                    p.setId(idDoProduto);
                    ultima.adiciona(p);
				}
			}
		}
		return categorias;
	}
}
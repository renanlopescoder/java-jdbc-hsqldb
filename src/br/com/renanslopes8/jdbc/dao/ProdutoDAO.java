package br.com.renanslopes8.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.renanslopes8.jdbc.ConnectionPool;
import br.com.renanslopes8.jdbc.modelo.Categoria;
import br.com.renanslopes8.jdbc.modelo.Produto;

public class ProdutoDAO {

	private final Connection con;

	public ProdutoDAO(Connection con) {
		this.con = con;
	}
	
	public void salvaProduto(Produto produto) throws SQLException {
		try (Connection con = new ConnectionPool().getConnection()) {
			con.setAutoCommit(false);
			String sql = "insert into produto(nome,descricao)values(?,?)";
			try (PreparedStatement statement = con.prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS)) {
				statement.setString(1, produto.getNome());
				statement.setString(2, produto.getDescricao());
				statement.execute();
				try (ResultSet idAdicionadoSet = statement.getGeneratedKeys()) {
					if (idAdicionadoSet.next()) {
						int id = idAdicionadoSet.getInt("id");
						produto.setId(id);
						System.out.println(produto + " foi adicionado!");
					}
				}
				con.commit();
			} catch (Exception ex) {
				ex.printStackTrace();
				con.rollback();
				System.out.println("Rollback efetuado");
			}
		}
	}

	public void removeProduto(Produto produto) throws SQLException {
		try (Connection con = new ConnectionPool().getConnection()) {
			con.setAutoCommit(false);
			String sql = "delete from produto where id > 65";
			try (PreparedStatement statement = con.prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS)) {
				statement.setString(1, produto.getNome());
				statement.setString(2, produto.getDescricao());
				statement.execute();
				try (ResultSet idAdicionadoSet = statement.getGeneratedKeys()) {
					if (idAdicionadoSet.next()) {
						int id = idAdicionadoSet.getInt("id");
						produto.setId(id);
						System.out.println(produto + " foi adicionado!");
					}
				}
				con.commit();
			} catch (Exception ex) {
				ex.printStackTrace();
				con.rollback();
				System.out.println("Rollback efetuado");
			}
		}
	}
	
		@SuppressWarnings("rawtypes")
		public List listaProduto() throws SQLException {
			List<Produto> produtos = new ArrayList<>();
				String sql = "select * from Produto";
				try(PreparedStatement statement = con.prepareStatement(sql)){
					statement.execute();
					preparaProduto(statement,produtos);
				}
				return produtos;
		}	
		
		private void preparaProduto(PreparedStatement statement, List<Produto> produtos) throws SQLException{		
					try(ResultSet listaResultado = statement.getResultSet()){
					while (listaResultado.next()) {
						int id = listaResultado.getInt("id");
		                String nome = listaResultado.getString("nome");
		                String descricao = listaResultado.getString("descricao");
		                Produto produto = new Produto(nome, descricao);
		                produto.setId(id);
		                produtos.add(produto);
					}
				}				
		}
		
		public List<Produto> busca(Categoria categoria) throws SQLException{
			List<Produto> produtos = new ArrayList<>();
			String sql = "select * from produto where categoria_id = ?";
			try(PreparedStatement stmt = con.prepareStatement(sql)){
				stmt.setInt(1, categoria.getId());
				stmt.execute();
				preparaProduto(stmt,produtos);
			}
			return produtos;
		}
}
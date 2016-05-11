package br.com.renanslopes8.jdbc.modelo;

public class Produto {
	private int id;
	String nome;
	String descricao;
	
	public Produto(String nome, String descricao) {
		super();
		this.nome = nome;
		this.descricao = descricao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return String.format("[Produto: %d %s %s]",id,nome,descricao);
	}
}

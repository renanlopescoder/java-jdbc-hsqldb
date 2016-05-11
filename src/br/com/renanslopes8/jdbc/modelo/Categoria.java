package br.com.renanslopes8.jdbc.modelo;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
	private int id;
	String nome;
	private final List<Produto> produtos = new ArrayList<>();
	
	public Categoria(int id,String nome){
		super();
		this.id = id;
		this.nome = nome;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void adiciona(Produto p) {
		this.produtos.add(p);
	}	
}
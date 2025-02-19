package br.com.ehmf.AppProdutos.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name="tb_produtos")
public class Produtos {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
    
    @Column(nullable = false)//not null
	private String codigoBarras;
    
    @Column(nullable = false)//not null
	private String nome;
    
    @Column(nullable = false)//not null
	private Double preco;
	
	public Produtos() {}

	
	
	public Produtos(Long id, String codigoBarras, String nome, Double preco) {
		this.Id = id;
		this.codigoBarras = codigoBarras;
		this.nome = nome;
		this.preco = preco;
	}
	
	

	public Long getId() {
		return Id;
	}
	
	public void setId(Long id) {
		Id = id;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Produtos [Id=" + Id + ", codigoBarras=" + codigoBarras + ", nome=" + nome + ", preco=" + preco + "]";
	}
	
	

}

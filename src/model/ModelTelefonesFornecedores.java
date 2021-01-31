package model;

public class ModelTelefonesFornecedores {
	
	private Long id;
	private String numero;
	private String tipo;
	private Long fornecedores;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Long getFornecedores() {
		return fornecedores;
	}
	public void setFornecedores(Long fornecedores) {
		this.fornecedores = fornecedores;
	}
	
}

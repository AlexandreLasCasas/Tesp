package br.unibh.teste01.entidades;

//Identação do código = ctrl + shift + f

public abstract class Pessoa {

	private Long id;
	private String nome;
	private String cpf;
	
	public Pessoa(){}
	
	public Pessoa(Long id, String nome, String cpf) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
	}
	


	public Pessoa(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", getId()=" + getId() + ", getNome()="
				+ getNome() + ", getCpf()=" + getCpf() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	
}

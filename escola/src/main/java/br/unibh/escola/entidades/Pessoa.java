package br.unibh.escola.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name = "TB_PESSOA", uniqueConstraints = @UniqueConstraint(columnNames = "cpf"))

public abstract class Pessoa {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(length = 100, nullable = false, columnDefinition="VARCHAR(100)")
	@Size(min=5, max=100)
	@Pattern(regexp = "[A-Za-zÁ-ú ]*", message = "must contain only letters and spaces")
	private String nome;
	
	@NotBlank
	@Column(length = 11, nullable = false, columnDefinition="CHAR(11)", unique = true)
	@Pattern(regexp = "d{11}", message = "must contain only numbers")
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
		return "Pessoa [id=" + id + ", nome=" + nome + ", cpf=" + cpf + "OID=" + super.toString();
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

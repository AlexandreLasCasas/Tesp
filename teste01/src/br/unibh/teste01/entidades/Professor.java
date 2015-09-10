package br.unibh.teste01.entidades;

import java.math.BigDecimal;

/**
 * Classe Concreta de Professor
 * @author Alexandre
 * @version 1.0
 *
 */
public class Professor extends Pessoa {
	
	// Variaveis de Instancia
	
	private BigDecimal salario ; // trabalha melhor com números fracionários
	private static Double BONUS=0.1D;
	
	// Construtores
	/**
	 * Construtor padrão
	 */
	public Professor(){}
	
	/**
	 * 
	 * @param Super salario
	 */
	public Professor(BigDecimal salario) {
		super();
		this.salario = salario;
	}
	/**
	 * 
	 * @param id identificação
	 * @param nome do professor
	 * @param cpf do professor
	 * @param salario do professor
	 */
	public Professor(Long id, String nome, String cpf, BigDecimal salario) {
		super(id, nome, cpf);
		this.salario = salario;
	}

	//ToString 
	/**
	 * @To.String chama o super da classe
	 */
	@Override
	public String toString() {
		return "Professor [salario=" + salario + ", getSalario()=" + getSalario() + ", toString()=" + super.toString()
				+ ", getId()=" + getId() + ", getNome()=" + getNome() + ", getCpf()=" + getCpf() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + "]";
	}
	// Gets e Sets
	
	
	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	

	public BigDecimal getSalario() {
		return salario;
	}
}

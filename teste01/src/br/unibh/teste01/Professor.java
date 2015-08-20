package br.unibh.teste01;

import java.math.BigDecimal;

/**
 * Classe concreta de professor
 *@author Alexandre
 *@version 1.0
 *@since 2015
 */

public class Professor extends Pessoa {
	
	// Variáveis de Instância
	/**
	 * Variáveis de instância
	 */
	private BigDecimal salario;

	
	// Construtores
	/**
	 * Construtor padrão
	 */
	public Professor (){}
	
	/**
	 * Construtor com completo
	 */

	public Professor(Long id, String nome, String cpf, BigDecimal salario) {
		super(id, nome, cpf);
		this.salario = salario;
	}

	
	public Professor(BigDecimal matricula) {
		super();
		this.salario = matricula;
	}
	
	// Get e Set
	/**
	 * Get e Set
	 */
	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
	
	@Override
	public String toString() {
		return "Professor [salario=" + salario + ", toString()=" + super.toString() + "]";
	}

	public BigDecimal getMatricula() {
		return salario;
	}

	public void setMatricula(BigDecimal matricula) {
		this.salario = matricula;
	}



}

package br.unibh.teste01.entidades;

import java.math.BigDecimal;

/**
 * Função: Classe concreta de professor.
 * @author Alexandre Las Casas
 * @since 17/08/2015
 */
public class Professor extends Pessoa {

	// variaveis de instancia, tipo especifico para calculos de valores financeiros.
	private BigDecimal salario;
	public static Double BONUS = 0.1D;
	
	/**
	 * Construtor padrão
	 */
	public Professor (){}

	public Professor(BigDecimal salario) {
		super();
		this.salario = salario;
	}
	
	public Professor(Long id, String nome, String cpf, BigDecimal salario) {
		super(id, nome, cpf);
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "Professor [salario=" + salario + ", toString()="
				+ super.toString() + "]";
	}
	
	
	
	// Get and Setters	
	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
	
}

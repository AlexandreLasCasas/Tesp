package br.unibh.escola.entidades;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;

/**
 * Fun��o: Classe concreta de professor.
 * @author Alexandre Las Casas
 * @since 17/08/2015
 */
@Table(name = "TB_PROFESSOR")
@Entity
@PrimaryKeyJoinColumn
public class Professor extends Pessoa {

	// variaveis de instancia, tipo especifico para calculos de valores financeiros.
	
	@Column(nullable = true)
	@DecimalMin("500.00")
	@DecimalMax("100000.00")
	@Digits(integer=14, fraction=2)
	private BigDecimal salario;
	public static Double BONUS = 0.1D;
	
	/**
	 * Construtor padr�o
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

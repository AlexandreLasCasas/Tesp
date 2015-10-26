package br.unibh.escola.entidades;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Fun��o: Classe concreta de professor.
 * @author Alexandre Las Casas
 * @since 17/08/2015
 */

@Entity
@PrimaryKeyJoinColumn
@Table (name= "TB_PROFESSOR")
@NamedQueries({
	@NamedQuery(name="Professor.findByName", query = "select a from Professor a where a.nome like :nome")
})

public class Professor extends Pessoa {

	// variaveis de instancia, tipo especifico para calculos de valores financeiros.
	
	
	@Column (name= "Salario", nullable= true, columnDefinition= "DECIMAL(14,2)")
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

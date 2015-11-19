package br.unibh.escola.entidades;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="professor")
	private List<Disciplina> disciplinas;
	
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
		return "Professor [salario=" + salario + ", disciplinas=" + disciplinas + "]";
	}

	// Get and Setters	
	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((disciplinas == null) ? 0 : disciplinas.hashCode());
		result = prime * result + ((salario == null) ? 0 : salario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Professor other = (Professor) obj;
		if (disciplinas == null) {
			if (other.disciplinas != null)
				return false;
		} else if (!disciplinas.equals(other.disciplinas))
			return false;
		if (salario == null) {
			if (other.salario != null)
				return false;
		} else if (!salario.equals(other.salario))
			return false;
		return true;
	}
	
}

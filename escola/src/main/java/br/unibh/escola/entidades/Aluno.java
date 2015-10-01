package br.unibh.escola.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Table(name = "TB_ALUNO", uniqueConstraints = @UniqueConstraint(columnNames = "matricula"))
@Entity
@PrimaryKeyJoinColumn
public class Aluno extends Pessoa {
	
	@NotNull
	@Column(nullable = false, columnDefinition="CHAR(8)")
	@Size(max=8)
	@Pattern(regexp = "[A-Za-z\\d]*", message = "DEVE CONTER APENAS NUMEROS E DIGITOS")
	private String matricula;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = true,name="data_aniversario")
	private Date dataAniversario;
	
	public Aluno(){}
	
	public Aluno(String matricula, Date dataAniversario) {
		super();
		this.matricula = matricula;
		this.dataAniversario = dataAniversario;
	}

	public Aluno(Long id, String nome, String cpf, String matricula, Date dataAniversario) {
		super(id, nome, cpf);
		this.matricula = matricula;
		this.dataAniversario = dataAniversario;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Aluno [matricula=" + matricula + ", dataAniversario="
				+ dataAniversario + ", toString()=" + super.toString() + "]";
	}

	/**
	 * @return the matricula
	 */
	public String getMatricula() {
		return matricula;
	}

	/**
	 * @param matricula the matricula to set
	 */
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	/**
	 * @return the dataAniversario
	 */
	public Date getDataAniversario() {
		return dataAniversario;
	}

	/**
	 * @param dataAniversario the dataAniversario to set
	 */
	public void setDataAniversario(Date dataAniversario) {
		this.dataAniversario = dataAniversario;
	}
	
	
	
	

}

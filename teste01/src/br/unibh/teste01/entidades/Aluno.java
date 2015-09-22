package br.unibh.teste01.entidades;

import java.util.Date;

public class Aluno extends Pessoa {

	private String matricula;
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

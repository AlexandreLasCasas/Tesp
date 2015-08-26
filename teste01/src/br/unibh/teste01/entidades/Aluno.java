package br.unibh.teste01.entidades;

import java.util.Date;

public class Aluno extends Pessoa{
	
	private String matricula;
	private Date dataAniversario;
	private String date;
	
	public Aluno (){}
	
	@Override
	public String toString() {
		return "Aluno [matricula=" + matricula + ", dataAniversario=" + dataAniversario + ", date=" + date
				+ ", toString()=" + super.toString() + "]";
	}

	public Aluno(Long id, String nome, String cpf, String matricula, Date dataAniversario) {
		super(id, nome, cpf);
		this.matricula = matricula;
		this.dataAniversario = dataAniversario;
	}

	public Aluno(String matricula, Date dataAniversario, String date) {
		super();
		this.matricula = matricula;
		this.dataAniversario = dataAniversario;
		this.date = date;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}



}

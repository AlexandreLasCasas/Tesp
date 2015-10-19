package br.unibh.escola.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "TB_SALA", uniqueConstraints = @UniqueConstraint(columnNames = "codigo") )
public class Sala {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotBlank
	@Pattern(regexp = "[A-Z]2[0-9]3")
	@Size(min = 5, max = 5)
	@Column(nullable = false, columnDefinition = "CHAR(5)")
	private String codigo;

	@Size(min = 5, max = 100)
	@Column(nullable = false, length = 100)
	private int Capacidade;

	@Column(name = "possui_quadro_branco", nullable = false)
	private boolean possuiQuadroBranco;

	@Column(name = "possui_data_show", nullable = false)
	private boolean possuiDataShow;

	@Column(name = "possui_computador", nullable = false)
	private boolean possuiComputador;

	@Column(nullable = true, columnDefinition = "VARCHAR(255)")
	private String observacao;

	@NotBlank
	@Pattern(regexp = "[1-3]1")
	@Column(nullable = false)
	private int status;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_termino_manutencao", nullable = true)
	private Date dataTerminoManutencao;
	
	public Sala (){}
	
	public Sala (Long id, String codigo, int capacidade, boolean possuiQuadroBranco, boolean possuiDataShow,
			boolean possuiComputador, String observacao, int status, Date dataTerminoManutencao) {
		super();
		this.id = id;
		this.codigo = codigo;
		Capacidade = capacidade;
		this.possuiQuadroBranco = possuiQuadroBranco;
		this.possuiDataShow = possuiDataShow;
		this.possuiComputador = possuiComputador;
		this.observacao = observacao;
		this.status = status;
		this.dataTerminoManutencao = dataTerminoManutencao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getCapacidade() {
		return Capacidade;
	}

	public void setCapacidade(int capacidade) {
		Capacidade = capacidade;
	}

	public boolean isPossuiQuadroBranco() {
		return possuiQuadroBranco;
	}

	public void setPossuiQuadroBranco(boolean possuiQuadroBranco) {
		this.possuiQuadroBranco = possuiQuadroBranco;
	}

	public boolean isPossuiDataShow() {
		return possuiDataShow;
	}

	public void setPossuiDataShow(boolean possuiDataShow) {
		this.possuiDataShow = possuiDataShow;
	}

	public boolean isPossuiComputador() {
		return possuiComputador;
	}

	public void setPossuiComputador(boolean possuiComputador) {
		this.possuiComputador = possuiComputador;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getDataTerminoManutencao() {
		return dataTerminoManutencao;
	}

	public void setDataTerminoManutencao(Date dataTerminoManutencao) {
		this.dataTerminoManutencao = dataTerminoManutencao;
	}

}

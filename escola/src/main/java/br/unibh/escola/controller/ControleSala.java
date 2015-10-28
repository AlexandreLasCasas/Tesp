package br.unibh.escola.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.unibh.escola.data.ServicoSala;
import br.unibh.escola.entidades.Sala;

@ManagedBean(name = "salamb")
@ViewScoped
public class ControleSala {
	@Inject
	private Logger log;
	@Inject
	private ServicoSala sa;
	private Sala sala;
	private String codArg;
	private List<Sala> salas;

	
	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public void setSalas(List<Sala> salas) {
		this.salas = salas;
	}

	public String getCodArg() {
		return codArg;
	}

	public void setCodArg(String codArg) {
		this.codArg = codArg;
	}

	public List<Sala> getSalas() {
		return salas;
	}

	@PostConstruct
	public void inicializaLista() {
		log.info("Executando o MB de Sala");
		try {
			salas = sa.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void gravar() {
		FacesMessage facesMsg;
		try {
			if (sala.getId() == null) {
				sala = sa.insert(sala);
			} else {
				sala = sa.update(sala);
			}
			salas = sa.findByName(codArg);
		} catch (Exception e) {
			facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro: " + e.getMessage(), "");
			FacesContext.getCurrentInstance().addMessage("messagePanel", facesMsg);
			return;
		}
		facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sala gravado com sucesso!", "");
		FacesContext.getCurrentInstance().addMessage("messagePanel", facesMsg);
	}

	public void pesquisar() {
		try {
			salas = sa.findByName(codArg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void novo() {
		sala = new Sala();
	}

	public void cancelar() {
		sala = null;
	}

	public void editar(Long id) {
		try {
			sala = sa.find(id);
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
		sala = null;
	}

	public void excluir(Long id) {
		FacesMessage facesMsg;
		try {
			sa.delete(sa.find(id));
			salas = sa.findByCod(codArg);
		} catch (Exception e) {
			e.printStackTrace();
			facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro: " + e.getMessage(), "");
			FacesContext.getCurrentInstance().addMessage("messagePanel", facesMsg);
			return;
		}
		sala = null;
		facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sala excluído com sucesso!", "");
		FacesContext.getCurrentInstance().addMessage("messagePanel", facesMsg);
	}
}


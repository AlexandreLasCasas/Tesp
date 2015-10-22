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

@ManagedBean(name = "Salamb")
@ViewScoped
public class ControleSala {
	@Inject
	private Logger log;
	@Inject
	private ServicoSala sa;
	private Sala Sala;
	private String nomeArg;
	private List<Sala> Salas;

	public Sala getSala() {
		return Sala;
	}

	public void setSala(Sala Sala) {
		this.Sala = Sala;
	}

	public String getNomeArg() {
		return nomeArg;
	}

	public void setNomeArg(String nomeArg) {
		this.nomeArg = nomeArg;
	}

	public List<Sala> getSalas() {
		return Salas;
	}

	@PostConstruct
	public void inicializaLista() {
		log.info("Executando o MB de Sala");
		try {
			Salas = sa.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void gravar() {
		FacesMessage facesMsg;
		try {
			if (Sala.getId() == null) {
				Sala = sa.insert(Sala);
			} else {
				Sala = sa.update(Sala);
			}
			Salas = sa.findByName(nomeArg);
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
			Salas = sa.findByName(nomeArg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void novo() {
		Sala = new Sala(null, nomeArg, 0, false, false, false, nomeArg, 0, null);
	}

	public void cancelar() {
		Sala = null;
	}

	public void editar(Long id) {
		try {
			Sala = sa.find(id);
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
		Sala = null;
	}

	public void excluir(Long id) {
		FacesMessage facesMsg;
		try {
			sa.delete(sa.find(id));
			Salas = sa.findByName(nomeArg);
		} catch (Exception e) {
			e.printStackTrace();
			facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro: " + e.getMessage(), "");
			FacesContext.getCurrentInstance().addMessage("messagePanel", facesMsg);
			return;
		}
		Sala = null;
		facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sala excluído com sucesso!", "");
		FacesContext.getCurrentInstance().addMessage("messagePanel", facesMsg);
	}
}


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
	private ServicoSala ss;
	private Sala sala;
	private String codArg;
	private String nomeArg;
	private List<Sala> salas;
	private Long id;


	@PostConstruct
	public void inicializaLista() {
		log.info("Executando o MB de Sala");
		try {
			salas = ss.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void gravar() {
		FacesMessage facesMsg;
		try {
			if (sala.getId() == null) {
				sala = ss.insert(sala);
			} else {
				sala = ss.update(sala);
			}
			salas = ss.findByCod(codArg);
		} catch (Exception e) {
			facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro: " + e.getMessage(), "");
			FacesContext.getCurrentInstance().addMessage("messagePanel", facesMsg);
			return;
		}
		facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aluno gravado com sucesso!", "");
		FacesContext.getCurrentInstance().addMessage("messagePanel", facesMsg);
	}

	public void pesquisar() {
		try {
			salas = ss.findByCod(codArg);
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

	public void editar() {
		try {
			sala = ss.find(id);
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
		sala = null;
	}

	public void excluir() {
		FacesMessage facesMsg;
		try {
			ss.delete(ss.find(id));
			salas = ss.findByCod(codArg);
		} catch (Exception e) {
			e.printStackTrace();
			facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro: " + e.getMessage(), "");
			FacesContext.getCurrentInstance().addMessage("messagePanel", facesMsg);
			return;
		}
		sala = null;
		facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sala excluída com sucesso!", "");
		FacesContext.getCurrentInstance().addMessage("messagePanel", facesMsg);

	}
	
	
	// getters e setters
	
	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public String getNomeArg() {
		return nomeArg;
	}

	public void setNomeArg(String nomeArg) {
		this.nomeArg = nomeArg;
	}

	public List<Sala> getSalas() {
		return salas;
	}
	
	

	public String getCodArg() {
		return codArg;
	}

	public void setCodArg(String codArg) {
		this.codArg = codArg;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	


}

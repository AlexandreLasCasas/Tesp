package br.unibh.escola.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.unibh.escola.data.ServicoProfessor;
import br.unibh.escola.entidades.Professor;

@ManagedBean(name = "professormb")
@ViewScoped
public class ControleProfessor {

	@Inject
	private Logger log;

	@Inject
	private ServicoProfessor sp;
	private Professor professor;
	private String nomeArg;
	private List<Professor> professores;

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public String getNomeArg() {
		return nomeArg;
	}

	public void setNomeArg(String nomeArg) {
		this.nomeArg = nomeArg;
	}

	public List<Professor> getProfessores() {
		return professores;
	}

	@PostConstruct
	public void inicializaLista() {
		log.info("Executando o MB de Professor");
		try {
			professores = sp.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void gravar() {
		FacesMessage facesMsg;
		try {
			if (professor.getId() == null) {
				professor = sp.insert(professor);
			} else {
				professor = sp.update(professor);
			}
			professores = sp.findByName(nomeArg);
		} catch (Exception e) {
			facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro: " + e.getMessage(), "");
			FacesContext.getCurrentInstance().addMessage("messagePanel", facesMsg);
			return;
		}
		facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Professor gravado com sucesso!", "");
		FacesContext.getCurrentInstance().addMessage("messagePanel", facesMsg);
	}

	public void pesquisar() {
		try {
			professores = sp.findByName(nomeArg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void novo() {
		professor = new Professor();
	}

	public void cancelar() {
		professor = null;
	}

	public void editar(Long id) {
		try {
			professor = sp.find(id);
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
		professor = null;
	}

	public void excluir(Long id) {
		FacesMessage facesMsg;
		try {
			sp.delete(sp.find(id));
			professores = sp.findByName(nomeArg);
		} catch (Exception e) {
			e.printStackTrace();
			facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro: " + e.getMessage(), "");
			FacesContext.getCurrentInstance().addMessage("messagePanel", facesMsg);
			return;
		}
		professor = null;
		facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Professor excluído com sucesso!", "");
		FacesContext.getCurrentInstance().addMessage("messagePanel", facesMsg);

	}

}
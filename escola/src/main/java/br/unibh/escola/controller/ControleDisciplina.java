package br.unibh.escola.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.primefaces.model.DualListModel;

import br.unibh.escola.data.ServicoAluno;
import br.unibh.escola.data.ServicoDisciplina;
import br.unibh.escola.data.ServicoProfessor;
import br.unibh.escola.data.ServicoSala;
import br.unibh.escola.entidades.Aluno;
import br.unibh.escola.entidades.Disciplina;
import br.unibh.escola.entidades.Professor;
import br.unibh.escola.entidades.Sala;
@ManagedBean(name = "disciplinamb")
@ViewScoped
public class ControleDisciplina {
	@Inject
	private Logger log;
	@Inject
	EntityManager em;
	@Inject
	private ServicoDisciplina sd;
	@Inject
	private ServicoSala ss;
	@Inject
	private ServicoAluno sa;
	@Inject
	private ServicoProfessor sp;

	private Disciplina disciplina;
	private String disciplinaNome;
	private String cursoNome;
	private Long id;
	private List<Disciplina> disciplinas;

	public List<Professor> getProfessores() {
		try {
			return sp.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<Professor>();
	}

	public void setProfessores(List<Professor> professores) {
	}
	
	public List<Aluno> getListaAlunos(){
		try {
			return sa.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<Aluno>();
	}
	
	public List<Sala> getListaSalas() {
		try {
			return ss.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<Sala>();
	}

	

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public String getDisciplinaNome() {
		return disciplinaNome;
	}

	public void setDisciplinaNome(String disciplinaNome) {
		this.disciplinaNome = disciplinaNome;
	}

	public String getCursoNome() {
		return cursoNome;
	}

	public void setCursoNome(String cursoNome) {
		this.cursoNome = cursoNome;
	}

	public Long getId() {

		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setSalas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	@PostConstruct
	public void inicializaLista() {
		log.info("Executando o MB de Disciplina");
		try {
			disciplinas = sd.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void gravar() {
		FacesMessage facesMsg;
		try {
			if (disciplina.getId() == null) {
				disciplina = sd.insert(disciplina);
			} else {
				disciplina = sd.update(disciplina);
			}
		} catch (Exception e) {
			facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro: " + e.getMessage(), "");
			FacesContext.getCurrentInstance().addMessage("messagePanel", facesMsg);
			return;
		}
		facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Disciplina gravada com sucesso!", "");
		FacesContext.getCurrentInstance().addMessage("messagePanel", facesMsg);
	}

	public void pesquisar() {
		try {
			disciplinas = sd.findByNomeECurso(disciplinaNome, cursoNome);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void novo() {
		disciplina = new Disciplina();

	}

	public void cancelar() {
		disciplina = null;
	}

	public void editar() {
		try {
			disciplina = sd.find(id);
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
		disciplina = null;
	}

	public void excluir() {
		FacesMessage facesMsg;
		try {
			sd.delete(sd.find(id));
			disciplinas = sd.findByNomeECurso(disciplinaNome, cursoNome);
		} catch (Exception e) {
			e.printStackTrace();
		}
		disciplina = null;
		facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Disciplina excluída com sucesso!", "");
		FacesContext.getCurrentInstance().addMessage("messagePanel", facesMsg);
	}

	public Disciplina find(long k) throws Exception {
		log.info("encontrando disciplina " + k);
		Query query = em.createQuery("select d from Disciplina d join fetch d.alunos where d.id = :id");
		query.setParameter("id", k);
		return (Disciplina) query.getSingleResult();
	}
	
	@SuppressWarnings("unused")
	private DualListModel<Aluno> alunos;
	
	public DualListModel<Aluno> getAlunos(){
		List<Aluno> source = new ArrayList<Aluno>();
		List<Aluno> target = new ArrayList<Aluno>();
		if (disciplina != null && disciplina.getAlunos() != null) {
			target = disciplina.getAlunos();
		}
		try {
			source = sa.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if ( target.size() > 0) {
			for (Aluno a: target){
				source.remove(a);
			}
		}
		return new DualListModel<Aluno>(source,target);
	}
	
	public void setAlunos(DualListModel<Aluno> alunos){
		this.alunos = alunos;
		disciplina.setAlunos(alunos.getTarget());
	}
	
	
}

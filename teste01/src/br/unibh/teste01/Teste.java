package br.unibh.teste01;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.unibh.teste01.entidades.Aluno;
import br.unibh.teste01.entidades.Professor;
import br.unibh.teste01.persistence.AlunoDAO;
import br.unibh.teste01.persistence.ProfessorDAO;


public class Teste {
	
	/**
	 * Testes no objeto Aluno
	 */

	@Test
	public void testeAlunoFindAll() {
		AlunoDAO dao = new AlunoDAO();
		List<Aluno> lista = dao.findAll();
		
		Assert.assertEquals(lista.size(), 100);
		
		System.out.println("Lista de alunos encontrada");
	}

	@Test
	public void testeAlunoFind() {
		AlunoDAO dao = new AlunoDAO();
		Aluno a = dao.find(1L);
		Assert.assertEquals(a.getNome(), "Teste");
		
		System.out.println("Nome do aluno foi encontrado");
	}
	
	@Test
	public void testeAlunoCRUD() {
		AlunoDAO dao = new AlunoDAO();
		Aluno aluno = new Aluno(null, "Alexandre", "12345678913", "11325776", new Date(2000-05-20));
		dao.insert(aluno);
		System.out.println("Insert de "+ aluno.getNome() + " realizado");
		
		Aluno buscaAluno = dao.find("Alexandre");
		Assert.assertNotNull(buscaAluno);
		System.out.println(aluno.getNome() + " Encontrado");
		
		buscaAluno.setNome("Las Casas");
		dao.update(buscaAluno);
		
		Aluno atualizado = dao.find("Las Casas");
		Assert.assertNotNull(atualizado);
		System.out.println(aluno.getNome() + " atualizado para " + buscaAluno.getNome());
		
		dao.delete(buscaAluno);
		Aluno deletado = dao.find("Las Casas");
		Assert.assertNull(deletado);
		System.out.println(buscaAluno.getNome() + " foi deletado");
		
	}
	
	/**
	 * Testes no objeto Professor
	 */
	
	@Test
	public void testeProfessorFindAll(){
		ProfessorDAO dao = new ProfessorDAO();
		List<Professor> lista = dao.findAll();
		
		Assert.assertEquals(lista.size(), 100);
		
		System.out.println("Lista de professores encontrada");
	}
	
	@Test
	public void testeProfessorFind() {
		ProfessorDAO dao = new ProfessorDAO();
		Professor cruvnel = dao.find(1L);
		Assert.assertEquals(cruvnel.getNome(), "Teste");;
		System.out.println("Professor encontrado");
	}
	
	@Test
	public void testeProfessorCRUD() {
		ProfessorDAO dao = new ProfessorDAO();
		Professor prof = new Professor(null, "Cruvnel", "12233344440", new BigDecimal(10500.25));
		dao.insert(prof);
		System.out.println("Insert de "+ prof.getNome() + " realizado");
		
		Professor buscaProf = dao.find("Cruvnel");
		Assert.assertNotNull(buscaProf);
		System.out.println(prof.getNome() + " Encontrado");
		
		buscaProf.setNome("Humberto");
		dao.update(buscaProf);
		
		Professor atualizado = dao.find("Humberto");
		Assert.assertNotNull(atualizado);
		System.out.println(prof.getNome() + " atualizado para " + buscaProf.getNome());
		
		dao.delete(buscaProf);
		Professor deletado = dao.find("Humberto");
		Assert.assertNull(deletado);
		System.out.println(buscaProf.getNome() + " foi deletado");
		
	}
}

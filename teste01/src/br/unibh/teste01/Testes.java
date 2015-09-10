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

//Teste automatizado é necessário colocar o @Test


public class Testes {

	@Test
	public void testeAlunoFindAll() {
		AlunoDAO dao = new AlunoDAO();
		List<Aluno> lista = dao.findAll();
		Assert.assertEquals(lista.size(), 104); // 

	}
	
	@Test
	public void testeAlunoFind(){
		AlunoDAO dao = new AlunoDAO();
		Aluno a = dao.find(2L); // id 2 L = tipo Long
		Assert.assertEquals(a.getNome(),"Jordan S. Pena");
		// Vai verificar se na linha 2 exisi Jordam
		
	}
	
	@Test
	public void testeAlunoInsertEDelete(){
		AlunoDAO dao = new AlunoDAO();
		Aluno a = new Aluno(null,"beltrano", "79312382312", "24234234",new Date());
		
		dao.insert(a); //Inserirá o objeto aos dados acima de aluno
		
		Aluno b = dao.find("beltrano"); // Selecionará atraves do ID e trazer o nome
		
		b.setNome("Alexandre Las Casas"); // Fará select buscando com like pelo SetNome
		dao.update(b); // Fará update no banco trocando beltrano por EudeJ
			
		dao.delete(b); // Deletará no banco por id
		Assert.assertNotNull(b); // Verificará se existe no banco não tendo volta null
				
	
	}
	public void testeProfessorFindAll() {
		ProfessorDAO dao = new ProfessorDAO();
		List<Professor> lista = dao.findAll();
		Assert.assertEquals(lista.size(), 103); // 

	}
	
	@Test
	public void testeProfessorFind(){
		ProfessorDAO dao = new ProfessorDAO();
		Professor a = dao.find(100L); // id 2 L = Tipo de variável Long
		Assert.assertEquals(a.getNome(),"Kay A. Frye");
		// Verificará se na linha 2 existe Jordam
		
	}
	
	@Test
	public void testeProfessorInsertEDelete(){
		ProfessorDAO dao = new ProfessorDAO();
		Professor pro = new Professor(null,"Alexandre","98409563456",new BigDecimal(1500.00));
	
		dao.insert(pro); //Inserirá o objeto a que sãos os dados acima de aluno
		
		Professor leo = dao.find("Alexandre"); //Selecionará através do ID e trazer o nome
		
		leo.setNome("Alexandre Las Casas"); //Fará select buscando com like pelo SetNome
		dao.update(leo); // Vai fazer update no banco trocando beltrano por EudeJ
			
		dao.delete(leo); //Deletará no banco por id
		Assert.assertNotNull(leo); //Verifcará se existe no banco não tendo volta null
	}
	
}

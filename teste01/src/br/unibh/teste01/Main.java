package br.unibh.teste01;
import java.sql.Connection;
import java.util.List;

import br.unibh.teste01.entidades.Aluno;
import br.unibh.teste01.entidades.Professor;
import br.unibh.teste01.persistence.AlunoDAO;
import br.unibh.teste01.persistence.JDBCUtil;
import br.unibh.teste01.persistence.ProfessorDAO;



public class Main {

	public static void main(String[] args) {
		
		AlunoDAO dao =new  AlunoDAO();
		List <Aluno> lista = dao.findAll();
		for (Aluno a:lista){
		System.out.println(a);
		
		try {
			Connection c = JDBCUtil.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
				
			
		}
			}
		
	
	ProfessorDAO daoa =new  ProfessorDAO();
	List <Professor> listaa = daoa.findAll();
	for (Professor b:listaa){
	System.out.println(b);
	
	try {
		Connection c = JDBCUtil.getConnection();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

	}
}
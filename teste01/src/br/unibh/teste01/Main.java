package br.unibh.teste01;

import java.sql.Connection;

import br.unibh.teste01.persistence.JDBCUtil;

public class Main {

	public static void main(String[] args) {
		/*		
		Aluno a1 = new Aluno(1L, "Alexandre", "1213445155", "11325776", new Date());
		
		System.out.println(a1);
		
		Professor prof1 = new Professor(19L, "Cruvnel", "0002342121", new BigDecimal(20000));
		
		System.out.println(prof1);
		
		System.out.println("" + prof1.getSalario());
		
		System.out.println(Professor.BONUS);
		*/
		try {
			
			Connection c = JDBCUtil.getConnection();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

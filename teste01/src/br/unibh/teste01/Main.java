package br.unibh.teste01;

import java.math.BigDecimal;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		
		/** Retirar para funcionar classe abstrata
		Pessoa p1 = new Pessoa();
		p1.setId(11L);
		p1.setNome("Maria da Silva");
		p1.setCpf("123213123");
		
		Pessoa p2 = new Pessoa(12L, "João da Silva", "1297361827");
		
		Pessoa p3 = new Pessoa(13L, "Tiago da Silva");
		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		**/
		
		Aluno a1 = new Aluno(new Long(14), "Adriana Silva", "12121212121232323",
				   "12121212 ", new Date());
		
		System.out.println(a1);
		
		Professor prof1 = new Professor (15L, "Jose Humberto", "313131313131313131", 
						  new BigDecimal(1000));
		
		System.out.println(prof1);
		
	}

}

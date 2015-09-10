package br.unibh.teste01.persistence;

import java.util.List;

public interface DAO <T, K> {

	// � uma classe gen�rica que serve para chamar os dados da Classe Aluno e Professor
	// T e K e coringa pra chamar a Classe e o par�metro geralmente ID da classe
	
	public T find (K id);
	public void insert (T t);
	public void update (T t);
	public void delete(T t);
	public List <T> findAll();
	
	
}

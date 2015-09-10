package br.unibh.teste01.persistence;

import java.util.List;

public interface DAO <T, K> {

	// Classe generica para chamar os dados da Classe Aluno e Professor
	// T e K e curinga pra chamar a Classe e o parametro geralmente ID da classe
	
	public T find (K id);
	public void insert (T t);
	public void update (T t);
	public void delete(T t);
	public List <T> findAll();
	
	
}

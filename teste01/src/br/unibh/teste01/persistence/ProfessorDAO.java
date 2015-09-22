package br.unibh.teste01.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.unibh.teste01.entidades.Professor;

public class ProfessorDAO implements DAO<Professor, Long>{

	@Override
	public Professor find(Long id) {
		try {
			PreparedStatement p = JDBCUtil.getConnection()
					.prepareStatement("select id, nome, cpf, salario from tb_professor where id = ?");
			p.setLong(1, id);			
			ResultSet res = p.executeQuery();
			
			if (res.next()){
				return new Professor(
									res.getLong("id"),
									res.getString("nome"),
									res.getString("cpf"),
									res.getBigDecimal("salario"));
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeConnection();
		}
		return null;
	}
	
	public Professor find(String nome) {
		try {
			PreparedStatement p = JDBCUtil.getConnection()
					.prepareStatement("SELECT * FROM tb_professor WHERE NOME LIKE ?");
			p.setString(1, nome + "%");
			ResultSet res = p.executeQuery();

			if (res.next()){
				return new Professor(
									res.getLong("id"),
									res.getString("nome"),
									res.getString("cpf"),
									res.getBigDecimal("salario"));
			}	

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection();
		}
		return null;
	}

	@Override
	public void insert(Professor t) {
		try {
			PreparedStatement p = JDBCUtil.getConnection()
					.prepareStatement("insert into tb_professor (id, nome, cpf, salario) "
							+ "select max(id) + 1, ?, ?, ? from tb_professor");
			p.setString(1, t.getNome());
			p.setString(2, t.getCpf());
			p.setBigDecimal(3, t.getSalario());
			p.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection();
		}		
	}

	@Override
	public void update(Professor t) {
		try {
			PreparedStatement p = JDBCUtil.getConnection()
					.prepareStatement("update tb_professor "
									+ "set nome = ?, cpf = ?, salario = ? "
									+ "where id = ?");
			p.setString(1, t.getNome());
			p.setString(2, t.getCpf());
			p.setBigDecimal(3, t.getSalario());
			p.setLong(4, t.getId());
			p.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeConnection();
		}		
	}

	@Override
	public void delete(Professor t) {
		try {
			PreparedStatement p = JDBCUtil.getConnection()
					.prepareStatement("delete from tb_professor where id = ?");
			p.setLong(1, t.getId());
			p.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	@Override
	public List<Professor> findAll() {
		ArrayList<Professor> lista = new ArrayList<Professor>();
		try {
			ResultSet res = JDBCUtil.getConnection()
					.prepareStatement("select id, nome, cpf, salario from tb_professor")
					.executeQuery();
			
			while (res.next()) {
				lista.add(new Professor(
										res.getLong("id"),
										res.getString("nome"),
										res.getString("cpf"),
										res.getBigDecimal("salario")));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection();
		}
		return lista;
	}
	
}
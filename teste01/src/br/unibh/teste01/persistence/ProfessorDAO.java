package br.unibh.teste01.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.unibh.teste01.entidades.Professor;

public class ProfessorDAO implements DAO<Professor, Long> {

	//public static DecimalFormat dc = new DecimalFormat("00000000000000.00");
	// coltr+shif+f Formata o codigo
	// Professor , Long e subustituido por T e K na classe DAO
	// T e K e curinga pra chamar a Classe e o parametro geralmente ID da classe

	@Override
	public Professor find(Long id) {
		try {

			PreparedStatement p = JDBCUtil.getConnection().prepareStatement("Select * from tb_professor where id=?");
			p.setLong(1, id);
			ResultSet res = p.executeQuery();
			if (res.next()) {
				return new Professor(res.getLong("id"), res.getString("nome"), res.getString("cpf"),
						res.getBigDecimal("salario"));
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection();

		}
		return null;

	}

	public Professor find(String nome) {

		try {

			PreparedStatement p = JDBCUtil.getConnection()
					.prepareStatement("Select * from tb_professor where nome like ?");
			p.setString(1, nome + "%");
			ResultSet res = p.executeQuery();
			if (res.next()) {
				return new Professor(res.getLong("id"), res.getString("nome"), res.getString("cpf"),
						res.getBigDecimal("salario"));

			}

		} catch (Exception e) {
			// TODO: handle exception
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
					.prepareStatement("insert into  tb_professor" + " (nome,cpf,salario)" + "values (?,?,?)");

			p.setString(1, t.getNome());
			p.setString(2, t.getCpf());
			p.setBigDecimal(3, t.getSalario());
			p.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection();
		}

	}

	@Override
	public void update(Professor t) {
		try {

			PreparedStatement p = JDBCUtil.getConnection()
					.prepareStatement("update  tb_professor set nome=?, cpf=?, salario=?" + "where id=?");

			p.setString(1, t.getNome());
			p.setString(2, t.getCpf());
			p.setBigDecimal(3, t.getSalario());
			p.setLong(4, t.getId());
			p.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection();
		}

	}

	@Override
	public void delete(Professor t) {
		try {

			PreparedStatement p = JDBCUtil.getConnection().prepareStatement("delete from  tb_professor where id= ?");

			p.setLong(1, t.getId());
			p.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JDBCUtil.closeConnection();
		}

	}

	@Override
	public List<Professor> findAll() {

		ArrayList<Professor> listaa = new ArrayList<Professor>();
		try {

			ResultSet res = JDBCUtil.getConnection().prepareStatement("Select * from tb_professor").executeQuery();

			while (res.next()) {
				listaa.add(new Professor(res.getLong("id"), res.getString("nome"), res.getString("cpf"),
						res.getBigDecimal("salario")));

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			JDBCUtil.closeConnection();
		}
		// TODO Auto-generated method stub
		return listaa;
	}
}

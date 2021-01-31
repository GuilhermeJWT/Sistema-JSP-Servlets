package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.SingleConnection;
import model.ModelTelefonesFornecedores;

public class DaoTelefonesFornecedores {
	
	private Connection connection;
	
	public DaoTelefonesFornecedores() {
		connection = SingleConnection.getConnection();
	}
	
	public void salvarTelefonesFornecedores(ModelTelefonesFornecedores modelTelefonesFornecedores) {

		try {

			String sql = "insert into telefonesfornecedores(numero, tipo, fornecedor) values (?,?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, modelTelefonesFornecedores.getNumero());
			stmt.setString(2, modelTelefonesFornecedores.getTipo());
			stmt.setLong(3, modelTelefonesFornecedores.getFornecedores());
			stmt.execute();
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	public List<ModelTelefonesFornecedores> listarTelefonesFornecedores(Long forn) throws Exception {

		List<ModelTelefonesFornecedores> listaTelefonesFornecedores = new ArrayList<ModelTelefonesFornecedores>();

		String sql = "select * from telefonesfornecedores where fornecedor = " + forn;
		PreparedStatement stmt = connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			ModelTelefonesFornecedores modelTelefonesFornecedores = new ModelTelefonesFornecedores();
			modelTelefonesFornecedores.setId(rs.getLong("id"));
			modelTelefonesFornecedores.setNumero(rs.getString("numero"));
			modelTelefonesFornecedores.setTipo(rs.getString("tipo"));
			modelTelefonesFornecedores.setFornecedores(rs.getLong("fornecedor"));
			listaTelefonesFornecedores.add(modelTelefonesFornecedores);
		}

		return listaTelefonesFornecedores;
	}

	public void deleteTelefonesFornecedores(Long id) {

		try {

			String sql = "delete from telefonesfornecedores where id = '" + id + "'";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.execute();
			connection.commit();

		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

	}

}

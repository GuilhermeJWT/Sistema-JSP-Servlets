package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.SingleConnection;
import model.ModelTelefonesClientes;

public class DaoTelefonesClientes {
	
	private Connection connection;

	public DaoTelefonesClientes() {
		connection = SingleConnection.getConnection();
	}

	public void salvarTelefonesClientes(ModelTelefonesClientes modelTelefonesClientes) {

		try {

			String sql = "insert into telefonesclientes(numero, tipo, clientes) values (?,?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, modelTelefonesClientes.getNumero());
			stmt.setString(2, modelTelefonesClientes.getTipo());
			stmt.setLong(3, modelTelefonesClientes.getClientes());
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

	public List<ModelTelefonesClientes> listarTelefonesClientes(Long cli) throws Exception {

		List<ModelTelefonesClientes> listaTelefonesClientes = new ArrayList<ModelTelefonesClientes>();

		String sql = "select * from telefonesclientes where clientes = " + cli;
		PreparedStatement stmt = connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			ModelTelefonesClientes modelTelefonesClientes = new ModelTelefonesClientes();
			modelTelefonesClientes.setId(rs.getLong("id"));
			modelTelefonesClientes.setNumero(rs.getString("numero"));
			modelTelefonesClientes.setTipo(rs.getString("tipo"));
			modelTelefonesClientes.setClientes(rs.getLong("clientes"));
			listaTelefonesClientes.add(modelTelefonesClientes);
		}

		return listaTelefonesClientes;
	}

	public void deleteTelefonesClientes(Long id) {

		try {

			String sql = "delete from telefonesclientes where id = '" + id + "'";
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
	
	/*

	public ModelClientes consultar(String cli) throws Exception {
		String sql = "select * from clientes where id = '" + cli + "'";
		PreparedStatement stmt = connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			ModelClientes modelClientes = new ModelClientes();
			modelClientes.setId(rs.getLong("id"));
			modelClientes.setNome(rs.getString("nome"));
			modelClientes.setEmail(rs.getString("email"));
			modelClientes.setRg(rs.getString("rg"));
			modelClientes.setCpf(rs.getString("cpf"));
			modelClientes.setCep(rs.getString("cep"));
			modelClientes.setRua(rs.getString("rua"));
			modelClientes.setBairro(rs.getString("bairro"));
			modelClientes.setCidade(rs.getString("cidade"));
			modelClientes.setEstado(rs.getString("estado"));
			modelClientes.setIbge(rs.getString("Ibge"));
			return modelClientes;
		}
		return null;
	}
	
	*/

}

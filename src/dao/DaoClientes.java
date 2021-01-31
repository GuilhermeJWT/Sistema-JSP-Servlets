package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.SingleConnection;
import model.ModelClientes;

public class DaoClientes {

	private Connection connection;

	public DaoClientes() {
		connection = SingleConnection.getConnection();
	}

	public void salvarClientes(ModelClientes modelClientes) {

		try {

			String sql = "insert into clientes(nome, email, rg, cpf, cep, rua, bairro, cidade, estado, ibge, fotobase64, contenttype"
					+ ") values (?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, modelClientes.getNome());
			stmt.setString(2, modelClientes.getEmail());
			stmt.setString(3, modelClientes.getRg());
			stmt.setString(4, modelClientes.getCpf());
			stmt.setString(5, modelClientes.getCep());
			stmt.setString(6, modelClientes.getRua());
			stmt.setString(7, modelClientes.getBairro());
			stmt.setString(8, modelClientes.getCidade());
			stmt.setString(9, modelClientes.getEstado());
			stmt.setString(10, modelClientes.getIbge());
			stmt.setString(11, modelClientes.getFotoBase64());
			stmt.setString(12, modelClientes.getContentType());
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
	
	

	public List<ModelClientes> listaClientes() throws Exception {

		List<ModelClientes> listaClientes = new ArrayList<ModelClientes>();

		String sql = "select * from clientes";
		PreparedStatement stmt = connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
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
			modelClientes.setFotoBase64(rs.getString("fotobase64"));
			modelClientes.setContentType(rs.getString("contenttype"));
			listaClientes.add(modelClientes);
		}

		return listaClientes;
	}
	
	public List<ModelClientes> consultarPorNome(String pesquisaCliente) throws Exception {

		List<ModelClientes> listaClientes = new ArrayList<ModelClientes>();

		String sql = "select * from clientes where nome like '%"+pesquisaCliente+"%'";
		PreparedStatement stmt = connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
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
			modelClientes.setFotoBase64(rs.getString("fotobase64"));
			modelClientes.setContentType(rs.getString("contenttype"));
			listaClientes.add(modelClientes);
		}

		return listaClientes;
	}
	
	public List<ModelClientes> listaClientesRelatorio() throws Exception {

		List<ModelClientes> listaClientes = new ArrayList<ModelClientes>();

		String sql = "select * from clientes";
		PreparedStatement stmt = connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			ModelClientes modelClientes = new ModelClientes();
			modelClientes.setId(rs.getLong("id"));
			modelClientes.setNome(rs.getString("nome"));
			modelClientes.setCidade(rs.getString("cidade"));
			modelClientes.setEstado(rs.getString("estado"));
			modelClientes.setCep(rs.getString("cep"));
 			listaClientes.add(modelClientes);
		}

		return listaClientes;
	}


	public void delete(Long id) {

		try {

			String sql = "delete from clientes where id = '" + id + "'";
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
			modelClientes.setIbge(rs.getString("ibge"));
			modelClientes.setFotoBase64(rs.getString("fotobase64"));
			modelClientes.setContentType(rs.getString("contenttype"));
			return modelClientes;
		}
		return null;
	}

	public void atualizar(ModelClientes modelClientes) {

		try {

			String sql = "update clientes set nome = ?, email = ?, rg = ?, cpf = ?, cep = ?,"
					+ " rua = ?, bairro = ?, cidade = ?, estado = ?, ibge = ?, fotobase64 = ?, contenttype = ? where id = '" + modelClientes.getId()
					+ "'";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, modelClientes.getNome());
			stmt.setString(2, modelClientes.getEmail());
			stmt.setString(3, modelClientes.getRg());
			stmt.setString(4, modelClientes.getCpf());
			stmt.setString(5, modelClientes.getCep());
			stmt.setString(6, modelClientes.getRua());
			stmt.setString(7, modelClientes.getBairro());
			stmt.setString(8, modelClientes.getCidade());
			stmt.setString(9, modelClientes.getEstado());
			stmt.setString(10, modelClientes.getIbge());
			stmt.setString(11, modelClientes.getFotoBase64());
			stmt.setString(12, modelClientes.getContentType());
			stmt.executeUpdate();
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
	
	public boolean validarCpf(String cpf) throws Exception {
		String sql = "select count(1) as qtd from clientes where cpf = '" + cpf + "'";
		PreparedStatement stmt = connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			return rs.getInt("qtd") <=0;
		}
		return false;
	}
	
	public boolean validarCpfUpdate(String cpf, String id) throws Exception {
		String sql = "select count(1) as qtd from clientes where cpf = '" + cpf + "' and id <> " + id;
		PreparedStatement stmt = connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			return rs.getInt("qtd") <=0;
		}
		return false;
	}
	
}

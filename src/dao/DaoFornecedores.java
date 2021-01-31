package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.SingleConnection;
import model.ModelFornecedores;

public class DaoFornecedores {

	private Connection connection;

	public DaoFornecedores() {
		connection = SingleConnection.getConnection();
	}

	public void salvarFornecedores(ModelFornecedores modelFornecedores) {

		try {

			String sql = "insert into fornecedores(nome, razaosocial, cnpj, cep, rua, bairro, cidade, estado, ibge, pessoa, "
					+ "inscricaoestadual, inscricaomunicipal, email, fotobase64, contenttype"
					+ ") values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, modelFornecedores.getNome());
			stmt.setString(2, modelFornecedores.getRazaosocial());
			stmt.setString(3, modelFornecedores.getCnpj());
			stmt.setString(4, modelFornecedores.getCep());
			stmt.setString(5, modelFornecedores.getRua());
			stmt.setString(6, modelFornecedores.getBairro());
			stmt.setString(7, modelFornecedores.getCidade());
			stmt.setString(8, modelFornecedores.getEstado());
			stmt.setString(9, modelFornecedores.getIbge());
			stmt.setString(10, modelFornecedores.getPessoa());
			stmt.setString(11, modelFornecedores.getInscricaoestadual());
			stmt.setString(12, modelFornecedores.getInscricaomunicipal());
			stmt.setString(13, modelFornecedores.getEmail());
			stmt.setString(14, modelFornecedores.getFotoBase64());
			stmt.setString(15, modelFornecedores.getContentType());
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

	public List<ModelFornecedores> listaFornecedores() throws Exception {

		List<ModelFornecedores> listaFornecedores = new ArrayList<ModelFornecedores>();

		String sql = "select * from fornecedores";
		PreparedStatement stmt = connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			ModelFornecedores modelFornecedores = new ModelFornecedores();
			modelFornecedores.setId(rs.getLong("id"));
			modelFornecedores.setNome(rs.getString("nome"));
			modelFornecedores.setRazaosocial(rs.getString("razaosocial"));
			modelFornecedores.setCnpj(rs.getString("cnpj"));
			modelFornecedores.setCep(rs.getString("cep"));
			modelFornecedores.setRua(rs.getString("rua"));
			modelFornecedores.setBairro(rs.getString("bairro"));
			modelFornecedores.setCidade(rs.getString("cidade"));
			modelFornecedores.setEstado(rs.getString("estado"));
			modelFornecedores.setIbge(rs.getString("Ibge"));
			modelFornecedores.setPessoa(rs.getString("pessoa"));
			modelFornecedores.setInscricaoestadual(rs.getString("inscricaoestadual"));
			modelFornecedores.setInscricaomunicipal(rs.getString("inscricaomunicipal"));
			modelFornecedores.setEmail(rs.getString("email"));
			modelFornecedores.setFotoBase64(rs.getString("fotobase64"));
			modelFornecedores.setContentType(rs.getString("contenttype"));
			listaFornecedores.add(modelFornecedores);
		}

		return listaFornecedores;
	}
	
	public List<ModelFornecedores> consultarPorNome(String pesquisaFornecedor) throws Exception {

		List<ModelFornecedores> listaFornecedores = new ArrayList<ModelFornecedores>();

		String sql = "select * from fornecedores where nome like '%"+pesquisaFornecedor+"%'";
		PreparedStatement stmt = connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			ModelFornecedores modelFornecedores = new ModelFornecedores();
			modelFornecedores.setId(rs.getLong("id"));
			modelFornecedores.setNome(rs.getString("nome"));
			modelFornecedores.setRazaosocial(rs.getString("razaosocial"));
			modelFornecedores.setCnpj(rs.getString("cnpj"));
			modelFornecedores.setCep(rs.getString("cep"));
			modelFornecedores.setRua(rs.getString("rua"));
			modelFornecedores.setBairro(rs.getString("bairro"));
			modelFornecedores.setCidade(rs.getString("cidade"));
			modelFornecedores.setEstado(rs.getString("estado"));
			modelFornecedores.setIbge(rs.getString("Ibge"));
			modelFornecedores.setPessoa(rs.getString("pessoa"));
			modelFornecedores.setInscricaoestadual(rs.getString("inscricaoestadual"));
			modelFornecedores.setInscricaomunicipal(rs.getString("inscricaomunicipal"));
			modelFornecedores.setEmail(rs.getString("email"));
			modelFornecedores.setFotoBase64(rs.getString("fotobase64"));
			modelFornecedores.setContentType(rs.getString("contenttype"));
			listaFornecedores.add(modelFornecedores);
		}

		return listaFornecedores;
	}

	public void delete(Long id) {

		try {

			String sql = "delete from fornecedores where id = '" + id + "'";
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

	public ModelFornecedores consultar(String forn) throws Exception {
		String sql = "select * from fornecedores where id = '" + forn + "'";
		PreparedStatement stmt = connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			ModelFornecedores modelFornecedores = new ModelFornecedores();
			modelFornecedores.setId(rs.getLong("id"));
			modelFornecedores.setNome(rs.getString("nome"));
			modelFornecedores.setRazaosocial(rs.getString("razaosocial"));
			modelFornecedores.setCnpj(rs.getString("cnpj"));
			modelFornecedores.setCep(rs.getString("cep"));
			modelFornecedores.setRua(rs.getString("rua"));
			modelFornecedores.setBairro(rs.getString("bairro"));
			modelFornecedores.setCidade(rs.getString("cidade"));
			modelFornecedores.setEstado(rs.getString("estado"));
			modelFornecedores.setIbge(rs.getString("ibge"));
			modelFornecedores.setPessoa(rs.getString("pessoa"));
			modelFornecedores.setInscricaoestadual(rs.getString("inscricaoestadual"));
			modelFornecedores.setInscricaomunicipal(rs.getString("inscricaomunicipal"));
			modelFornecedores.setEmail(rs.getString("email"));
			modelFornecedores.setFotoBase64(rs.getString("fotobase64"));
			modelFornecedores.setContentType(rs.getString("contenttype"));
			return modelFornecedores;
		}
		return null;
	}

	public void atualizar(ModelFornecedores modelFornecedores) {

		try {

			String sql = "update fornecedores set nome = ?, razaosocial = ?, cnpj = ?, cep = ?,"
					+ " rua = ?, bairro = ?, cidade = ?, estado = ?, ibge = ?, pessoa = ?, inscricaoestadual = ?, inscricaomunicipal = ?, email = ?, fotobase64 = ?, contenttype = ? where id = '" + modelFornecedores.getId()
					+ "'";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, modelFornecedores.getNome());
			stmt.setString(2, modelFornecedores.getRazaosocial());
			stmt.setString(3, modelFornecedores.getCnpj());
			stmt.setString(4, modelFornecedores.getCep());
			stmt.setString(5, modelFornecedores.getRua());
			stmt.setString(6, modelFornecedores.getBairro());
			stmt.setString(7, modelFornecedores.getCidade());
			stmt.setString(8, modelFornecedores.getEstado());
			stmt.setString(9, modelFornecedores.getIbge());
			stmt.setString(10, modelFornecedores.getPessoa());
			stmt.setString(11, modelFornecedores.getInscricaoestadual());
			stmt.setString(12, modelFornecedores.getInscricaomunicipal());
			stmt.setString(13, modelFornecedores.getEmail());
			stmt.setString(14, modelFornecedores.getFotoBase64());
			stmt.setString(15, modelFornecedores.getContentType());
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
	
	public boolean validarCnpj(String cnpj) throws Exception {
		String sql = "select count(1) as qtd from fornecedores where cnpj = '" + cnpj + "'";
		PreparedStatement stmt = connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			return rs.getInt("qtd") <=0;
		}
		return false;
	}
	
	public boolean validarCnpjUpdate(String cnpj, String id) throws Exception {
		String sql = "select count(1) as qtd from fornecedores where cnpj = '" + cnpj + "' and id <> " + id;
		PreparedStatement stmt = connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			return rs.getInt("qtd") <=0;
		}
		return false;
	}
	
}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.SingleConnection;
import model.ModelUsuarios;

public class DaoLogin {

	ModelUsuarios modelUsuarios = new ModelUsuarios();

	private Connection connection;

	public DaoLogin() {
		connection = SingleConnection.getConnection();
	}

	public boolean validarLogin(String login, String senha) throws Exception {

		String sql = "select * from usuarios where login = '" + login + "' and senha = '" + senha + "'";

		PreparedStatement stmt = connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			return true; /* Possui Usuario */
		} else {
			return false;
		}
	}

	public void salvar(ModelUsuarios modelUsuarios){
		
		try {
			
		String sql = "insert into usuarios(login, senha, nome) values (?, ?, ?)";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, modelUsuarios.getLogin());
		stmt.setString(2, modelUsuarios.getSenha());
		stmt.setString(3, modelUsuarios.getNome());
		stmt.execute();
		connection.commit();
		}catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
}

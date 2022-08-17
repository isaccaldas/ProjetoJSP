package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.SingleConnectionBD;
import model.ModelLogin;

public class DAOLoginRepository {

	private Connection conexao;
	
	public DAOLoginRepository(){
		conexao = SingleConnectionBD.getConexao();
	}
	
	public boolean validarLogin(ModelLogin modelLogin) throws SQLException {
		
		String sql = "SELECT * FROM usuario WHERE upper(login) = upper(?) AND senha = upper(?)"; 
		
		PreparedStatement statement = conexao.prepareStatement(sql);
		
		statement.setString(1, modelLogin.getLogin());
		statement.setString(2, modelLogin.getSenha());
	
		ResultSet resultado = statement.executeQuery();
		
		if (resultado.next()) {
			return true;
		}	
		
		else {
			return false;
		}
		
	
	}
	
	
}

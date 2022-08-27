package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.SingleConnectionBD;
import model.ModelLogin;

public class DAOUsuarioRepository {

	private Connection conexao;
	
	public DAOUsuarioRepository() {
		
		conexao = SingleConnectionBD.getConexao();
	}
	
	public void incluirUsuario(ModelLogin usuario) throws SQLException {
		
		String sql = "INSERT INTO public.usuario(login, senha, nome, email) VALUES ( ?, ?, ?, ?)";
		
		PreparedStatement statement = conexao.prepareStatement(sql);
		
		statement.setString(1, usuario.getLogin());
		statement.setString(2, usuario.getSenha());
		statement.setString(3, usuario.getNome());
		statement.setString(4, usuario.getEmail());
	
		
		statement.execute();
		conexao.commit();
	}
	
	
}

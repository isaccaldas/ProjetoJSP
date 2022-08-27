package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.SingleConnectionBD;
import model.ModelLogin;

public class DAOUsuarioRepository {

	private Connection conexao;
	
	public DAOUsuarioRepository() {
		
		conexao = SingleConnectionBD.getConexao();
	}
	
	public ModelLogin incluirUsuario(ModelLogin usuario) throws SQLException {
		
		String sql = "INSERT INTO public.usuario(login, senha, nome, email) VALUES ( ?, ?, ?, ?)";
		
		PreparedStatement statement = conexao.prepareStatement(sql);
		
		statement.setString(1, usuario.getLogin());
		statement.setString(2, usuario.getSenha());
		statement.setString(3, usuario.getNome());
		statement.setString(4, usuario.getEmail());
	
		statement.execute();
		conexao.commit();
		
		return this.consultarUsuario(usuario.getLogin());
	}
	
	
	public ModelLogin consultarUsuario(String login) throws SQLException {
		
		var usuario = new ModelLogin();
		
		String sql = "SELECT login, senha, id, nome, email FROM public.usuario WHERE upper(login) = upper('" +login +"')";
		
		PreparedStatement statement = conexao.prepareStatement(sql);
		
		ResultSet resultado = statement.executeQuery();
		
		//Se tiver resultado, faz a injeçao no objeto
		while (resultado.next()) {
			
			usuario.setId(resultado.getString("id"));
			usuario.setEmail(resultado.getString("email"));
			usuario.setLogin(resultado.getString("login"));
			usuario.setSenha(resultado.getString("senha"));
			usuario.setNome(resultado.getString("nome"));
		}	
		
		return usuario;
		
	}
	
}

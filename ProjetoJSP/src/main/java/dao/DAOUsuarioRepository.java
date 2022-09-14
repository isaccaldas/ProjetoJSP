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
	
	//método para cadastrar um usuário no sistema
	public ModelLogin incluirUsuario(ModelLogin usuario) throws SQLException {
		
		if(usuario.isNovoRegistro()) {
		
		String sql = "INSERT INTO public.usuario(login, senha, nome, email) VALUES ( ?, ?, ?, ?)";
		
		PreparedStatement statement = conexao.prepareStatement(sql);
		
		statement.setString(1, usuario.getLogin());
		statement.setString(2, usuario.getSenha());
		statement.setString(3, usuario.getNome());
		statement.setString(4, usuario.getEmail());
	
		statement.execute();
		conexao.commit();
		
		} else {
			EditarUsuario(usuario);
		}
		
		return this.consultarUsuarioporLogin(usuario.getLogin());
	
		
		}// fim incluirUsuario
	
		public ModelLogin EditarUsuario(ModelLogin usuario) throws SQLException {
		
		String sql = "UPDATE public.usuario SET login=?, senha=?, nome=?,  email=? WHERE id =" +usuario.getId()+";";
		
		PreparedStatement statement = conexao.prepareStatement(sql);
		
		statement.setString(1, usuario.getLogin());
		statement.setString(2, usuario.getSenha());
		statement.setString(3, usuario.getNome());
		statement.setString(4, usuario.getEmail());
	
		statement.executeUpdate();
		
		conexao.commit();
		
		return this.consultarUsuarioporLogin(usuario.getLogin());
	
		}// fim EditarUsuario
	
	
	
	// Método para consultar um usuário a partir de um determinado login
	public ModelLogin consultarUsuarioporLogin(String login) throws SQLException {
		
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
		
	}//consultarUsuarioporLogin
	
	//Método para deletar um usuário
	public void deletarUsuario(String idUser) throws SQLException {
		
		
		String sql = "DELETE FROM public.usuario WHERE id = ?; " ;
		
		PreparedStatement statement = conexao.prepareStatement(sql);
		
		statement.setLong(1, Long.parseLong( idUser));
		
		statement.executeUpdate();
		
		conexao.commit();
		
	}// deletarUsuario
	
	
	
	//Método para validar se um login existe
	public boolean validarLoginExistente(String login) throws SQLException {
		
		//existe é um resultado booleano.
		String sql = "SELECT COUNT(1)>0 AS existe FROM public.usuario WHERE UPPER(LOGIN) = UPPER('"+login+"');";
		
		PreparedStatement statement = conexao.prepareStatement(sql);
		
		ResultSet resultado = statement.executeQuery();
		
		 resultado.next() ;
			 return resultado.getBoolean("existe");
	}//fim validarLoginExistente
	
	
	
}// fim da classe

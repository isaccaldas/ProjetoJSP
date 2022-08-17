package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnectionBD {

	//padrão singleton
	
	private static String url = "jdbc:postgresql://localhost:5432/bdJSP?autoReconnect=true";
	private static String user = "postgres";
	private static String senha = "admin";
	public static Connection conexao = null;
	
	static {
		conectar();
	}
	
	public SingleConnectionBD() {
		conectar();
	}
	
    //retorna a conexao com o banco
	public static Connection getConexao() {
		return conexao;
	}
	
	public static void conectar() {
		
		try {
			
			if(conexao == null) {
				Class.forName("org.postgresql.Driver"); //Carrega o driver de conexao com o banco
				conexao = DriverManager.getConnection(url,user,senha);
				conexao.setAutoCommit(false); //Não realiza alteraçoes no banco se o nosso comando
			}
		
		} catch (Exception e) {
			e.printStackTrace(); // Exibe erros no momento de conectar
	}
	}
}

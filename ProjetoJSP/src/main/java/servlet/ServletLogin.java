package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ModelLogin;

/**
 * Servlet implementation class ServletLogin
 * As Servlets são os controllers ex: ServletLoginController
 */
@WebServlet("/ServletLogin") // Mapeamento de url que vem da tela
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletLogin() {
        super();
    }

    //Recebe os dados pela url em parâmetros
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

    //Recebe os dados enviados por um formulário
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Recupera os parâmetros nome e idade recuperados da tela
		//System.out.println(request.getParameter("_login"));
		//System.out.println(request.getParameter("_senha"));
		
		String login = request.getParameter("_login");
		String senha = request.getParameter("_senha");
		
		//verifica se o login e senha possuem valores
		if(login != null && !login.isEmpty() && senha != null && !senha.isEmpty() ) {
			
			//Passando os parâmetros para o objeto
			ModelLogin mLogin = new ModelLogin();
			mLogin.setLogin(login);
			mLogin.setSenha(senha);	
		
		}else {
			//redireciona para a página de index
			RequestDispatcher redirecionar = request.getRequestDispatcher("index.jsp"); 
			//Informa uma mensagem ao usuário
			request.setAttribute("msg","Informe o login e a senha corretamente!." );
			redirecionar.forward(request, response);
		}
		
		
			}

}

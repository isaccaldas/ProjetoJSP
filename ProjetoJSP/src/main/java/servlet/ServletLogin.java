package servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
		
	}

}

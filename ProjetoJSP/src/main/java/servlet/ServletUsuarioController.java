package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ModelLogin;


@WebServlet("/ServletUsuarioController")
public class ServletUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public ServletUsuarioController() {
     
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//recupera as informações da página
		String id = request.getParameter("id");
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		//Instancio o objeto para fazer a injeção dos dados
		ModelLogin usuario = new ModelLogin();
		
		//Injeta os dados da tela no objeto
		usuario.setId(id);
		usuario.setNome(nome);;
		usuario.setEmail(email);
		usuario.setLogin(login);
		usuario.setSenha(senha);
		
		request.setAttribute("Usuario", usuario);
		
		request.getRequestDispatcher("principal/usuario.jsp").forward(request, response);
		
	
		
		
	
	}

}

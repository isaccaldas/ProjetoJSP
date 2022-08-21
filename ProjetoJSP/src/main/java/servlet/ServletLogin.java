package servlet;

import java.io.IOException;
import java.sql.SQLException;

import dao.DAOLoginRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ModelLogin;

/**
 * Servlet implementation class ServletLogin As Servlets são os controllers ex:
 * ServletLoginController
 */
@WebServlet(urlPatterns = { "/principal/ServletLogin", "/ServletLogin" }) // Mapeamento de url que vem da tela
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DAOLoginRepository daoLoginRepository = new DAOLoginRepository();

	public ServletLogin() {
		super();
	}

	// Recebe os dados pela url em parâmetros
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		
		if (acao != null  &&  !acao.isEmpty() && acao.equalsIgnoreCase("logout")) {
			
			request.getSession().invalidate(); //Invalida a sessao para realizar o logout
			RequestDispatcher r = request.getRequestDispatcher("index.jsp");
			r.forward(request, response);
		}
		else if (acao != null  &&  !acao.isEmpty() && acao.equalsIgnoreCase("usuario")) {
				
				RequestDispatcher rUser = request.getRequestDispatcher("principal/usuario.jsp");
				rUser.forward(request, response);
			
		}else {
			doPost(request,response);
		}
		
		
		
		
	}

	// Recebe os dados enviados por um formulário
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			// Recupera os parâmetros nome e idade recuperados da tela
			// System.out.println(request.getParameter("_login"));
			// System.out.println(request.getParameter("_senha"));

			String login = request.getParameter("_login");
			String senha = request.getParameter("_senha");
			String url = request.getParameter("url");

			// verifica se o login e senha possuem valores
			if (login != null && !login.isEmpty() && senha != null && !senha.isEmpty()) {

				// Passando os parâmetros para o objeto
				ModelLogin mLogin = new ModelLogin();
				mLogin.setLogin(login);
				mLogin.setSenha(senha);

				try {
					if (daoLoginRepository.validarLogin(mLogin)) {
						request.getSession().setAttribute("usuario", mLogin.getLogin());

						if (url == null || url.equals("null")) {
							url = "principal/principal.jsp";
						}
						RequestDispatcher r = request.getRequestDispatcher(url);
						r.forward(request, response);

					} else {
						// redireciona para a página de index
						RequestDispatcher redirecionar = request.getRequestDispatcher("index.jsp");
						// Informa uma mensagem ao usuário
						request.setAttribute("msg", "Informe o login e a senha corretamente!.");
						redirecionar.forward(request, response);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} // fim if

			else {
				// redireciona para a página de index
				RequestDispatcher redirecionar = request.getRequestDispatcher("index.jsp");
				// Informa uma mensagem ao usuário
				request.setAttribute("msg", "Informe o login e a senha corretamente!.");
				redirecionar.forward(request, response);
			}

		} catch (Exception e) {
			// redireciona para a página de index
			RequestDispatcher redirecionar = request.getRequestDispatcher("erro.jsp");
			// Informa uma mensagem ao usuário
			request.setAttribute("msg", e.getMessage());
			redirecionar.forward(request, response);
			e.printStackTrace();
		}

	}// fim doPost

}

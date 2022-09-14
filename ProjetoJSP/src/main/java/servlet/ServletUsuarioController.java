package servlet;

import java.io.IOException;
import java.sql.SQLException;

import dao.DAOUsuarioRepository;
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

	private DAOUsuarioRepository daoUsuarioRepository = new DAOUsuarioRepository();

	public ServletUsuarioController() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String acao = request.getParameter("acao");

			if (acao != null && !acao.isEmpty() && acao.equalsIgnoreCase("deletar")) {

				String idUser = request.getParameter("id");

				daoUsuarioRepository.deletarUsuario(idUser);
				
				request.setAttribute("msg", "Excluído com Sucesso!");

			}

			request.getRequestDispatcher("principal/usuario.jsp").forward(request, response);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			RequestDispatcher rd = request.getRequestDispatcher("erro.jsp");
			request.setAttribute("msg", e.getMessage());
			rd.forward(request, response);

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String mensagem = "operação realizada com sucesso!";

		// recupera as informações da página
		String id = request.getParameter("id");
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");

		// Instancio o objeto para fazer a injeção dos dados
		ModelLogin usuario = new ModelLogin();

		// Injeta os dados da tela no objeto
		usuario.setId(id);
		usuario.setNome(nome);
		;
		usuario.setEmail(email);
		usuario.setLogin(login);
		usuario.setSenha(senha);

		try {

			if (daoUsuarioRepository.validarLoginExistente(usuario.getLogin()) && usuario.getId() == null) {

				mensagem = "Já existe usuário cadastrado com esse login. Por favor informe outro.";
			} else {
				usuario = daoUsuarioRepository.incluirUsuario(usuario);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("msg", mensagem);
		request.setAttribute("Usuario", usuario);

		request.getRequestDispatcher("principal/usuario.jsp").forward(request, response);

	}

}

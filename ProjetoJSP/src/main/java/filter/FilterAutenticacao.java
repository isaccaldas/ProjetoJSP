package filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

/**
 * Filtra toda requisiçao e resposta da aplicação
 */
@WebFilter(urlPatterns = {"/principal/*"}) //Intercepta todas as requisições que vierem do projeto ou mapeamento.
public class FilterAutenticacao implements Filter {

   
    public FilterAutenticacao() {
    
    }

    //Encerra os processos quando o servido é parado
  //Ex. encerra a conexao com o BD.
    public void destroy() {

	}

   //Intercepta as requisições e das respostas no sistema.
    //tudo que fizer no sistema passa por aqui.
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		
		String usuarioLogado = (String) session.getAttribute("usuario");
		
		String urlAunteticar = req.getServletPath(); //url que está sendo acessada
		
		//validar se está logado senão redireciona para a tela de login
		//se o usuario estiver tentando acessar qualquer tela do sistema e não estiver logado
		if (usuarioLogado == null && !urlAunteticar.equalsIgnoreCase("/principal/ServletLogin")) {
			
			RequestDispatcher r = request.getRequestDispatcher("/index.jsp?url=" + urlAunteticar ); 
			request.setAttribute("msg", "Por favor, realizer o login");
			r.forward(request, response);
			return; // para a execução e redireciona para o login
		}
		
		else { // executa o processo normal do sistema
			// pass the request along the filter chain
			chain.doFilter(request, response);
		}
		
	}

   // executado quando inicia o sistema. Inicia os processos por recursos quando o servidor sobe o projeto.
	//Ex. inicia a conexao com o BD.
	public void init(FilterConfig fConfig) throws ServletException {

	}

}

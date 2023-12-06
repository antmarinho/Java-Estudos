package filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import connection.SingleConnection;

//intercepta todas as requisicoes que vierem do projeto ou mapeamento
@WebFilter(urlPatterns = {"/principal/*"})
public class FilterAutenticacao extends HttpFilter implements Filter {
       
	private static final long serialVersionUID = 1L;

	private static Connection con;

	public FilterAutenticacao() {
        
    }

	//encerra os processos quando o servidor e parado
	public void destroy() {
		
		try {
			
			con.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	//intercepta todas requisicoes e as respostas no sistema
	//tudo q fizer no sistem vai passar por aqui
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		try {	
				HttpServletRequest req = (HttpServletRequest) request;
				HttpSession session = req.getSession();
				
				String usuarioLogado = (String) session.getAttribute("usuario");
				
				String urlParaAutenticar = req.getServletPath(); //url q esta sendo acessada
				
				// validar se esta logado se nao redirecioan apra tela de login
				//nao esta logado
				if(usuarioLogado == null  && !urlParaAutenticar.equalsIgnoreCase("/principal/ServletLogin")) {
					
					RequestDispatcher redireciona = request.getRequestDispatcher("/index.jsp?url=" + urlParaAutenticar);
					request.setAttribute("msg", "Por favor realize o login");
					redireciona.forward(request, response);
					
					return; // para a execucao e redireciona para o login
				}else {
					chain.doFilter(request, response);
				}
				
				con.commit();
		}
		catch (Exception e) {
			
			e.printStackTrace();
			
			RequestDispatcher redirecionar = request.getRequestDispatcher("/erro.jsp");
			request.setAttribute("msgErro", e.getMessage());
			redirecionar.forward(request, response);
			
			try {
				
				con.rollback();
				
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			
		}
		
	}

	//inicia os processo ou recursos quando o servidor sobre o projeto
	public void init(FilterConfig fConfig) throws ServletException {
		
		con = SingleConnection.getConnection();
	}

}

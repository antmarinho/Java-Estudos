package servlets;

import java.io.IOException;

import dao.DAOLoginRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ModelLogin;

//controller sao as servlets ou ServletLoginController
@WebServlet(urlPatterns = {"/principal/ServletLogin"})
public class ServletLogin extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	private DAOLoginRepository dao = new DAOLoginRepository();

    public ServletLogin() {
       
    }

	//recebe os dados pela url em parametros
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	//recebe os dados enviado por um formulario
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String url = request.getParameter("url");
		
		try {
		
				if(login != null && !login.isEmpty() && senha != null && !senha.isEmpty()) {
					
					ModelLogin ml = new ModelLogin();
					ml.setLogin(login);
					ml.setSenha(senha);
					
					//simulador login
					if(dao.validarAutenticacao(ml)) {
						
						request.getSession().setAttribute("usuario", ml.getLogin());
						
						if(url == null || url.equals("null")) {
							url = "principal/principal.jsp";
						}
						
						RequestDispatcher redirecionar = request.getRequestDispatcher(url);
						redirecionar.forward(request, response);
						
					}
					else {
						
						RequestDispatcher redirecionar = request.getRequestDispatcher("/index.jsp");
						request.setAttribute("msg", "Informe o login e senha corretamente");
						redirecionar.forward(request, response);
					}
					
				}
				else {
					
					RequestDispatcher redirecionar = request.getRequestDispatcher("/index.jsp");
					request.setAttribute("msg", "Informe o login e senha corretamente");
					redirecionar.forward(request, response);
				}
				
		}catch (Exception e) {

			e.printStackTrace();
			RequestDispatcher redirecionar = request.getRequestDispatcher("/erro.jsp");
			request.setAttribute("msgErro", e.getMessage());
			redirecionar.forward(request, response);
		}
		
	}

}

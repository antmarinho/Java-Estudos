package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Users;

import java.io.IOException;

import dao.DAOUsuarioRepository;


public class ServletUsuarioController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private DAOUsuarioRepository dao = new DAOUsuarioRepository();
       
 
    public ServletUsuarioController() {
        
    }


    //consultar e deletar usar o get
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
		
				String acao = request.getParameter("acao");
				
				if(acao != null && !acao.isEmpty() && acao.equalsIgnoreCase("deletar")) {
					
					String idUser = request.getParameter("id");
					
					dao.deletarUser(idUser);
					
					request.setAttribute("msg", "Excluido com sucesso");
					
					request.getRequestDispatcher("/principal/usuario.jsp").forward(request, response);
				
				} 
				else if(acao != null && !acao.isEmpty() && acao.equalsIgnoreCase("deletarAjax")) {
						
						String idUser = request.getParameter("id");
						
						dao.deletarUser(idUser);
						
						response.getWriter().write("excluido com sucesso");
					
				} 
				else if(acao != null && !acao.isEmpty() && acao.equalsIgnoreCase("buscarUserAjax")) {
					
					String nomeBusca = request.getParameter("nomeBusca");
					System.out.println(nomeBusca);
					//dao.deletarUser(idUser);
					
					//response.getWriter().write("excluido com sucesso");
				
				} 
				else {
					
					request.getRequestDispatcher("/principal/usuario.jsp").forward(request, response);
				}
				
				
		} catch (Exception e) {

			e.printStackTrace();
			RequestDispatcher redirecionar = request.getRequestDispatcher("/erro.jsp");
			request.setAttribute("msgErro", e.getMessage());
			redirecionar.forward(request, response);
		}
	}

	//atualizar e salvar
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
				String msg = "Operacao realizada com sucesso";
		
				String id = request.getParameter("id");
				String nome = request.getParameter("nome");
				String login = request.getParameter("login");
				String email = request.getParameter("email");
				String senha = request.getParameter("senha");
				
				Users ml = new Users();
				
				ml.setId((id != null && !id.isEmpty()) ? Long.parseLong(id) : null);
				ml.setNome(nome);
				ml.setEmail(email);
				ml.setSenha(senha);
				ml.setLogin(login);
				
				if(dao.validarLogin(ml.getLogin()) && ml.getId() == null) {
					
					msg = "Ja existe usuario com msm login, informe outro login";
					
				} else {
					
					if(ml.isNovo())
						msg = "Gravado com sucesso";
					else
						msg = "Atualizado com sucesso";
					
					ml = dao.gravarUsuario(ml);
				
				}
	
				request.setAttribute("msg",msg);
				request.setAttribute("ml", ml);
				
				request.getRequestDispatcher("/principal/usuario.jsp").forward(request, response);
				
		} catch (Exception e) {
			
			e.printStackTrace();
			RequestDispatcher redirecionar = request.getRequestDispatcher("/erro.jsp");
			request.setAttribute("msgErro", e.getMessage());
			redirecionar.forward(request, response);
		}
		
	}

}

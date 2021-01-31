package servlets;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoLogin;
import model.ModelUsuarios;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DaoLogin daoLogin = new DaoLogin();

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			ModelUsuarios modelUsuarios = new ModelUsuarios();

			String login = request.getParameter("login");
			String senha = request.getParameter("senha");
			
			String cadastrologin = request.getParameter("cadastrologin");
			String cadastrosenha = request.getParameter("cadastrosenha");
			String cadastronome = request.getParameter("cadastronome");

			if (daoLogin.validarLogin(login, senha)) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("principal.jsp");
				dispatcher.forward(request, response);
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request, response);
			}
			
			modelUsuarios.setLogin(cadastrologin);
			modelUsuarios.setSenha(cadastrosenha);
			modelUsuarios.setNome(cadastronome);
			
			if(cadastrologin != null && cadastrosenha != null && cadastronome != null) {
				daoLogin.salvar(modelUsuarios);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

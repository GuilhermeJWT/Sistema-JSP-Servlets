package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoClientes;
import dao.DaoTelefonesClientes;
import model.ModelClientes;
import model.ModelTelefonesClientes;

@WebServlet("/telefonesClientesServlet")
public class TelefonesClientesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DaoClientes daoClientes = new DaoClientes();
	private DaoTelefonesClientes daoTelefonesClientes = new DaoTelefonesClientes();

	public TelefonesClientesServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		String acao = request.getParameter("acao");
		String cli = request.getParameter("cli");

		if (acao != null) {

			try {

				if (acao.equalsIgnoreCase("addFone")) {
					ModelClientes modelClientes = daoClientes.consultar(cli);

					request.getSession().setAttribute("clienteEscolhido", modelClientes);
					request.setAttribute("clienteEscolhido", modelClientes);

					RequestDispatcher view = request.getRequestDispatcher("/cadastroTelefonesClientes.jsp");
					request.setAttribute("telefones",
							daoTelefonesClientes.listarTelefonesClientes(modelClientes.getId()));
					view.forward(request, response);

				} else if (acao.equalsIgnoreCase("deleteFone")) {
					String foneId = request.getParameter("foneId");
					daoTelefonesClientes.deleteTelefonesClientes(Long.parseLong(foneId));
					ModelClientes modelClientes = (ModelClientes) request.getSession().getAttribute("clienteEscolhido");
					RequestDispatcher view = request.getRequestDispatcher("/cadastroTelefonesClientes.jsp");
					request.setAttribute("telefones",
							daoTelefonesClientes.listarTelefonesClientes(modelClientes.getId()));
					request.setAttribute("msg", "Removido com Sucesso!");
					view.forward(request, response);
				}
			}

			catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			
			try {
			
			ModelClientes modelClientes = (ModelClientes) request.getSession().getAttribute("clienteEscolhido");
			RequestDispatcher view = request.getRequestDispatcher("/cadastroTelefonesClientes.jsp");
			request.setAttribute("telefones", daoTelefonesClientes.listarTelefonesClientes(modelClientes.getId()));
			view.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// doGet(request, response);

		try {

			ModelClientes modelClientes = (ModelClientes) request.getSession().getAttribute("clienteEscolhido");

			String numero = request.getParameter("numero");
			String tipo = request.getParameter("tipo");

			String acao = request.getParameter("acao");

			if (acao == null || (acao != null && !acao.equalsIgnoreCase("voltar"))) {

				if (numero == null || (numero != null && numero.isEmpty())) {
					RequestDispatcher view = request.getRequestDispatcher("/cadastroTelefonesClientes.jsp");
					request.setAttribute("telefones",
							daoTelefonesClientes.listarTelefonesClientes(modelClientes.getId()));
					request.setAttribute("msg", "Informe o Número!");
					view.forward(request, response);
				}

				else {

					ModelTelefonesClientes modelTelefonesClientes = new ModelTelefonesClientes();
					modelTelefonesClientes.setNumero(numero);
					modelTelefonesClientes.setTipo(tipo);
					modelTelefonesClientes.setClientes(modelClientes.getId());

					daoTelefonesClientes.salvarTelefonesClientes(modelTelefonesClientes);

					request.getSession().setAttribute("clienteEscolhido", modelClientes);
					request.setAttribute("clienteEscolhido", modelClientes);

					RequestDispatcher view = request.getRequestDispatcher("/cadastroTelefonesClientes.jsp");
					request.setAttribute("telefones",
							daoTelefonesClientes.listarTelefonesClientes(modelClientes.getId()));
					request.setAttribute("msgboa", "Cadastrado com Sucesso!");
					view.forward(request, response);

				}

			} else {
				RequestDispatcher view = request.getRequestDispatcher("/cadastroClientes.jsp");
				request.setAttribute("clientes", daoClientes.listaClientes());
				view.forward(request, response);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFornecedores;
import dao.DaoTelefonesFornecedores;
import model.ModelFornecedores;
import model.ModelTelefonesFornecedores;

@WebServlet("/telefonesFornecedoresServlet")
public class TelefonesFornecedoresServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DaoFornecedores daoFornecedores = new DaoFornecedores();
	private DaoTelefonesFornecedores daoTelefonesFornecedores = new DaoTelefonesFornecedores();

	public TelefonesFornecedoresServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		String acao = request.getParameter("acao");
		String forn = request.getParameter("forn");
		
		

		if (acao != null) {

			try {

				if (acao.equalsIgnoreCase("addFone")) {
					ModelFornecedores modelFornecedores = daoFornecedores.consultar(forn);

					request.getSession().setAttribute("fornecedorEscolhido", modelFornecedores);
					request.setAttribute("fornecedorEscolhido", modelFornecedores);

					RequestDispatcher view = request.getRequestDispatcher("/cadastroTelefonesFornecedores.jsp");
					request.setAttribute("telefones",
							daoTelefonesFornecedores.listarTelefonesFornecedores(modelFornecedores.getId()));
					view.forward(request, response);

				} else if (acao.equalsIgnoreCase("deleteFone")) {
					String foneId = request.getParameter("foneId");
					daoTelefonesFornecedores.deleteTelefonesFornecedores(Long.parseLong(foneId));
					ModelFornecedores modelFornecedores = (ModelFornecedores) request.getSession().getAttribute("fornecedorEscolhido");
					RequestDispatcher view = request.getRequestDispatcher("/cadastroTelefonesFornecedores.jsp");
					request.setAttribute("telefones",
							daoTelefonesFornecedores.listarTelefonesFornecedores(modelFornecedores.getId()));
					request.setAttribute("msg", "Removido com Sucesso!");
					view.forward(request, response);
				}
			}

			catch (Exception e) {
				e.printStackTrace();
			}
		} else {
		
			try {
				RequestDispatcher view = request.getRequestDispatcher("/cadastroFornecedores.jsp");
				request.setAttribute("fornecedores", daoFornecedores.listaFornecedores());
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

			ModelFornecedores modelFornecedores = (ModelFornecedores) request.getSession().getAttribute("fornecedorEscolhido");

			String id = request.getParameter("id");
			String numero = request.getParameter("numero");
			String tipo = request.getParameter("tipo");

			String acao = request.getParameter("acao");

			if (acao == null || (acao != null && !acao.equalsIgnoreCase("voltar"))) {

				if (numero == null || (numero != null && numero.isEmpty())) {
					RequestDispatcher view = request.getRequestDispatcher("/cadastroTelefonesFornecedores.jsp");
					request.setAttribute("telefones",
							daoTelefonesFornecedores.listarTelefonesFornecedores(modelFornecedores.getId()));
					request.setAttribute("msg", "Informe o Número!");
					view.forward(request, response);
				}

				else {

					ModelTelefonesFornecedores modelTelefonesFornecedores = new ModelTelefonesFornecedores();
					modelTelefonesFornecedores.setId(!id.isEmpty() ? Long.parseLong(id) : null);
					modelTelefonesFornecedores.setNumero(numero);
					modelTelefonesFornecedores.setTipo(tipo);
					modelTelefonesFornecedores.setFornecedores(modelFornecedores.getId());

					daoTelefonesFornecedores.salvarTelefonesFornecedores(modelTelefonesFornecedores);

					request.getSession().setAttribute("fornecedorEscolhido", modelFornecedores);
					request.setAttribute("fornecedorEscolhido", modelFornecedores);

					RequestDispatcher view = request.getRequestDispatcher("/cadastroTelefonesFornecedores.jsp");
					request.setAttribute("telefones",
							daoTelefonesFornecedores.listarTelefonesFornecedores(modelFornecedores.getId()));
					request.setAttribute("msgboa", "Cadastrado com Sucesso!");
					view.forward(request, response);

				}

			} else {
				RequestDispatcher view = request.getRequestDispatcher("/cadastroFornecedores.jsp");
				request.setAttribute("fornecedores", daoFornecedores.listaFornecedores());
				view.forward(request, response);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

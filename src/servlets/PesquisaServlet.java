package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoClientes;
import dao.DaoFornecedores;
import model.ModelClientes;
import model.ModelFornecedores;

@WebServlet("/pesquisaServlet")
public class PesquisaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DaoClientes daoClientes = new DaoClientes();
	private DaoFornecedores daoFornecedores = new DaoFornecedores();
       
    public PesquisaServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		
		String pesquisaClientes = request.getParameter("pesquisacliente");
		String pesquisaFornecedores = request.getParameter("pesquisaFornecedores");
		
		if(pesquisaClientes != null) {
			try {
				List<ModelClientes> listaClientesPorNome = daoClientes.consultarPorNome(pesquisaClientes);
				RequestDispatcher view = request.getRequestDispatcher("/cadastroClientes.jsp");
				request.setAttribute("clientes", listaClientesPorNome);
				view.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (pesquisaFornecedores != null) {
			try {
				List<ModelFornecedores> listaFornecedoresPorNome = daoFornecedores.consultarPorNome(pesquisaFornecedores);
				RequestDispatcher view = request.getRequestDispatcher("/cadastroFornecedores.jsp");
				request.setAttribute("fornecedores", listaFornecedoresPorNome);
				view.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}

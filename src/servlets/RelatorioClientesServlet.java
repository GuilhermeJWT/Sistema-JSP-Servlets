package servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoClientes;
import model.ModelClientes;
import service.RelatorioService;

@WebServlet("/relatorioClientesServlet")
public class RelatorioClientesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private RelatorioService relatorioService = new RelatorioService();
	private DaoClientes daoClientes = new DaoClientes();
	private ModelClientes modelClientes = new ModelClientes();

	public RelatorioClientesServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		try {
			
		ServletContext context = request.getServletContext();
			
		String tipo = request.getParameter("tipo");
		
		List<ModelClientes> modelClientes = daoClientes.listaClientesRelatorio();
		List dados = new ArrayList();
		dados.add(modelClientes);
		
		String fileUrl = relatorioService.gerarRelatorio(dados, new HashMap(), "relatorioClientes", "relatorioClientes", context);
		File downloadFile = new File(fileUrl);
		FileInputStream inputStream = new FileInputStream(downloadFile);
		String mimeType = context.getMimeType(fileUrl);
		
		if(mimeType == null) {
			
		}
		
		}catch (Exception e ) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

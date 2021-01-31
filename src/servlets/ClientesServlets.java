package servlets;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.buf.UDecoder;
import org.apache.tomcat.util.codec.binary.Base64;

import dao.DaoClientes;
import model.ModelClientes;

@WebServlet("/clientesServlet")
@MultipartConfig
public class ClientesServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DaoClientes daoClientes = new DaoClientes();

	public ClientesServlets() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		String acao = request.getParameter("acao");
		String cli = request.getParameter("cli");
		
		if (acao != null) {
		
		try {

			if (acao != null && acao.equalsIgnoreCase("delete")) {
				daoClientes.delete(Long.parseLong(cli));
				RequestDispatcher view = request.getRequestDispatcher("/cadastroClientes.jsp");
				request.setAttribute("clientes", daoClientes.listaClientes());
				request.setAttribute("msg", "Removido com Sucesso!");
				view.forward(request, response);
			} else if (acao != null && acao.equalsIgnoreCase("editar")) {
				ModelClientes modelClientes = daoClientes.consultar(cli);
				RequestDispatcher view = request.getRequestDispatcher("/cadastroClientes.jsp");
				request.setAttribute("cli", modelClientes);
				view.forward(request, response);
			} else if (acao != null && acao.equalsIgnoreCase("listartodos")) {
				RequestDispatcher view = request.getRequestDispatcher("/cadastroClientes.jsp");
				request.setAttribute("clientes", daoClientes.listaClientes());
				view.forward(request, response);
			} else if (acao.equalsIgnoreCase("download")) {
				ModelClientes modelClientes = daoClientes.consultar(cli);
				if (modelClientes != null) {
					
					String tipo = request.getParameter("tipo");
					byte[] fileBytes = null;
					String contentType = "";
					
					if (tipo.equalsIgnoreCase("imagem")) {
						contentType = modelClientes.getContentType();
						fileBytes = new Base64().decodeBase64(modelClientes.getFotoBase64());
					}
					
					response.setHeader("Content-Disposition",
							"attachment;filename=arquivo." + contentType.split("\\/")[1]);

					/* Coloca os bytes em um objeto de entrada para processar */
					InputStream is = new ByteArrayInputStream(fileBytes);
					int read = 0;
					byte[] bytes = new byte[1024];

					OutputStream os = response.getOutputStream();
					while ((read = is.read(bytes)) != -1) {
						os.write(bytes, 0, read);
					}
					os.flush();
					os.close();

				}
			}

			else {
				RequestDispatcher view = request.getRequestDispatcher("/cadastroClientes.jsp");
				request.setAttribute("clientes", daoClientes.listaClientes());
				view.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		}else {
			RequestDispatcher view = request.getRequestDispatcher("/cadastroClientes.jsp");
			try {
				request.setAttribute("clientes", daoClientes.listaClientes());
			} catch (Exception e) {
				e.printStackTrace();
			}
			view.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getParameter("acao");

		if (acao != null && acao.equalsIgnoreCase("reset")) {
			try {
				RequestDispatcher view = request.getRequestDispatcher("/cadastroClientes.jsp");
				request.setAttribute("clientes", daoClientes.listaClientes());
				view.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {

			String id = request.getParameter("id");
			String nome = request.getParameter("nome");
			String email = request.getParameter("email");
			String rg = request.getParameter("rg");
			String cpf = request.getParameter("cpf");
			String cep = request.getParameter("cep");
			String rua = request.getParameter("rua");
			String bairro = request.getParameter("bairro");
			String cidade = request.getParameter("cidade");
			String estado = request.getParameter("estado");
			String ibge = request.getParameter("ibge");

			ModelClientes modelClientes = new ModelClientes();
			modelClientes.setId(!id.isEmpty() ? Long.parseLong(id) : null);
			modelClientes.setNome(nome);
			modelClientes.setEmail(email);
			modelClientes.setRg(rg);
			modelClientes.setCpf(cpf);
			modelClientes.setCep(cep);
			modelClientes.setRua(rua);
			modelClientes.setBairro(bairro);
			modelClientes.setCidade(cidade);
			modelClientes.setEstado(estado);
			modelClientes.setIbge(ibge);

			try {

				boolean podeInserir = true;

				if (nome == null || nome.isEmpty()) {
					request.setAttribute("msg", "Nome deve ser Informado!");
					podeInserir = false;
				} else if (email == null || email.isEmpty()) {
					request.setAttribute("msg", "E-mail deve ser Informado!");
					podeInserir = false;
				} else if (rg == null || rg.isEmpty()) {
					request.setAttribute("msg", "Rg deve ser Informado!");
					podeInserir = false;
				} else if (cpf == null || cpf.isEmpty()) {
					request.setAttribute("msg", "Cpf deve ser Informado!");
					podeInserir = false;
				} else if (cep == null || cep.isEmpty()) {
					request.setAttribute("msg", "Cep deve ser Informado!");
					podeInserir = false;
				}

				/* FILE */
				if (ServletFileUpload.isMultipartContent(request)) {

					Part imagemFoto = request.getPart("foto");

					if (imagemFoto != null && imagemFoto.getInputStream().available() > 0) {
						String fotoBase64 = new Base64()
								.encodeBase64String(converteStremParabyte(imagemFoto.getInputStream()));
						modelClientes.setFotoBase64(fotoBase64);
						modelClientes.setContentType(imagemFoto.getContentType());
						
						
					}else {
						modelClientes.setFotoBase64(request.getParameter("fotoTemp"));
						modelClientes.setContentType(request.getParameter("contentTypeTemp"));
					}

				}
				/* FILE */

				if (id == null || id.isEmpty() && !daoClientes.validarCpf(cpf)) {
					request.setAttribute("msg", "Cliente já cadastrado com o mesmo Cpf!");
					podeInserir = false;
				}

				if (id == null || id.isEmpty() && daoClientes.validarCpf(cpf) && podeInserir) {
					daoClientes.salvarClientes(modelClientes);
					request.setAttribute("msgboa", "Cadastrado com Sucesso!");
				} else if (id != null && !id.isEmpty() && podeInserir) {
					if (!daoClientes.validarCpfUpdate(cpf, id)) {
						request.setAttribute("msg", "Cliente já cadastrado com o mesmo Cpf!");
						request.setAttribute("cli", modelClientes);
					} else if (id != null && !id.isEmpty() && podeInserir) {
						daoClientes.atualizar(modelClientes);
						request.setAttribute("msgboa", "Atualizado com Sucesso");
					}
				}

				if (!podeInserir) {
					request.setAttribute("cli", modelClientes);
				}

				RequestDispatcher view = request.getRequestDispatcher("/cadastroClientes.jsp");
				request.setAttribute("clientes", daoClientes.listaClientes());
				view.forward(request, response);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	private byte[] converteStremParabyte(InputStream imagem) throws Exception {

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int reads = imagem.read();

		while (reads != -1) {
			baos.write(reads);
			reads = imagem.read();
		}

		return baos.toByteArray();

	}

}

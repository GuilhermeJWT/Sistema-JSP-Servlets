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

import dao.DaoFornecedores;
import model.ModelFornecedores;

@WebServlet("/fornecedoresServlet")
@MultipartConfig
public class FornecedoresServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DaoFornecedores daoFornecedores = new DaoFornecedores();

	public FornecedoresServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		String acao = request.getParameter("acao");
		String forn = request.getParameter("forn");
		
		if (acao != null) {
		
		try {

			if (acao != null && acao.equalsIgnoreCase("delete")) {
				daoFornecedores.delete(Long.parseLong(forn));
				RequestDispatcher view = request.getRequestDispatcher("/cadastroFornecedores.jsp");
				request.setAttribute("fornecedores", daoFornecedores.listaFornecedores());
				request.setAttribute("msg", "Removido com Sucesso!");
				view.forward(request, response);
			} else if (acao != null && acao.equalsIgnoreCase("editar")) {
				ModelFornecedores modelFornecedores = daoFornecedores.consultar(forn);
				RequestDispatcher view = request.getRequestDispatcher("/cadastroFornecedores.jsp");
				request.setAttribute("forn", modelFornecedores);
				view.forward(request, response);
			} else if (acao != null && acao.equalsIgnoreCase("listartodos")) {
				RequestDispatcher view = request.getRequestDispatcher("/cadastroFornecedores.jsp");
				request.setAttribute("fornecedores", daoFornecedores.listaFornecedores());
				view.forward(request, response);
			} else if (acao.equalsIgnoreCase("download")) {
				ModelFornecedores modelFornecedores = daoFornecedores.consultar(forn);
				if (modelFornecedores != null) {
					
					String tipo = request.getParameter("tipo");
					byte[] fileBytes = null;
					String contentType = "";
					
					if (tipo.equalsIgnoreCase("imagem")) {
						contentType = modelFornecedores.getContentType();
						fileBytes = new Base64().decodeBase64(modelFornecedores.getFotoBase64());
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
				RequestDispatcher view = request.getRequestDispatcher("/cadastroFornecedores.jsp");
				request.setAttribute("fornecedores", daoFornecedores.listaFornecedores());
				view.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		}else {
			RequestDispatcher view = request.getRequestDispatcher("/cadastroFornecedores.jsp");
			try {
				request.setAttribute("fornecedores", daoFornecedores.listaFornecedores());
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
				RequestDispatcher view = request.getRequestDispatcher("/cadastroFornecedores.jsp");
				request.setAttribute("fornecedores", daoFornecedores.listaFornecedores());
				view.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {

			String id = request.getParameter("id");
			String nome = request.getParameter("nome");
			String razaosocial = request.getParameter("razaosocial");
			String cnpj = request.getParameter("cnpj");
			String cep = request.getParameter("cep");
			String rua = request.getParameter("rua");
			String bairro = request.getParameter("bairro");
			String cidade = request.getParameter("cidade");
			String estado = request.getParameter("estado");
			String ibge = request.getParameter("ibge");
			String pessoa = request.getParameter("pessoa");
			String inscricaoestadual = request.getParameter("inscricaoestadual");
			String inscricaomunicipal = request.getParameter("inscricaomunicipal");
			String email = request.getParameter("email");

			ModelFornecedores modelFornecedores = new ModelFornecedores();
			modelFornecedores.setId(!id.isEmpty() ? Long.parseLong(id) : null);
			modelFornecedores.setNome(nome);
			modelFornecedores.setRazaosocial(razaosocial);
			modelFornecedores.setCnpj(cnpj);
			modelFornecedores.setCep(cep);
			modelFornecedores.setRua(rua);
			modelFornecedores.setBairro(bairro);
			modelFornecedores.setCidade(cidade);
			modelFornecedores.setEstado(estado);
			modelFornecedores.setIbge(ibge);
			modelFornecedores.setPessoa(pessoa);
			modelFornecedores.setInscricaoestadual(inscricaoestadual);
			modelFornecedores.setInscricaomunicipal(inscricaomunicipal);
			modelFornecedores.setEmail(email);

			try {

				boolean podeInserir = true;

				if (nome == null || nome.isEmpty()) {
					request.setAttribute("msg", "Nome deve ser Informado!");
					podeInserir = false;
				} else if (cnpj == null || cnpj.isEmpty()) {
					request.setAttribute("msg", "Cnpj deve ser Informado!");
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
						modelFornecedores.setFotoBase64(fotoBase64);
						modelFornecedores.setContentType(imagemFoto.getContentType());
						
						
					}else {
						modelFornecedores.setFotoBase64(request.getParameter("fotoTemp"));
						modelFornecedores.setContentType(request.getParameter("contentTypeTemp"));
					}

				}
				/* FILE */

				if (id == null || id.isEmpty() && !daoFornecedores.validarCnpj(cnpj)) {
					request.setAttribute("msg", "Fornecedor já cadastrado com o mesmo Cnpj!");
					podeInserir = false;
				}

				if (id == null || id.isEmpty() && daoFornecedores.validarCnpj(cnpj) && podeInserir) {
					daoFornecedores.salvarFornecedores(modelFornecedores);
					request.setAttribute("msgboa", "Cadastrado com Sucesso!");
				} else if (id != null && !id.isEmpty() && podeInserir) {
					if (!daoFornecedores.validarCnpjUpdate(cnpj, id)) {
						request.setAttribute("msg", "Fornecedor já cadastrado com o mesmo Cnpj!");
						request.setAttribute("forn", modelFornecedores);
					} else if (id != null && !id.isEmpty() && podeInserir) {
						daoFornecedores.atualizar(modelFornecedores);
						request.setAttribute("msgboa", "Atualizado com Sucesso");
					}
				}

				if (!podeInserir) {
					request.setAttribute("forn", modelFornecedores);
				}

				RequestDispatcher view = request.getRequestDispatcher("/cadastroFornecedores.jsp");
				request.setAttribute("fornecedores", daoFornecedores.listaFornecedores());
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

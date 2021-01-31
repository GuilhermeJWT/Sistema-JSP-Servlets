<%@page import="model.ModelFornecedores"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Cadastro de Fornecedores</title>

<script src="https://code.jquery.com/jquery-3.2.1.min.js"
	integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
	crossorigin="anonymous"></script>
</head>
<body>


	<%@ include file="templateCabecalho.jsp"%>

	<div id="main" class="container-fluid">

		<center>
			<h3 style="color: red;">${msg}</h3>
			<h3 style="color: blue;">${msgboa}</h3>
		</center>
		<form action="fornecedoresServlet" method="post" id="formForn"
			onsubmit="return validarCampos()? true : false"
			enctype="multipart/form-data">
			<div class="row">
				<div class="form-group col-md-2">
					<label for="id">Código:</label> <input type="text"
						class="form-control" id="id" name="id" readonly=""
						value="${forn.id}">
				</div>

				<div class="form-group col-md-5">
					<label for="nome">Nome Fantasia:</label> <input type="text"
						class="form-control" id="nome" name="nome" maxlength="45"
						value="${forn.nome}">
				</div>

				<div class="form-group col-md-5">
					<label for="razaosocial">Razão Social:</label> <input type="text"
						class="form-control" id="razaosocial" name="razaosocial" maxlength="50"
						value="${forn.razaosocial}">
				</div>
				<div class="form-group col-md-3">
					<label for="cnpj">Cnpj:</label> <input type="text" class="form-control"
						id="cnpj" name="cnpj" maxlength="16"  value="${forn.cnpj}">
				</div>
				<div class="form-group col-md-3">
					<label for="cep">Cep:</label> <input type="text"
						class="form-control" id="cep" name="cep" maxlength="9"
						onblur="consultarCep()" value="${forn.cep}">
				</div>
			
				<div class="form-group col-md-3">
					<label for="rua">Rua:</label> <input type="text"
						class="form-control" id="rua" maxlength="60" name="rua"
						value="${forn.rua}">
				</div>
				<div class="form-group col-md-3">
					<label for="bairro">Bairro:</label> <input type="text"
						class="form-control" id="bairro" maxlength="45" name="bairro"
						value="${forn.bairro}">
				</div>
				<div class="form-group col-md-3">
					<label for="cidade">Cidade:</label> <input type="text"
						class="form-control" id="cidade" maxlength="45" name="cidade"
						value="${forn.cidade}">
				</div>
				<div class="form-group col-md-3">
					<label for="estado">Estado:</label>
					<div>
					<select id="estado" name="estado" style="width: 300px; height: 35px;">
						<option value="AC"
						<% 
						if (request.getAttribute("forn") != null){
							
							ModelFornecedores forn = (ModelFornecedores) request.getAttribute("forn");
							if(forn.getEstado().equalsIgnoreCase("AC")){
								out.print(" ");
								out.print("selected=\"selected\"");
								out.print(" ");
							}
							
						}
						%>
						>AC</option>
						<option value="AL" 
							<% 
						if (request.getAttribute("forn") != null){
							
							ModelFornecedores forn = (ModelFornecedores) request.getAttribute("forn");
							if(forn.getEstado().equalsIgnoreCase("AL")){
								out.print(" ");
								out.print("selected=\"selected\"");
								out.print(" ");
							}
							
						}
						%>
						>AL</option>
						<option value="AP" 
							<% 
						if (request.getAttribute("forn") != null){
							
							ModelFornecedores forn = (ModelFornecedores) request.getAttribute("forn");
							if(forn.getEstado().equalsIgnoreCase("AP")){
								out.print(" ");
								out.print("selected=\"selected\"");
								out.print(" ");
							}
							
						}
						%>
						>AP</option>
						<option value="AM" 
							<% 
						if (request.getAttribute("forn") != null){
							
							ModelFornecedores forn = (ModelFornecedores) request.getAttribute("forn");
							if(forn.getEstado().equalsIgnoreCase("AM")){
								out.print(" ");
								out.print("selected=\"selected\"");
								out.print(" ");
							}
							
						}
						%>
						>AM</option>
						<option value="BA" 
							<% 
						if (request.getAttribute("forn") != null){
							
							ModelFornecedores forn = (ModelFornecedores) request.getAttribute("forn");
							if(forn.getEstado().equalsIgnoreCase("BA")){
								out.print(" ");
								out.print("selected=\"selected\"");
								out.print(" ");
							}
							
						}
						%>
						>BA</option>
						<option value="CE" 
							<% 
						if (request.getAttribute("forn") != null){
							
							ModelFornecedores forn = (ModelFornecedores) request.getAttribute("forn");
							if(forn.getEstado().equalsIgnoreCase("CE")){
								out.print(" ");
								out.print("selected=\"selected\"");
								out.print(" ");
							}
							
						}
						%>
						>CE</option>
						<option value="ES" 
							<% 
						if (request.getAttribute("forn") != null){
							
							ModelFornecedores forn = (ModelFornecedores) request.getAttribute("forn");
							if(forn.getEstado().equalsIgnoreCase("ES")){
								out.print(" ");
								out.print("selected=\"selected\"");
								out.print(" ");
							}
							
						}
						%>
						>ES</option>
						<option value="GO" 
							<% 
						if (request.getAttribute("forn") != null){
							
							ModelFornecedores forn = (ModelFornecedores) request.getAttribute("forn");
							if(forn.getEstado().equalsIgnoreCase("GO")){
								out.print(" ");
								out.print("selected=\"selected\"");
								out.print(" ");
							}
							
						}
						%>
						>GO</option>
						<option value="MA" 
							<% 
						if (request.getAttribute("forn") != null){
							
							ModelFornecedores forn = (ModelFornecedores) request.getAttribute("forn");
							if(forn.getEstado().equalsIgnoreCase("MA")){
								out.print(" ");
								out.print("selected=\"selected\"");
								out.print(" ");
							}
							
						}
						%>
						>MA</option>
						<option value="MT"
							<% 
						if (request.getAttribute("forn") != null){
							
							ModelFornecedores forn = (ModelFornecedores) request.getAttribute("forn");
							if(forn.getEstado().equalsIgnoreCase("MT")){
								out.print(" ");
								out.print("selected=\"selected\"");
								out.print(" ");
							}
							
						}
						%>
						>MT</option>
						<option value="MS" 
							<% 
						if (request.getAttribute("forn") != null){
							
							ModelFornecedores forn = (ModelFornecedores) request.getAttribute("forn");
							if(forn.getEstado().equalsIgnoreCase("MS")){
								out.print(" ");
								out.print("selected=\"selected\"");
								out.print(" ");
							}
							
						}
						%>
						>MS</option>
						<option value="MG" 
							<% 
						if (request.getAttribute("forn") != null){
							
							ModelFornecedores forn = (ModelFornecedores) request.getAttribute("forn");
							if(forn.getEstado().equalsIgnoreCase("MG")){
								out.print(" ");
								out.print("selected=\"selected\"");
								out.print(" ");
							}
							
						}
						%>
						>MG</option>
						<option value="PA" 
							<% 
						if (request.getAttribute("forn") != null){
							
							ModelFornecedores forn = (ModelFornecedores) request.getAttribute("forn");
							if(forn.getEstado().equalsIgnoreCase("PA")){
								out.print(" ");
								out.print("selected=\"selected\"");
								out.print(" ");
							}
							
						}
						%>
						>PA</option>
						<option value="PB" 
							<% 
						if (request.getAttribute("forn") != null){
							
							ModelFornecedores forn = (ModelFornecedores) request.getAttribute("forn");
							if(forn.getEstado().equalsIgnoreCase("PB")){
								out.print(" ");
								out.print("selected=\"selected\"");
								out.print(" ");
							}
							
						}
						%>
						>PB</option>
						<option value="PR" 
							<% 
						if (request.getAttribute("forn") != null){
							
							ModelFornecedores forn = (ModelFornecedores) request.getAttribute("forn");
							if(forn.getEstado().equalsIgnoreCase("PR")){
								out.print(" ");
								out.print("selected=\"selected\"");
								out.print(" ");
							}
							
						}
						%>
						>PR</option>
						<option value="PE" 	<% 
						if (request.getAttribute("forn") != null){
							
							ModelFornecedores forn = (ModelFornecedores) request.getAttribute("forn");
							if(forn.getEstado().equalsIgnoreCase("PE")){
								out.print(" ");
								out.print("selected=\"selected\"");
								out.print(" ");
							}
							
						}
						%>>PE</option>
						<option value="PI" 
							<% 
						if (request.getAttribute("forn") != null){
							
							ModelFornecedores forn = (ModelFornecedores) request.getAttribute("forn");
							if(forn.getEstado().equalsIgnoreCase("PI")){
								out.print(" ");
								out.print("selected=\"selected\"");
								out.print(" ");
							}
							
						}
						%>
						>PI</option>
						<option value="RJ" 
							<% 
						if (request.getAttribute("forn") != null){
							
							ModelFornecedores forn = (ModelFornecedores) request.getAttribute("forn");
							if(forn.getEstado().equalsIgnoreCase("RJ")){
								out.print(" ");
								out.print("selected=\"selected\"");
								out.print(" ");
							}
							
						}
						%>
						>RJ</option>
						<option value="RN" 
							<% 
						if (request.getAttribute("forn") != null){
							
							ModelFornecedores forn = (ModelFornecedores) request.getAttribute("forn");
							if(forn.getEstado().equalsIgnoreCase("RN")){
								out.print(" ");
								out.print("selected=\"selected\"");
								out.print(" ");
							}
							
						}
						%>
						>RN</option>
						<option value="RS" 
							<% 
						if (request.getAttribute("forn") != null){
							
							ModelFornecedores forn = (ModelFornecedores) request.getAttribute("forn");
							if(forn.getEstado().equalsIgnoreCase("RS")){
								out.print(" ");
								out.print("selected=\"selected\"");
								out.print(" ");
							}
							
						}
						%>
						>RS</option>
						<option value="RO" 
							<% 
						if (request.getAttribute("forn") != null){
							
							ModelFornecedores forn = (ModelFornecedores) request.getAttribute("forn");
							if(forn.getEstado().equalsIgnoreCase("RO")){
								out.print(" ");
								out.print("selected=\"selected\"");
								out.print(" ");
							}
							
						}
						%>
						>RO</option>
						<option value="RR" 
							<% 
						if (request.getAttribute("forn") != null){
							
							ModelFornecedores forn = (ModelFornecedores) request.getAttribute("forn");
							if(forn.getEstado().equalsIgnoreCase("RR")){
								out.print(" ");
								out.print("selected=\"selected\"");
								out.print(" ");
							}
							
						}
						%>
						>RR</option>
						<option value="SC" 
							<% 
						if (request.getAttribute("forn") != null){
							
							ModelFornecedores forn = (ModelFornecedores) request.getAttribute("forn");
							if(forn.getEstado().equalsIgnoreCase("SC")){
								out.print(" ");
								out.print("selected=\"selected\"");
								out.print(" ");
							}
							
						}
						%>
						>SC</option>
						<option value="SP" 
							<% 
						if (request.getAttribute("forn") != null){
							
							ModelFornecedores forn = (ModelFornecedores) request.getAttribute("forn");
							if(forn.getEstado().equalsIgnoreCase("SP")){
								out.print(" ");
								out.print("selected=\"selected\"");
								out.print(" ");
							}
							
						}
						%>
						>SP</option>
						<option value="SE" 
							<% 
						if (request.getAttribute("forn") != null){
							
							ModelFornecedores forn = (ModelFornecedores) request.getAttribute("forn");
							if(forn.getEstado().equalsIgnoreCase("SE")){
								out.print(" ");
								out.print("selected=\"selected\"");
								out.print(" ");
							}
							
						}
						%>
						>SE</option>
						<option value="TO" 
							<% 
						if (request.getAttribute("forn") != null){
							
							ModelFornecedores forn = (ModelFornecedores) request.getAttribute("forn");
							if(forn.getEstado().equalsIgnoreCase("TO")){
								out.print(" ");
								out.print("selected=\"selected\"");
								out.print(" ");
							}
							
						}
						%>
						>TO</option>
						<option value="DF" 
							<% 
						if (request.getAttribute("forn") != null){
							
							ModelFornecedores forn = (ModelFornecedores) request.getAttribute("forn");
							if(forn.getEstado().equalsIgnoreCase("DF")){
								out.print(" ");
								out.print("selected=\"selected\"");
								out.print(" ");
							}
							
						}
						%>
						>DF</option>
					</select>
					</div>
					</div>
				<div class="form-group col-md-3">
					<label for="ibge">Ibge:</label> <input type="text"
						class="form-control" id="ibge" name="ibge" value="${forn.ibge}">
				</div>
				
					<div class="form-group col-md-3">
					<label for="cep">Tipo Pessoa:</label> <input type="text"
						class="form-control" id="pessoa" name="pessoa" maxlength="15"
						value="${forn.pessoa}" >
				</div>
				
				<div class="form-group col-md-5">
					<label for="nome">E-mail:</label> <input type="text"
						class="form-control" id="email" name="email" maxlength="45"
						value="${forn.email}">
				</div>
				
				<div class="form-group col-md-2">
					<label for="id">Inscrição Estadual:</label> <input type="text"
						class="form-control" id="inscricaoestadual" name="inscricaoestadual" maxlength="15"
						value="${forn.inscricaoestadual}">
				</div>
				
				<div class="form-group col-md-2">
					<label for="id">Inscrição Municipal:</label> <input type="text"
						class="form-control" id="inscricaomunicipal" name="inscricaomunicipal" maxlength="15"
						value="${forn.inscricaomunicipal}">
				</div>
				
				<div class="form-group col-md-3">
					<label for="foto">Foto:</label>
					 <input type="file" name="foto" value="Foto">
					 <input type="text" style="display: none;" name="fotoTemp" readonly="readonly" value="${forn.fotoBase64}" >
					 <input type="text" style="display: none;" name="contentTypeTemp" readonly="readonly" value="${forn.contentType}" >
				</div>
				
			</div>
		<input type="submit" value="Salvar" class="btn btn-primary" />
		<input type="submit" value="Cancelar" class="btn btn-primary" onclick="document.getElementById('formForn').action = 'fornecedoresServlet?acao=reset' " />
		</form>
	</div>

	<form action="pesquisaServlet" method="post">
	<div id="top" class="row">
		<div class="col-md-3"></div>
		<br />
		<div class="col-md-6">
			<div class="input-group h2">
				<input name="pesquisaFornecedores" class="form-control" id="pesquisaFornecedores"
					type="text" placeholder="Pesquisar Fornecedores">
				<input type="submit" value="Pesquisar" class="btn btn-primary" />
			</div>
		</div>
	</div>
	</form>

	<div id="list" class="row">
		<div class="table-responsive col-md-12">
			<table class="table table-striped" cellspacing="0" cellpadding="0">
				<tr>
					<th>Código</th>
					<th>Foto</th>
					<th>Nome</th>
					<th>Editar</th>
					<th>Excluir</th>
					<th>Telefones</th>
				</tr>
				<c:forEach items="${fornecedores}" var="forn">
					<tr>
						<td><c:out value="${forn.id}"></c:out></td>
						
						<c:if test="${forn.fotoBase64.isEmpty() == false}">
						 <td><a href="fornecedoresServlet?acao=download&tipo=imagem&forn=${forn.id}"><img src='<c:out value="${forn.tempFotoForn}"></c:out>' title="Baixar foto do Fornecedor" width="30px" height="30px" /></a></td>
						</c:if>
						
						<c:if test="${forn.fotoBase64.isEmpty() == true}">
							<td><img alt="Sem Foto" src="resources/images/clientes.png" onclick="alert('Fornecedor não possui Foto!')" width="33px" height="33px"></td>
						</c:if>
						
						<td><c:out value="${forn.nome}"></c:out></td>
						<td><a href="fornecedoresServlet?acao=editar&forn=${forn.id}"><img
								src="resources/images/editar.png" width="25px" height="25px"
								title="Editar Fornecedores" /></a></td>
						<td><a href="fornecedoresServlet?acao=delete&forn=${forn.id}" onclick="return confirm('Deseja realmente Excluir?');"><img
								src="resources/images/excluir.png" width="25px" height="25px"
								title="Excluir Fornecedor" /></a></td>
						<td><a
							href="telefonesFornecedoresServlet?acao=addFone&forn=${forn.id}"><img
								src="resources/images/telefones.png" width="28px" height="28px"
								title="Cadastrar Telefones" /></a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>

	<script type="text/javascript">
		function validarCampos() {
			if (document.getElementById("nome").value == '') {
				alert('Informe o Nome!');
				return false;
			} else if (document.getElementById("cnpj").value == '') {
				alert('Informe o Cnpj!');
				return false;
			} else if (document.getElementById("cep").value == '') {
				alert('Informe o Cep!');
				return false;
			}

			return true;
		}

		function consultarCep() {
			var cep = $("#cep").val();

			$.getJSON("https://viacep.com.br/ws/" + cep + "/json/?callback=?",
					function(dados) {

						if (!("erro" in dados)) {
							$("#rua").val(dados.logradouro);
							$("#bairro").val(dados.bairro);
							$("#cidade").val(dados.localidade);
							$("#estado").val(dados.uf);
							$("#ibge").val(dados.ibge);
						} else {
							$("#cep").val('');
							$("#rua").val('');
							$("#bairro").val('');
							$("#cidade").val('');
							$("#estado").val('');
							$("#ibge").val('');
							alert("CEP não encontrado.");
						}
					});
		}
	</script>


</body>
</html>
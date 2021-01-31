<%@page import="model.ModelClientes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Cadastro de Clientes</title>

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
		<form action="clientesServlet" method="post" id="formCli"
			onsubmit="return validarCampos()? true : false"
			enctype="multipart/form-data">
			<div class="row">
				<div class="form-group col-md-2">
					<label for="id">Código:</label> <input type="text"
						class="form-control" id="id" name="id" readonly=""
						value="${cli.id}">
				</div>

				<div class="form-group col-md-5">
					<label for="nome">Nome Completo:</label> <input type="text"
						class="form-control" id="nome" name="nome" maxlength="45"
						value="${cli.nome}">
				</div>

				<div class="form-group col-md-5">
					<label for="email">E-mail:</label> <input type="text"
						class="form-control" id="email" name="email" maxlength="50"
						value="${cli.email}">
				</div>
				<div class="form-group col-md-3">
					<label for="rg">Rg:</label> <input type="text" class="form-control"
						id="rg" name="rg" maxlength="11" value="${cli.rg}">
				</div>
				<div class="form-group col-md-3">
					<label for="cpf">Cpf:</label> <input type="text"
						class="form-control" id="cpf" name="cpf" maxlength="14"
						value="${cli.cpf}">
				</div>
				<div class="form-group col-md-3">
					<label for="cep">Cep:</label> <input type="text"
						class="form-control" id="cep" name="cep" maxlength="9"
						onblur="consultarCep()" value="${cli.cep}">
				</div>
				<div class="form-group col-md-3">
					<label for="rua">Rua:</label> <input type="text"
						class="form-control" id="rua" maxlength="60" name="rua"
						value="${cli.rua}">
				</div>
				<div class="form-group col-md-3">
					<label for="bairro">Bairro:</label> <input type="text"
						class="form-control" id="bairro" maxlength="45" name="bairro"
						value="${cli.bairro}">
				</div>
				<div class="form-group col-md-3">
					<label for="cidade">Cidade:</label> <input type="text"
						class="form-control" id="cidade" maxlength="45" name="cidade"
						value="${cli.cidade}">
				</div>
				<div class="form-group col-md-3">
					<label for="estado">Estado:</label>
					<div>
					<select id="estado" name="estado" style="width: 300px; height: 35px;">
						<option value="AC"
						<% 
						if (request.getAttribute("cli") != null){
							
							ModelClientes cli = (ModelClientes) request.getAttribute("cli");
							if(cli.getEstado().equalsIgnoreCase("AC")){
								out.print(" ");
								out.print("selected=\"selected\"");
								out.print(" ");
							}
							
						}
						%>
						>AC</option>
						<option value="AL" 
							<% 
						if (request.getAttribute("cli") != null){
							
							ModelClientes cli = (ModelClientes) request.getAttribute("cli");
							if(cli.getEstado().equalsIgnoreCase("AL")){
								out.print(" ");
								out.print("selected=\"selected\"");
								out.print(" ");
							}
							
						}
						%>
						>AL</option>
						<option value="AP" 
							<% 
						if (request.getAttribute("cli") != null){
							
							ModelClientes cli = (ModelClientes) request.getAttribute("cli");
							if(cli.getEstado().equalsIgnoreCase("AP")){
								out.print(" ");
								out.print("selected=\"selected\"");
								out.print(" ");
							}
							
						}
						%>
						>AP</option>
						<option value="AM" 
							<% 
						if (request.getAttribute("cli") != null){
							
							ModelClientes cli = (ModelClientes) request.getAttribute("cli");
							if(cli.getEstado().equalsIgnoreCase("AM")){
								out.print(" ");
								out.print("selected=\"selected\"");
								out.print(" ");
							}
							
						}
						%>
						>AM</option>
						<option value="BA" 
							<% 
						if (request.getAttribute("cli") != null){
							
							ModelClientes cli = (ModelClientes) request.getAttribute("cli");
							if(cli.getEstado().equalsIgnoreCase("BA")){
								out.print(" ");
								out.print("selected=\"selected\"");
								out.print(" ");
							}
							
						}
						%>
						>BA</option>
						<option value="CE" 
							<% 
						if (request.getAttribute("cli") != null){
							
							ModelClientes cli = (ModelClientes) request.getAttribute("cli");
							if(cli.getEstado().equalsIgnoreCase("CE")){
								out.print(" ");
								out.print("selected=\"selected\"");
								out.print(" ");
							}
							
						}
						%>
						>CE</option>
						<option value="ES" 
							<% 
						if (request.getAttribute("cli") != null){
							
							ModelClientes cli = (ModelClientes) request.getAttribute("cli");
							if(cli.getEstado().equalsIgnoreCase("ES")){
								out.print(" ");
								out.print("selected=\"selected\"");
								out.print(" ");
							}
							
						}
						%>
						>ES</option>
						<option value="GO" 
							<% 
						if (request.getAttribute("cli") != null){
							
							ModelClientes cli = (ModelClientes) request.getAttribute("cli");
							if(cli.getEstado().equalsIgnoreCase("GO")){
								out.print(" ");
								out.print("selected=\"selected\"");
								out.print(" ");
							}
							
						}
						%>
						>GO</option>
						<option value="MA" 
							<% 
						if (request.getAttribute("cli") != null){
							
							ModelClientes cli = (ModelClientes) request.getAttribute("cli");
							if(cli.getEstado().equalsIgnoreCase("MA")){
								out.print(" ");
								out.print("selected=\"selected\"");
								out.print(" ");
							}
							
						}
						%>
						>MA</option>
						<option value="MT"
							<% 
						if (request.getAttribute("cli") != null){
							
							ModelClientes cli = (ModelClientes) request.getAttribute("cli");
							if(cli.getEstado().equalsIgnoreCase("MT")){
								out.print(" ");
								out.print("selected=\"selected\"");
								out.print(" ");
							}
							
						}
						%>
						>MT</option>
						<option value="MS" 
							<% 
						if (request.getAttribute("cli") != null){
							
							ModelClientes cli = (ModelClientes) request.getAttribute("cli");
							if(cli.getEstado().equalsIgnoreCase("MS")){
								out.print(" ");
								out.print("selected=\"selected\"");
								out.print(" ");
							}
							
						}
						%>
						>MS</option>
						<option value="MG" 
							<% 
						if (request.getAttribute("cli") != null){
							
							ModelClientes cli = (ModelClientes) request.getAttribute("cli");
							if(cli.getEstado().equalsIgnoreCase("MG")){
								out.print(" ");
								out.print("selected=\"selected\"");
								out.print(" ");
							}
							
						}
						%>
						>MG</option>
						<option value="PA" 
							<% 
						if (request.getAttribute("cli") != null){
							
							ModelClientes cli = (ModelClientes) request.getAttribute("cli");
							if(cli.getEstado().equalsIgnoreCase("PA")){
								out.print(" ");
								out.print("selected=\"selected\"");
								out.print(" ");
							}
							
						}
						%>
						>PA</option>
						<option value="PB" 
							<% 
						if (request.getAttribute("cli") != null){
							
							ModelClientes cli = (ModelClientes) request.getAttribute("cli");
							if(cli.getEstado().equalsIgnoreCase("PB")){
								out.print(" ");
								out.print("selected=\"selected\"");
								out.print(" ");
							}
							
						}
						%>
						>PB</option>
						<option value="PR" 
							<% 
						if (request.getAttribute("cli") != null){
							
							ModelClientes cli = (ModelClientes) request.getAttribute("cli");
							if(cli.getEstado().equalsIgnoreCase("PR")){
								out.print(" ");
								out.print("selected=\"selected\"");
								out.print(" ");
							}
							
						}
						%>
						>PR</option>
						<option value="PE" 	<% 
						if (request.getAttribute("cli") != null){
							
							ModelClientes cli = (ModelClientes) request.getAttribute("cli");
							if(cli.getEstado().equalsIgnoreCase("PE")){
								out.print(" ");
								out.print("selected=\"selected\"");
								out.print(" ");
							}
							
						}
						%>>PE</option>
						<option value="PI" 
							<% 
						if (request.getAttribute("cli") != null){
							
							ModelClientes cli = (ModelClientes) request.getAttribute("cli");
							if(cli.getEstado().equalsIgnoreCase("PI")){
								out.print(" ");
								out.print("selected=\"selected\"");
								out.print(" ");
							}
							
						}
						%>
						>PI</option>
						<option value="RJ" 
							<% 
						if (request.getAttribute("cli") != null){
							
							ModelClientes cli = (ModelClientes) request.getAttribute("cli");
							if(cli.getEstado().equalsIgnoreCase("RJ")){
								out.print(" ");
								out.print("selected=\"selected\"");
								out.print(" ");
							}
							
						}
						%>
						>RJ</option>
						<option value="RN" 
							<% 
						if (request.getAttribute("cli") != null){
							
							ModelClientes cli = (ModelClientes) request.getAttribute("cli");
							if(cli.getEstado().equalsIgnoreCase("RN")){
								out.print(" ");
								out.print("selected=\"selected\"");
								out.print(" ");
							}
							
						}
						%>
						>RN</option>
						<option value="RS" 
							<% 
						if (request.getAttribute("cli") != null){
							
							ModelClientes cli = (ModelClientes) request.getAttribute("cli");
							if(cli.getEstado().equalsIgnoreCase("RS")){
								out.print(" ");
								out.print("selected=\"selected\"");
								out.print(" ");
							}
							
						}
						%>
						>RS</option>
						<option value="RO" 
							<% 
						if (request.getAttribute("cli") != null){
							
							ModelClientes cli = (ModelClientes) request.getAttribute("cli");
							if(cli.getEstado().equalsIgnoreCase("RO")){
								out.print(" ");
								out.print("selected=\"selected\"");
								out.print(" ");
							}
							
						}
						%>
						>RO</option>
						<option value="RR" 
							<% 
						if (request.getAttribute("cli") != null){
							
							ModelClientes cli = (ModelClientes) request.getAttribute("cli");
							if(cli.getEstado().equalsIgnoreCase("RR")){
								out.print(" ");
								out.print("selected=\"selected\"");
								out.print(" ");
							}
							
						}
						%>
						>RR</option>
						<option value="SC" 
							<% 
						if (request.getAttribute("cli") != null){
							
							ModelClientes cli = (ModelClientes) request.getAttribute("cli");
							if(cli.getEstado().equalsIgnoreCase("SC")){
								out.print(" ");
								out.print("selected=\"selected\"");
								out.print(" ");
							}
							
						}
						%>
						>SC</option>
						<option value="SP" 
							<% 
						if (request.getAttribute("cli") != null){
							
							ModelClientes cli = (ModelClientes) request.getAttribute("cli");
							if(cli.getEstado().equalsIgnoreCase("SP")){
								out.print(" ");
								out.print("selected=\"selected\"");
								out.print(" ");
							}
							
						}
						%>
						>SP</option>
						<option value="SE" 
							<% 
						if (request.getAttribute("cli") != null){
							
							ModelClientes cli = (ModelClientes) request.getAttribute("cli");
							if(cli.getEstado().equalsIgnoreCase("SE")){
								out.print(" ");
								out.print("selected=\"selected\"");
								out.print(" ");
							}
							
						}
						%>
						>SE</option>
						<option value="TO" 
							<% 
						if (request.getAttribute("cli") != null){
							
							ModelClientes cli = (ModelClientes) request.getAttribute("cli");
							if(cli.getEstado().equalsIgnoreCase("TO")){
								out.print(" ");
								out.print("selected=\"selected\"");
								out.print(" ");
							}
							
						}
						%>
						>TO</option>
						<option value="DF" 
							<% 
						if (request.getAttribute("cli") != null){
							
							ModelClientes cli = (ModelClientes) request.getAttribute("cli");
							if(cli.getEstado().equalsIgnoreCase("DF")){
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
						class="form-control" id="ibge" name="ibge" value="${cli.ibge}">
				</div>

				<div class="form-group col-md-3">
					<label for="foto">Foto:</label>
					 <input type="file" name="foto" value="Foto">
					 <input type="text" style="display: none;" name="fotoTemp" readonly="readonly" value="${cli.fotoBase64}">
					 <input type="text" style="display: none;" name="contentTypeTemp" readonly="readonly" value="${cli.contentType}">
				</div>

			</div>
			
				    <input type="submit" value="Salvar" class="btn btn-primary" />
				    <input type="submit" value="Cancelar" class="btn btn-primary" onclick="document.getElementById('formCli').action = 'clientesServlet?acao=reset' " />
		</form>
	</div>

	<form action="pesquisaServlet" method="post">
	<div id="top" class="row">
		<div class="col-md-3"></div>
		<br />
		<div class="col-md-6">
			<div class="input-group h2">
				<input name="pesquisacliente" class="form-control" id="pesquisacliente"
					type="text" placeholder="Pesquisar Cliente">
				<input type="submit" value="Pesquisar" class="btn btn-primary" />
			</div>
		</div>
	</div>
	</form>
	
	<br />

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
				<c:forEach items="${clientes}" var="cli">
					<tr>
						<td><c:out value="${cli.id}"></c:out></td>
						
						<c:if test="${cli.fotoBase64.isEmpty() == false}">
						 <td><a href="clientesServlet?acao=download&tipo=imagem&cli=${cli.id}"><img src='<c:out value="${cli.tempFotoCli}"></c:out>' title="Baixar foto do Cliente" width="30px" height="30px" /></a></td>
						</c:if>
						
						<c:if test="${cli.fotoBase64.isEmpty() == true}">
							<td><img alt="Sem Foto" src="resources/images/clientes.png" onclick="alert('Cliente não possui Foto!')" width="33px" height="33px"></td>
						</c:if>
						
						<td><c:out value="${cli.nome}"></c:out></td>
						<td><a href="clientesServlet?acao=editar&cli=${cli.id}"><img
								src="resources/images/editar.png" width="25px" height="25px"
								title="Editar Cliente" /></a></td>
						<td><a href="clientesServlet?acao=delete&cli=${cli.id}" onclick="return confirm('Deseja realmente Excluir?');"><img
								src="resources/images/excluir.png" width="25px" height="25px"
								title="Excluir Cliente" /></a></td>
						<td><a
							href="telefonesClientesServlet?acao=addFone&cli=${cli.id}"><img
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
			} else if (document.getElementById("email").value == '') {
				alert('Informe o E-mail!');
				return false;
			} else if (document.getElementById("rg").value == '') {
				alert('Informe o Rg!');
				return false;
			} else if (document.getElementById("cpf").value == '') {
				alert('Informe o Cpf!');
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
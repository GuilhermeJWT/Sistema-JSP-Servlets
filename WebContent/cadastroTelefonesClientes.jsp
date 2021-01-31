<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Telefones Clientes</title>

</head>
<body>


	<%@ include file="templateCabecalho.jsp"%>

	<div id="main" class="container-fluid">

		<center>
			<h2 class="page-header">Cadastro de Telefones</h2>
			<h3 style="color: red;">${msg}</h3>
			<h3 style="color: blue;">${msgboa}</h3>
		</center>
		<form action="telefonesClientesServlet" method="post" id="formCli"
			onsubmit="return validarCampos()? true : false">

			<div class="row">
				<div class="form-group col-md-2">
					<label for="id">Código Cliente:</label> <input type="text"
						class="form-control" id="id" name="id" readonly=""
						value="${clienteEscolhido.id}">
				</div>

				<div class="form-group col-md-4">
					<label for="nome">Nome Cliente:</label> <input type="text"
						class="form-control" id="nome" name="nome" readonly=""
						value="${clienteEscolhido.nome}">
				</div>

				<div class="form-group col-md-3">
					<label for="numero">Número:</label> <input type="text"
						class="form-control" id="numero" maxlength="14" name="numero">
				</div>
					
					<div class="form-group col-md-3">
					<label for="tipo">Tipo:</label>
					<div>
					<select id="tipo" name="tipo" style="width: 300px; height: 35px;">
						<option>Casa</option>
						<option>Contato</option>
						<option>Trabalho</option>
						<option>Não Declarar</option>
					</select>
					</div>
					</div>

				<hr />
				<div id="actions" class="row">
					<div class="col-md-12">
						<button type="submit" class="btn btn-primary">Salvar</button>
						<button type="submit" class="btn btn-primary" onclick="document.getElementById('formCli').action = 'telefonesClientesServlet?acao=voltar'">Voltar</button>
					</div>
				</div>
		</form>
	</div>

	<div id="main" class="container-fluid">
		<div id="top" class="row"></div>

		<hr />
		<div id="list" class="row"></div>

		<div id="bottom" class="row"></div>

	</div>
	<!-- /#main -->

	<div id="top" class="row">
		<div class="col-md-3"></div>
		<br />
		<div class="col-md-6">
			<div class="input-group h2">
				<input name="data[search]" class="form-control" id="search"
					type="text" placeholder="Pesquisar Telefones">
			</div>
		</div>
	</div>
	<br />

	<div id="list" class="row">
		<div class="table-responsive col-md-12">
			<table class="table table-striped" cellspacing="0" cellpadding="0">
				<tr>
					<th>Código</th>
					<th>Número</th>
					<th>Tipo</th>
					<th>Excluir</th>
				</tr>
				<c:forEach items="${telefones}" var="fone">
					<tr>
						<td><c:out value="${fone.id}"></c:out></td>
						<td><c:out value="${fone.numero}"></c:out></td>
						<td><c:out value="${fone.tipo}"></c:out></td>
						<td><a href="telefonesClientesServlet?acao=deleteFone&foneId=${fone.id}" onclick="return confirm('Deseja realmente Excluir?');"><img
								src="resources/images/excluir.png" width="25px" height="25px"
								title="Excluir Cliente" /></a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>




</body>
</html>
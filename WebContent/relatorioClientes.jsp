<%@page import="model.ModelClientes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Relatório de Clientes</title>

	<link rel="stylesheet" href="resources/css/bootstrap-grid.min.css">
    <link rel="stylesheet" href="resources/css/base.css">
    <link rel="stylesheet" href="resources/css/layout.css">
    <link rel="stylesheet" href="resources/css/componentes.css">

</head>
<body>

	<%@ include file="templateCabecalho.jsp" %> 

	<center style="padding: 20%;">
		<h2>Relatório de Clientes em Pdf e Excel</h2>
		<a href="relatorioClientesServlet?tipo=pdf"><img src="resources/images/relatorioPdf.png" title="Relatório em Pdf"></a>
		<a href="relatorioClientesServlet?tipo=excel"><img src="resources/images/relatorioExcel.png" title="Relatório em Excel"></a>
	</center>


</body>
</html>
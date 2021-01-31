<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="resources/css/login.css">
</head>
<body>

	<section class="forms-section">
  <h1 class="section-title">Login: systemsgs@admin | Senha: admin</h1>
  <div class="forms">
    <div class="form-wrapper is-active">
      <button type="button" class="switcher switcher-login">
        Login
        <span class="underline"></span>
      </button>
      <form action="LoginServlet" class="form form-login" method="post">
          <div class="input-block">
            <label for="login-email">E-mail</label>
            <input id="login" name="login" type="text" required>
          </div>
          <div class="input-block">
            <label for="login-password">Senha</label>
            <input id="senha" name="senha" type="password" required>
          </div>
        <input type="submit" class="btn-login" value="Logar"/>
      </form>
    </div>
    <div class="form-wrapper">
      <button type="button" class="switcher switcher-signup">
        Cadastro
        <span class="underline"></span>
      </button>
      <form action="LoginServlet" class="form form-signup" method="post">
        <fieldset>
          <legend>Insira seu e-mail e senha para confirmar seu cadastro!</legend>
          <div class="input-block">
            <label for="signup-email">E-mail</label>
            <input id="cadastrologin" name="cadastrologin" type="text" required>
          </div>
          <div class="input-block">
            <label for="signup-password">Senha</label>
            <input id="cadastrosenha" name="cadastrosenha" type="password" required>
          </div>
          <div class="input-block">
            <label for="signup-password-confirm">Nome</label>
            <input id="cadastronome" name="cadastronome" type="text" required>
          </div>
        </fieldset>
        <button type="submit" class="btn-signup">Cadastrar</button>
      </form>
    </div>
  </div>
</section>

<script src="resources/js/login.js"></script>

</body>
</html>
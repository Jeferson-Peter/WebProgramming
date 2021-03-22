<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "java.util.*,
    					 br.org.catolicasc.dao.*,
    					 br.org.catolicasc.model.*" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1"> 
<title>Insert title here</title>
</head>
<body>
	<h1>feliz teste</h1>
	<% String Mensagem = "Bem - vindo"; %>
	
	<% out.println(Mensagem); %> <br />
	
	<%= Mensagem %>
	
	<% String desenvolvido = "Jeferson Peter";  %><br/>
	
	<%= desenvolvido %>
	
	<%System.out.println("Desenvolvido por Jeferson Peter"); %>
	<table>
	<% AutomovelDao automovelDao = new AutomovelDao(); 
		List<Automovel> automoveis = automovelDao.listar();
		for(Automovel automovel : automoveis){%>
		<tr>
			<td><%=automovel.getId()%> </td>
			<td><%=automovel.getModelo() %> </td>
			<td><%=automovel.getMarca() %> </td>
			<td><%=automovel.getObservacoes() %> </td>
		</tr>
		<%} %>
	</table>
</body>
</html>
<%-- 
    Document   : smartbr
    Created on : 18/06/2022, 22:09:53
    Author     : andrey
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Contato"%>
<%@page import="java.util.ArrayList"%>
<%
    ArrayList<Contato> lista = (ArrayList<Contato>) request.getAttribute("contato");
    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Area de contato</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <h1 class="Center">Área de contato</h1>
        <h2>Mensagens dos clientes</h2>
        <table id="tabela">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Nome</th>
                    <th>E-mail</th>
                    <th>Fone</th>
                    <th>Mensagem</th>
                    <th>Opções</th>
                </tr>
            </thead>
            <tbody>
                <%for (int i=0; i<lista.size(); i++) { %>
                    <tr>
                        <td><%=lista.get(i).getIdcon()%></td>
                        <td><%=lista.get(i).getNome()%></td>
                        <td><%=lista.get(i).getEmail()%></td>
                        <td><%=lista.get(i).getFone()%></td>
                        <td><%=lista.get(i).getMensagem()%></td>
                        <td><a href="select?idcon=<%=lista.get(i).getIdcon()%>" class="Botao1">Editar</a>
                        <a href="javascript: confirmar(<%=lista.get(i).getIdcon()%>)" class="Botao2">Remover</a>
                        </td>
                    </tr>    
                <%} %>
            </tbody>
        </table>
        <script src="scripts/confirmador.js"></script>
        <h2>Deixe sua mensagem</h2>
        <div class="Center">
            <a href="novo.html" class="Botao1">Nova mensagem</a>
        </div>
    </body>
</html>


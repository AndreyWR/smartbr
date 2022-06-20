<%-- 
    Document   : editar
    Created on : 18/06/2022, 22:07:46
    Author     : andrey
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SmartBR</title>
        <link rel="stylesheet" href="style.css">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Editar informações do contato</h1>
        <form name="frmContato" action="update">
            <table>
                <tr>
                    <td><input type="text" name="idcon" id="caixa3" readonly value="<%out.print(request.getAttribute("idcon"));%>"></td>
                </tr>
                <tr>
                    <td><input type="text" name="nome" class="Caixa1" value="<%out.print(request.getAttribute("nome"));%>"></td>
                </tr>
                <tr>
                    <td><input type="text" name="email" class="Caixa1" value="<%out.print(request.getAttribute("email"));%>"></td>                    
                </tr>
                <tr>
                    <td><input type="text" name="fone" class="Caixa1" value="<%out.print(request.getAttribute("fone"));%>"></td>                    
                </tr>
                <tr>
                    <td><input type="text" name="mensagem" class="Caixa4" value="<%out.print(request.getAttribute("mensagem"));%>"></td>                    
                </tr>
            </table>
            <input type="button" value="Salvar" class="Botao1" onclick="validar()">
        </form>
        <script src="scripts/validador.js"></script>
    </body>
</html>


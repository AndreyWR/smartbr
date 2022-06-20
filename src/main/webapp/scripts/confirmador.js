/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

/**
 * Confirmação de exclusão de um contato
 * @author Andrey Ribeiro
 */

function confirmar(idcon){
    let resposta = confirm("Confirmar a exclusão deste contato?")
    if(resposta === true){
        //alert(idcon)
        window.location.href = "delete?idcon=" + idcon
    }
}

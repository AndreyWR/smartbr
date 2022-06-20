/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


/**
 * Validação de formulário
 * @author Andrey Ribeiro
 */

function validar(){
    let nome = frmContato.nome.value
    let email = frmContato.email.value
    let fone = frmContato.fone.value
    let mensagem = frmContato.mensagem.value
    
    if(nome === ""){
        alert('Preencha o campo Nome')
        frmContato.nome.focus()
        return false
    } else if(email === ""){
        alert('Preencha o campo E-mail')
        frmContato.email.focus()
        return false
    } else if(fone === ""){
        alert('Preencha o campo Fone')
        frmContato.fone.focus()
        return false
    } else if(mensagem === ""){
        alert('Preencha o campo Mensagem')
        frmContato.mensagem.focus()
        return false
    }else{
        document.forms["frmContato"].submit()
    }
}

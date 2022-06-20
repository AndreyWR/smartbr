/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Contato;
import model.DAO;

/**
 *
 * @author andrey
 */
@WebServlet(name = "Controller", urlPatterns = {"/Controller", "/main", "/insert", "/select", "/update", "/delete"})
public class Controller extends HttpServlet {
    
    DAO dao = new DAO();
    Contato contato = new Contato();
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controller</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controller at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String action = request.getServletPath();
        System.out.println(action);
        if (action.equals("/main")){
            contatos(request, response);
        }else if(action.equals("/insert")){
            novoContato(request, response);
        }else if(action.equals("/select")){
            listarContato(request, response);
        }else if(action.equals("/update")){
            editarContato(request, response);
        }else if(action.equals("/delete")){
            removerContato(request, response);
        }else {
            response.sendRedirect("index.html");
        }
    }
    
    // Listar contatos
    protected void contatos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        // Criando um objeto que irá receber os dados Contato
        ArrayList<Contato> lista = dao.listarContatos();
        
        // Encaminhar a lista ao documento smartbrsite.jsp
        request.setAttribute("contato", lista);
        RequestDispatcher rd = request.getRequestDispatcher("smartbr.jsp");
        rd.forward(request, response);
    }
    
    // Novo contato
    protected void novoContato(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
        // setar as variáveis JavaBeans
        contato.setNome(request.getParameter("nome"));
        contato.setEmail(request.getParameter("email"));
        contato.setFone(request.getParameter("fone"));
        contato.setMensagem(request.getParameter("mensagem"));
        
        //invocar o método inserirContato passando o objeto contato
        dao.inserirContato(contato);
        //redirecionar para o documento smartbrsite.jsp
        response.sendRedirect("main");
    }
    
    //Listar contato
    protected void listarContato(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        // Recebimento do id do contato que será editado
        Integer idcon = Integer.parseInt(request.getParameter("idcon"));
        
        // Setar a variável Contato
        contato.setIdcon(idcon);
        
        // Executar o método selecionarContato (DAO)
        dao.selecionarContato(contato);
        
        // Setar os atributos do formulário com o conteúdo Contato (classe JavaBeans)
        request.setAttribute("idcon", contato.getIdcon());
        request.setAttribute("nome", contato.getNome());
        request.setAttribute("email", contato.getEmail());
        request.setAttribute("fone", contato.getFone());
        request.setAttribute("mensagem", contato.getMensagem());
        
        // Encaminhar ao documento editar.jsp
        RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
        rd.forward(request, response);
    }
    
    //Editar contato
    protected void editarContato(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        // setar as variáveis Contato (JavaBeans)
        contato.setIdcon(Integer.parseInt(request.getParameter("idcon")));
        contato.setNome(request.getParameter("nome"));
        contato.setEmail(request.getParameter("email"));
        contato.setFone(request.getParameter("fone"));
        contato.setMensagem(request.getParameter("mensagem"));
        
        //executar o méodo alterarContato
        dao.alterarContato(contato);
        
        //redirecionar para o documento smartbrsite.jsp (atualizando as alterações)
        response.sendRedirect("main");
    }
    
    // Remover um contato
    protected void removerContato(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        // Recebimento do id do contato a ser excluído (validador.js)
        Integer idcon = Integer.parseInt(request.getParameter("idcon"));
        
        // Setar a variável idcon Contato (JavaBeans)
        contato.setIdcon(idcon);
        
        // Executar o método deletarContato (DAO) passando o objeto contato
        dao.deletarContato(contato);
        
        //redirecionar para o documento smartbrsite.jsp (atualizando as alterações)
        response.sendRedirect("main");
    }
}

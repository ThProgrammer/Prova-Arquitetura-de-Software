package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.EmpresaDao;
import model.Usuario;

/**
 * Servlet gerenciará tudo referente a tabela usuário!!!*
 */
@WebServlet(name = "ControleUsuario", urlPatterns = {"/ControleUsuario"})
public class ControleUsuario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
            String flag, u, s, mensagem;
            flag = request.getParameter("flag");
            
            if (flag.equals("login")) {
                u = request.getParameter("usuario");
                s = request.getParameter("senha");
                
                /*Agora vem a validação de usuario e senha; 
                Se usuario e senha tiver presente no banco de dados acess graned
                */
                
                EmpresaDao dao = new EmpresaDao();
                Usuario usuario = dao.validarLogin(u, s);
                
                if (usuario == null) { //não achou o usuário
                    mensagem = "usuário e/ou senha inválidos";
                }
                else { //achou o usuário
                    
                }
            }
            
            //Se não tiver, manda o usuario cadastar!!
            else if(flag.equals("cadastroUsuario"))  {
                //Aqui vem a parte de cadastrar usuario
            }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

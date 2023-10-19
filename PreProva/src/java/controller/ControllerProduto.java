package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.BancoDao;
import model.Produto;

/**
 *
 * @author Thomas
 */
@WebServlet(name = "ControllerProduto", urlPatterns = {"/ControllerProduto"})
public class ControllerProduto extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String flag, mensagem;
        int id;
        String nome, marca;
        double preco;

        flag = request.getParameter("flag");

        if (flag.equals("cadastroProduto")) {

            id = Integer.parseInt(request.getParameter("id"));
            nome = request.getParameter("nome");
            marca = request.getParameter("marca");
            preco = Double.parseDouble(request.getParameter("preco"));

            Produto produto = new Produto(id, nome, marca, preco);
            
            switch(new BancoDao().cadastrar(produto)){                
                case 1:
                    mensagem = "produto cadastrado com sucesso";
                    break;
                case 2:
                    mensagem = "O produto "+produto.getId()+" já está cadastrado";
                    break;
                default:
                    mensagem = "Erro ao tentar salvar o produto";
                    break;
            }
            request.setAttribute("mensagem", mensagem);
            request.getRequestDispatcher("mensagens.jsp").forward(request, response);
            

            /*BancoDao dao = new BancoDao();

            dao.cadastrar(produto);*/
            
            

            /*PrintWriter out = response.getWriter();

            out.print(id);
            out.print(nome);
            out.print(marca);
            out.print(preco);*/
        } else if(flag.equals("listagem")){
            List<Produto> produtos = new BancoDao().listar("Produto.findAll", Produto.class);
            if(produtos == null){
                request.setAttribute("mensagem", "Nenhum produto cadastrado no momento");
                request.getRequestDispatcher("mensagem.jsp").forward(request, response);
            } else {                
                request.setAttribute("produtos", produtos);
                request.getRequestDispatcher("listagem.jsp").forward(request, response);
            }     
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

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

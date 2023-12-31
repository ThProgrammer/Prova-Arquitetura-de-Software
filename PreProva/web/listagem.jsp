<%@page import="java.util.List"%>
<%@page import="model.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            List<Produto> produtos = (List<Produto>) request.getAttribute("produtos");
        %>
        <table border='1'>
            <tr>
                <th> ID </th>
                <th> Nome </th>   
                <th> Marca </th>
                <th> Preco </th>
            </tr>
            <%
                for (Produto produto : produtos) {
            %>   
            <tr>
                <td> <%= produto.getId()%> </td>
                <td> <%= produto.getNome()%> </td>
                <td> <%= produto.getMarca()%> </td>
                <td> <%= produto.getPreco()%> </td> 
            </tr>    
            <%
                }
            %> 
        </table>    
    </body>
</html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Operaciones"%>
<%@page session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Login</title>
    </head>
    <body>
        <div class="container mt-4 col-lg-4">
            <div class="card col-sm-10">
                <div class="card-body">
                    <form class="form-sign" action="" method="POST">
                        <div class="form-group text-center">
                            <h3>Login</h3>
                            
                            <label>Bienvenidos al Sistema</label>
                        </div>
                        <div class="form-group">
                            <label>Usuario:</label>
                            <input type="text" name="txtuser" value="" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Password:</label>
                            <input type="password" name="txtpass" value="" class="form-control">
                        </div>
                        <input type="submit" name="btnIngresar" value="Ingresar" class="btn btn-primary btn-block">
                    </form>
                        <%
                            Operaciones op = new Operaciones();
                            if(request.getParameter("btnIngresar")!=null){
                            String nombre = request.getParameter("txtuser");
                            String contra = request.getParameter("txtpass");
                            HttpSession sesion = request.getSession();
                            switch(op.loguear(nombre, contra)){
                            case 1:
                               
                               sesion.setAttribute("user", nombre);
                               sesion.setAttribute("nivel", "1");
                               response.sendRedirect("principal.jsp");
                            break;
                            case 2:
                               
                               sesion.setAttribute("user", nombre);
                               sesion.setAttribute("nivel", "2");
                               response.sendRedirect("secundario.jsp");
                            break;
                            
                            default:
                            out.write("usuario no existe, o constrasena invalida");
                            break;
                            }
                            
                            }    
                        
                        %>
                   
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
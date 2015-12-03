/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistencia.conexion;

/**
 *
 * @author Arellano
 */
public class RegistroUsuario extends HttpServlet {

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
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
           PrintWriter out = response.getWriter();
          conexion c = new conexion();
               
                   String nombre= request.getParameter("nombre_txt");
                   String apepa=request.getParameter("apepa_txt");
                   String apema=request.getParameter("apema_txt");
                   String calle=request.getParameter("calle_txt");
                   String colonia_txt= request.getParameter("colonia_txt");
                   String municipio_txt=  request.getParameter("municipio_txt");
                   String estado_slc= request.getParameter("estado_slc");
                   String codigo_post_txt=  request.getParameter("codigo_post_txt");
                   String tel_fijo_txt=  request.getParameter("tel_fijo_txt");
                   String cel_txt= request.getParameter("cel_txt");
                   String correo_txt= request.getParameter("correo_txt");
                   String nacimiento_txt= request.getParameter("nacimiento_txt");
                   String rfc_txt= request.getParameter("rfc_txt");
                   String sexo_rdo= request.getParameter("sexo_rdo");
                   String usuario_txt= request.getParameter("usuario_txt");
                   String contrasena_txt= request.getParameter("contrasena_txt");
                 
                     String query= "insert into persona (NomPer, ApePat, ApeMat, DirCal, DirCol, DirMun, DirEst, DirPai, CodPos, TelFij, TelCel, CorEle, FecNac, RfcHom, SexDat, FecIni, UsuPer, ConPas, EstPer, TipPer) " +
                 "values ('" + nombre + "', '" + apepa + "', '" + apema + "', '" + calle + "', "
                       + "'" + colonia_txt + "', '" + municipio_txt + "', '" + estado_slc + "', 'Mexico', "
                       + "'" + codigo_post_txt + "', '" + tel_fijo_txt + "', '" + cel_txt + "', '" + correo_txt + "', "
                       + "'" + nacimiento_txt + "', '" + rfc_txt + "', '" + sexo_rdo + "', '0000-00-00 00:00:00', "
                       + "'" + usuario_txt + "', '" + contrasena_txt + "', 'A', 'U'"
                       + ")";
                String resinsert=c.insUpd(query);
                System.out.println("result "+query);
                    if(resinsert.equals("ok")){
                      
                           String mensaje= "Los datos fueron guardados correctamente";
                           out.println("<script>alert('"+mensaje+"');</script>");
                          out.println("<script>location.href='index.jsp?mensaje="+mensaje+"'</script>");
                    }else{
                         
                           String mensaje= "Error al guardar el registro intente mas tarde";
                           out.println("<script>alert('"+mensaje+"');</script>");
                           out.println("<script>location.href='index.jsp?mensaje="+mensaje+"'</script>");
                           request.setAttribute("mensaje", "No se pudo insertar ");
                    }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

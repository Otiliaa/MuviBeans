/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 *
 * @author OTI
 */

public class RegistrationController extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel=\"stylesheet\" href=\"style.css\" type=\"text/css\"/>");  
            out.println("<title>Servlet RegistrationController</title>");  
            out.println("<meta charset=\"UTF-8\">");  
            out.println("<meta name=\"viewport\" content=\"width=device-width\">");  
            out.println("</head>");
            out.println("<body>");
            out.println("<div id=\"content\">");
            out.println("<div class=\"header\">");
            out.println("<img src=\"./img/companyLogo.jpg\" width=\"100px\"  />");
            out.println("<span class=\"header-text\">COMPANY NAME</span>");  
            out.println("</div>");  
            out.println("<nav>");  
            out.println("<ul>");  
            out.println("<li><a href=\"#\">Home</a></li>");
            out.println("<li><a href=\"#\">Register</a></li>");
            out.println("<li><a href=\"#\">Contact</a></li>");  
            out.println("</ul>");
            out.println("</nav>");
            out.println("<h1>Servlet RegistrationController at " + request.getContextPath() + "</h1>");
            Map m=request.getParameterMap();
            Set s = m.entrySet();
            Iterator it = s.iterator();
            Exists exists =  new Exists();
            while(it.hasNext()){
                Map.Entry<String,String[]> entry = (Map.Entry<String,String[]>)it.next();

                String key = entry.getKey();
                String[] value = entry.getValue();

                for (int i = 0; i < value.length; i++) {
                  out.print("Parameter " + key + " has value " + value[i] + "</br>");
                  if( key.equals("uname") && exists.userExists( value[i] ) == true ){
                        response.getWriter().print("User alread exists");
                  }
                 }
            }
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
        processRequest(request, response);
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
    }// </editor-fold>
    
    
    
public static void main(String[] args) throws ClassNotFoundException,
SQLException {
 String url = "muvi:mysql://localhost:3306/MuviBeans";
 Class.forName("com.mysql.jdbc.Driver");
 Connection con = DriverManager.getConnection(url, "muvi",
"password");
 Statement instr = con.createStatement();
 String sql = "SELECT * FROM users";
 ResultSet rs = instr.executeQuery(sql);
 while (rs.next()) {
 System.out.println(rs.getString("username"));
 }
 rs.close();
instr.close();
 con.close();
 }

}

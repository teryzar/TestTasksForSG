/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.errors.ErrorTemplate;
import pojo.users.InsertUserTemplate;
import pojo.users.InsertedUserTemplate;
import utils.database.AddUser;

/**
 *
 * @author Andrey
 */
public class Signin extends HttpServlet {

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
               //преобразовіваем JSON запрос в строку
        StringBuffer jb = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                jb.append(line);
            }
        } catch (IOException ex) {

        }
        String sourceJson = jb.toString();
        ObjectMapper mapper = new ObjectMapper();
        InsertUserTemplate userToAdd = mapper.readValue(sourceJson, InsertUserTemplate.class);
        //преобразрвіваем JSON в обьект и добавляем его в базу данных
        int status = AddUser.loginUser(userToAdd, request.getSession().getId());
        try (PrintWriter out = response.getWriter()) {//here we are
            if (status == 200) {
                InsertedUserTemplate userTempl = new InsertedUserTemplate(status, request.getSession().getId());
                mapper.writeValue(out, userTempl);
            } else {
                response.setStatus(status);
                ErrorTemplate error = new ErrorTemplate(status, "do text generator for errors!!!");
                mapper.writeValue(out, error);
            }

        } catch (Exception e) {
            //do somthing
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
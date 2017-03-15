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
import utils.user.UserActions;

/**
 *
 * @author Andrey
 */
public class Signin extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Processing POST requests on /signup
     *
     * @param request servlet request in JSON
     * @param response servlet response inJSON
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
        int status = UserActions.loginUser(userToAdd, request.getSession().getId());
        try (PrintWriter out = response.getWriter()) {
            if (status == 200) {
                InsertedUserTemplate userTempl = new InsertedUserTemplate(status, request.getSession().getId());
                mapper.writeValue(out, userTempl);
            } else {
                response.setStatus(status);
                ErrorTemplate error = new ErrorTemplate(status);
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

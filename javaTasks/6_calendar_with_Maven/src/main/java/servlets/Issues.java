package servlets;

//Сервлет для обработки запросов связаных с Issue 

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.*;
import org.json.simple.parser.*;
import pojo.issues.InsertIssueTemplate;
import pojo.issues.SelectIssueDetTemplate;
import pojo.issues.SelectIssueListTemplate;
import utils.database.AddIssue;
import utils.database.DataHelper;

public class Issues extends HttpServlet {

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
        response.setContentType("application/json");
        Map<String, String[]> paramMap = request.getParameterMap();
        //если не передали параметры - извлекаем список Issues
        if (paramMap.isEmpty()) {
            try (PrintWriter out = response.getWriter()) {
                SelectIssueListTemplate issueList = new SelectIssueListTemplate(response.getStatus(), DataHelper.getInstance().getIssuesIds());
                ObjectMapper mapper = new ObjectMapper();
                mapper.writeValue(out, issueList);
            } catch (Exception e) {

            }
        //если перезали параметр ID возвращаем подробности Issue
        } else if (request.getParameter("id") != null) {
            try (PrintWriter out = response.getWriter()) {
                int i = Integer.valueOf(request.getParameter("id").toString()).intValue();
                SelectIssueDetTemplate issueDetails = new SelectIssueDetTemplate(response.getStatus(), DataHelper.getInstance().getIssueById(i));
                ObjectMapper mapper = new ObjectMapper();
                mapper.writeValue(out, issueDetails);
            } catch (Exception e) {

            }
        }
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
        InsertIssueTemplate issueToInsert = mapper.readValue(sourceJson, InsertIssueTemplate.class);
        //преобразрвіваем JSON в обьект и добавляем его в базу данных
        AddIssue.addIssue(issueToInsert);
        
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

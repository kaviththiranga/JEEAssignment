/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kavith.jee.assignment.webclient.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author KavithThiranga
 */
public class FrontController extends HttpServlet {
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RequestDispatcher dispatcher;
        String action = request.getParameter("action");
        String type =   request.getParameter("type");
        
        if(action.equals("create")){
            switch(type){
                case "aircraft":
                    dispatcher = request.getRequestDispatcher(getServletContext().getContextPath() + "/aircraft/create.jsp");
                    break;
                case "flight":
                    dispatcher = request.getRequestDispatcher(getServletContext().getContextPath() + "/flight/create.jsp");
                    break;
                case "passenger":
                    dispatcher = request.getRequestDispatcher(getServletContext().getContextPath() + "/passenger/create.jsp");
                    break;
                case "booking":
                    dispatcher = request.getRequestDispatcher(getServletContext().getContextPath() + "/booking/create.jsp");
                    break;       
            }        
        }
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

   
}

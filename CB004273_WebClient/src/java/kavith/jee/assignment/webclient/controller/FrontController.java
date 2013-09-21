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
        
        RequestDispatcher dispatcher = request.getRequestDispatcher(getServletContext().getContextPath() +"/index.jsp");
        String action = request.getParameter("action");
        String type =   request.getParameter("type");
        
        if(action.equals("create")){
            switch(type){
                case "aircraft":
                    dispatcher = request.getRequestDispatcher("/Aircraft/create.jsp");
                    break;
                case "flight":
                    dispatcher = request.getRequestDispatcher( "/flight/create.jsp");
                    request.setAttribute("aircrafts", Controller.getDataQuerySerivceBeanRemote().getListofAircrafts());
                    break;
                case "passenger":
                    dispatcher = request.getRequestDispatcher( "/passenger/create.jsp");                    
                    break;
                case "booking":
                    dispatcher = request.getRequestDispatcher( "/booking/create.jsp");
                    request.setAttribute("flights", Controller.getDataQuerySerivceBeanRemote().getListofFilghts());
                    request.setAttribute("passengers", Controller.getDataQuerySerivceBeanRemote().getListofPassengers());
                    break;       
            }        
        }
        else if(action.equals("list")){
            switch(type){
                case "aircraft":
                    dispatcher = request.getRequestDispatcher(getServletContext().getContextPath() + "/aircraft/list.jsp");
                    break;
                case "flight":
                    dispatcher = request.getRequestDispatcher(getServletContext().getContextPath() + "/flight/list.jsp");
                    request.setAttribute("aircrafts", Controller.getDataQuerySerivceBeanRemote().getListofAircrafts());
                    break;
                case "passenger":
                    dispatcher = request.getRequestDispatcher(getServletContext().getContextPath() + "/passenger/list.jsp");                    
                    break;
                case "booking":
                    dispatcher = request.getRequestDispatcher(getServletContext().getContextPath() + "/booking/list.jsp");
                    request.setAttribute("flights", Controller.getDataQuerySerivceBeanRemote().getListofFilghts());
                    request.setAttribute("passengers", Controller.getDataQuerySerivceBeanRemote().getListofPassengers());
                    break;       
            }        
        }
        dispatcher.forward(request, response);
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

   
}

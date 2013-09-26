/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kavith.jee.assignment.webclient.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kavith.jee.assignment.utils.AircraftDetails;
import kavith.jee.assignment.utils.BookingDetails;
import kavith.jee.assignment.utils.FlightDetails;
import kavith.jee.assignment.utils.PassengerDetails;

/**
 *
 * @author KavithThiranga
 */
public class FrontController extends HttpServlet {

    @Resource(mappedName = "java:comp/DefaultJMSConnectionFactory")
    private ConnectionFactory connectionFactory;
    @Resource(mappedName = "FilghtBookingService")
    private Queue queue;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/manage.jsp");
        String action = request.getParameter("action");
        String type = request.getParameter("type");

        if (action.equals("create")) {
            switch (type) {
                case "aircraft":
                    dispatcher = request.getRequestDispatcher("/Aircraft/create.jsp");
                    break;
                case "flight":
                    dispatcher = request.getRequestDispatcher("/flight/create.jsp");
                    request.setAttribute("aircrafts", Controller.getDataQuerySerivceBeanRemote().getListofAircrafts());
                    break;
                case "passenger":
                    dispatcher = request.getRequestDispatcher("/passenger/create.jsp");
                    break;
                case "booking":
                    dispatcher = request.getRequestDispatcher("/booking/create.jsp");
                    request.setAttribute("flights", Controller.getDataQuerySerivceBeanRemote().getListofFilghts());
                    request.setAttribute("passengers", Controller.getDataQuerySerivceBeanRemote().getListofPassengers());
                    break;
            }
        } else if (action.equals("list")) {
            switch (type) {
                case "aircraft":
                    dispatcher = request.getRequestDispatcher("/Aircraft/list.jsp");
                    request.setAttribute("aircrafts", Controller.getDataQuerySerivceBeanRemote().getListofAircrafts());
                    break;
                case "flight":
                    dispatcher = request.getRequestDispatcher("/flight/list.jsp");
                    request.setAttribute("flights", Controller.getDataQuerySerivceBeanRemote().getListofFilghts());
                    break;
                case "passenger":
                    dispatcher = request.getRequestDispatcher("/passenger/list.jsp");
                    request.setAttribute("passengers", Controller.getDataQuerySerivceBeanRemote().getListofPassengers());
                    break;
                case "booking":
                    dispatcher = request.getRequestDispatcher("/booking/list.jsp");
                    request.setAttribute("bookings", Controller.getDataQuerySerivceBeanRemote().getListofBookings());
                    break;
            }
        } else if (action.equals("BookingService")) {
            dispatcher = request.getRequestDispatcher("/booking.jsp");
            request.setAttribute("passengers", Controller.getDataQuerySerivceBeanRemote().getListofPassengers());
            request.setAttribute("flights", Controller.getDataQuerySerivceBeanRemote().getListofFilghts());
        } else if (action.equals("QueryService")) {
            dispatcher = request.getRequestDispatcher("/query.jsp");
            request.setAttribute("bookingsForPassengerP005", Controller.getDataQuerySerivceBeanRemote().getBookingsByPassenger("P005"));
            request.setAttribute("bookingsForFlight1", Controller.getDataQuerySerivceBeanRemote().getBookingsByFlight("BA001"));
            request.setAttribute("bookingsForFlight2", Controller.getDataQuerySerivceBeanRemote().getBookingsByFlight("VR001"));
            request.setAttribute("availableSeats", Controller.getDataQuerySerivceBeanRemote().getAvailableNoOfSeatsInAllFlights());
            request.setAttribute("availableAircrafts", Controller.getDataQuerySerivceBeanRemote().getAllUnallocatedAircrafts());
        }
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/manage.jsp");
        String action = request.getParameter("action");
        String type = request.getParameter("type");

        if (action.equals("create")) {
            switch (type) {
                //////////////////////////////////////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
                case "aircraft":
                    String aircraftid = request.getParameter("inputACID");
                    String manufacturer = request.getParameter("inputManufacturer");
                    String details = request.getParameter("inputDetails");
                    String capacity = request.getParameter("inputCapacity");

                    try {
                        AircraftDetails ad = new AircraftDetails(aircraftid, manufacturer, details, Short.parseShort(capacity));
                        Controller.getAirlineAdminServiceBeanRemote().createRecord(ad);
                        request.setAttribute("msg", "Aircraft Record sucessfully created");
                    } catch (Exception ex) {
                        request.setAttribute("msg", "Aircraft Record creation failed.");
                        Logger.getLogger("FrontController").log(Level.SEVERE, ex.getMessage());
                    }
                    request.setAttribute("aircrafts", Controller.getDataQuerySerivceBeanRemote().getListofAircrafts());
                    dispatcher = request.getRequestDispatcher("/Aircraft/list.jsp");
                    break;
                //////////////////////////////////////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\                    
                case "flight":
                    String fid = request.getParameter("inputFID");
                    String deptAirport = request.getParameter("inputDeptAirport");
                    String arrAirport = request.getParameter("inputArrAirport");
                    String deptTime = request.getParameter("inputDeptTime");
                    String arrTime = request.getParameter("inputArrTime");
                    String cap = request.getParameter("inputCapcity");
                    String aircraft = request.getParameter("inputAircraft");

                    try {
                        FlightDetails fd = new FlightDetails(fid, deptAirport, arrAirport,
                                (new SimpleDateFormat("dd/MM/yyyy hh:mm")).parse(deptTime),
                                (new SimpleDateFormat("dd/MM/yyyy hh:mm")).parse(arrTime),
                                Short.parseShort(cap), aircraft);
                        Controller.getAirlineAdminServiceBeanRemote().createRecord(fd);
                        request.setAttribute("msg", "Flight Record sucessfully created");
                    } catch (Exception ex) {
                        request.setAttribute("msg", "Flight Record creation failed.");
                        Logger.getLogger("FrontController").log(Level.SEVERE, ex.getMessage());
                    }

                    dispatcher = request.getRequestDispatcher("/flight/list.jsp");
                    request.setAttribute("flights", Controller.getDataQuerySerivceBeanRemote().getListofFilghts());
                    break;
                //////////////////////////////////////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\                    
                case "passenger":
                    String pid = request.getParameter("inputPID");
                    String fn = request.getParameter("inputFN");
                    String ln = request.getParameter("inputLN");

                    try {
                        PassengerDetails pd = new PassengerDetails(pid, fn, ln);
                        Controller.getAirlineAdminServiceBeanRemote().createRecord(pd);
                        request.setAttribute("msg", "Passenger Record sucessfully created");
                    } catch (Exception ex) {
                        request.setAttribute("msg", "Passenger Record creation failed.");
                        Logger.getLogger("FrontController").log(Level.SEVERE, ex.getMessage());
                    }
                    dispatcher = request.getRequestDispatcher("/passenger/list.jsp");
                    request.setAttribute("passengers", Controller.getDataQuerySerivceBeanRemote().getListofPassengers());
                    break;
                //////////////////////////////////////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
                case "booking":
                    String inputBID = request.getParameter("inputBID");
                    String inputPassenger = request.getParameter("inputPassenger");
                    String inputFlight = request.getParameter("inputFlight");

                    try {
                        BookingDetails bd = new BookingDetails(inputBID, inputPassenger, inputFlight);
                        String msg = Controller.getAirlineAdminServiceBeanRemote().placeABooking(bd);
                        request.setAttribute("msg", msg);
                    } catch (Exception ex) {
                        request.setAttribute("msg", "Error happened in remote server");
                        Logger.getLogger("FrontController").log(Level.SEVERE, ex.getMessage());
                    }

                    dispatcher = request.getRequestDispatcher("/booking/list.jsp");
                    request.setAttribute("bookings", Controller.getDataQuerySerivceBeanRemote().getListofBookings());
                    break;
            }
        } else if (action.equals("BookingService")) {
            String inputBID = request.getParameter("inputBID");
            String inputPassenger = request.getParameter("inputPassenger");
            String inputFlight = request.getParameter("inputFlight");

            Connection connection = null;
            Session session = null;
            MessageProducer messageProducer = null;
            ObjectMessage message = null;

            try {
                connection = connectionFactory.createConnection();
                session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
                messageProducer = session.createProducer(queue);
                message = session.createObjectMessage();

                BookingDetails bd = new BookingDetails(inputBID, inputPassenger, inputFlight);
                message.setObject(bd);
                messageProducer.send(message);


                log("See if the bean received the messages,");
                
            } catch (JMSException e) {
                log("Exception occurred: " + e.toString());

            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (JMSException ex) {
                }
            }

            dispatcher = request.getRequestDispatcher("/booking/list.jsp");
            request.setAttribute("bookings", Controller.getDataQuerySerivceBeanRemote().getListofBookings());
        }
        dispatcher.forward(request, response);
    }
}

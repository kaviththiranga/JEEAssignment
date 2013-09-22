<%-- 
    Document   : header
    Created on : Sep 20, 2013, 7:21:03 AM
    Author     : KavithThiranga
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Airline Web Client</title>
        <link href="<%=request.getContextPath()%>/includes/styles.css" rel="stylesheet"/>
        <link href="<%=request.getContextPath()%>/includes/css/font-awesome.css" rel="stylesheet"/>
        <link href="<%=request.getContextPath()%>/includes/bootstrap-datetimepicker.min.css" rel="stylesheet"/>
        <script type="text/javascript"  src="<%=request.getContextPath()%>/includes/jquery.js"></script>
        <script type="text/javascript"  src="<%=request.getContextPath()%>/includes/scripts.js"></script>
        <script type="text/javascript"  src="<%=request.getContextPath()%>/includes/bootstrap-datetimepicker.min.js"></script>
    </head>
    <body>
        <div id="mainbody" class="container">

            <div id="body row" class="row">
                <div class="span1"></div>
                <div id="body center" class="span10">
                    <div class="navbar">
                        <div class="navbar-inner">
                            <a class="brand" href="<%=request.getContextPath()%>/manage.jsp">Airline Service</a>
                            <ul class="nav">
                                <li><a href="<%=request.getContextPath()%>/manage.jsp">Manage</a></li>
                                <li><a href="<%=request.getContextPath()%>/booking.jsp">Place a Booking</a></li>
                                <li><a href="<%=request.getContextPath()%>/query.jsp">Query Information</a></li>
                            </ul>
                        </div>
                    </div>
                    <c:if test="${not empty msg}">

                        <div class="alert alert-info" style="margin-left: 30px;margin-right: 30px;">
                            <p><i class="icon-info-sign" style="margin-right: 5px;"></i>${msg}</p>
                        </div>
                    </c:if>





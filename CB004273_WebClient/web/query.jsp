<%@ include file="includes/header.jsp" %>
<div class="navbar">
    <div class="navbar-inner">
        <a class="brand" href="#">Airline Services</a>
        <ul class="nav">
            <li ><a href="<%=request.getContextPath()%>">Home</a></li>
            <li ><a href="<%=request.getContextPath()%>/manage.jsp">Manage</a></li>
            <li><a href="booking.jsp">Place a Booking</a></li>
            <li class="active"><a href="query.jsp">Query Information</a></li>
        </ul>
    </div>
</div>

<%@ include file="includes/footer.jsp" %>
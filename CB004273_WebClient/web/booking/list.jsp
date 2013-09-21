<%@ include file="/includes/header.jsp" %>
<div class="navbar">
    <div class="navbar-inner">
        <a class="brand" href="#">List of bookings</a>
        <ul class="nav">
            <li><a href="<%=request.getContextPath()%>">Home</a></li>
            <li><a href="<%=request.getContextPath()%>/manage.jsp">Manage</a></li>
            <li><a href="../booking.jsp">Place a Booking</a></li>
            <li><a href="../query.jsp">Query Information</a></li>
        </ul>
    </div>
</div>
<div class="well well-large">
    <table class="table table-condensed">
        <thead>
            <tr>
                <th>Booking No</th>
                <th>Passenger ID</th>
                <th>Flight ID</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="booking" items="${bookings}">
                <tr>
                    <td>${booking.bookingno}</td>
                    <td>${booking.passengerId}</td>
                    <td>${booking.flightId}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>  
<%@ include file="/includes/footer.jsp" %>
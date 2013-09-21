<%@ include file="/includes/header.jsp" %>
<div class="navbar">
    <div class="navbar-inner">
        <a class="brand" href="#">List of passengers</a>
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
                <th>Passenger ID</th>
                <th>First Name</th>
                <th>Last Name</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="passenger" items="${passengers}">
                <tr>
                    <td>${passenger.passengerid}</td>
                    <td>${passenger.fname}</td>
                    <td>${passenger.lname}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>  

<%@ include file="/includes/footer.jsp" %>
<%@ include file="/includes/header.jsp" %>
<div class="navbar">
    <div class="navbar-inner">
        <a class="brand" href="#">List of Aircraft</a>
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
                <th>Aircraft Id</th>
                <th>Manufacturer</th>
                <th>Details</th>
                <th>capacity</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="aircraft" items="${aircrafts}">
                <tr>
                    <td>${aircrafts.aircraftid}</td>
                    <td>${aircrafts.manufacturer}</td>
                    <td>${aircrafts.details}</td>
                    <td>${aircrafts.capacity}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    </div>       

<%@ include file="/includes/footer.jsp" %>
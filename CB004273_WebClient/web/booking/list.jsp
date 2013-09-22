<%@ include file="/includes/header.jsp" %>
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
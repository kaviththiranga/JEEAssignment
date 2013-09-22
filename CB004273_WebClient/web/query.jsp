<%@ include file="includes/header.jsp" %>
<div class="well well-large">
    <h4>Bookings by Passenger P005</h4>
    <table class="table table-condensed">
        <thead>
            <tr>
                <th>Booking No</th>
                <th>Flight ID</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="booking" items="${bookingsForPassengerP005}">
                <tr>
                    <td>${booking.bookingno}</td>
                    <td>${booking.flightId}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<div class="well well-large">
    <h4>Bookings by Flight BA001</h4>
    <table class="table table-condensed">
        <thead>
            <tr>
                <th>Booking No</th>
                <th>Passenger ID</th>
                <th>Flight ID</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="booking" items="${bookingsForFlight1}">
                <tr>
                    <td>${booking.bookingno}</td>
                    <td>${booking.passengerId}</td>
                    <td>${booking.flightId}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<div class="well well-large">
    <h4>Bookings by Flight VR001</h4>
    <table class="table table-condensed">
        <thead>
            <tr>
                <th>Booking No</th>
                <th>Passenger ID</th>
                <th>Flight ID</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="booking" items="${bookingsForFlight2}">
                <tr>
                    <td>${booking.bookingno}</td>
                    <td>${booking.passengerId}</td>
                    <td>${booking.flightId}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<div class="well well-large">
    <h4>Available Seats in All flights</h4>
    <table class="table table-condensed">
        <thead>
            <tr>
                <th>Flight No</th>
                <th>Available seats/th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="flight" items="${availableSeats}">
                <tr>
                    <td>${flight.key}</td>
                    <td>${flight.value}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<div class="well well-large">
    <h4>Available unallocated aircrafts</h4>
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
            <c:forEach var="aircraft" items="${availableAircrafts}">
                <tr>
                    <td>${aircraft.aircraftid}</td>
                    <td>${aircraft.manufacturer}</td>
                    <td>${aircraft.details}</td>
                    <td>${aircraft.capacity}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>  
<%@ include file="includes/footer.jsp" %>
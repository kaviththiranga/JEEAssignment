<%@ include file="/includes/header.jsp" %>

<div class="well well-large">
    <table class="table table-condensed">
        <thead>
            <tr>
                <th>Flight No</th>
                <th>Departure Airport</th
                <th>Arrival Airport</th>
                <th>Departure Time</th>
                <th>Arrival Time</th>
                <th>Capacity</th>
                <th>Aircraft ID</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="flight" items="${flights}">
                <tr>
                    <td>${flight.flightno}</td>
                    <td>${flight.deptairport}</td>
                    <td>${flight.arrairport}</td>
                    <td>${flight.depdate}</td>
                    <td>${flight.arrdate}</td>
                    <td>${flight.capacity}</td>
                    <td>${flight.aircraftId}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>  
<%@ include file="/includes/footer.jsp" %>
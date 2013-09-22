<%@ include file="/includes/header.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="well well-large">
    <table class="table table-condensed">
        <thead>
            <tr>
                <th>Flight No</th>
                <th>Departure Airport</th>
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
                    <td><fmt:formatDate value="${flight.depdate}" pattern="yy.MM.dd HH:mm" /></td>
                    <td><fmt:formatDate value="${flight.arrdate}" pattern="yy.MM.dd HH:mm" /></td>
                    <td>${flight.capacity}</td>
                    <td>${flight.aircraftId}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>  
<%@ include file="/includes/footer.jsp" %>
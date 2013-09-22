<%@ include file="/includes/header.jsp" %>
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
                    <td>${aircraft.aircraftid}</td>
                    <td>${aircraft.manufacturer}</td>
                    <td>${aircraft.details}</td>
                    <td>${aircraft.capacity}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    </div>       

<%@ include file="/includes/footer.jsp" %>
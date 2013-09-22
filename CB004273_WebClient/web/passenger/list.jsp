<%@ include file="/includes/header.jsp" %>
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
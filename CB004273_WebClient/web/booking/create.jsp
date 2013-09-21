<%@ include file="/includes/header.jsp" %>
<div class="navbar">
    <div class="navbar-inner">
        <a class="brand" href="#">Place a booking</a>
        <ul class="nav">
            <li><a href="<%=request.getContextPath()%>">Home</a></li>
            <li><a href="<%=request.getContextPath()%>/manage.jsp">Manage</a></li>
            <li><a href="../booking.jsp">Place a Booking</a></li>
            <li><a href="../query.jsp">Query Information</a></li>
        </ul>
    </div>
</div>
<div class="well well-large">
    <form class="form-horizontal" action="/do?action=create&type=booking" method="POST">
        <div class="control-group">
            <label class="control-label" for="inputBID">Booking No</label>
            <div class="controls">
                <input type="text" id="inputBID" placeholder="Booking No">
            </div>
        </div>   
        <div class="control-group">
            <label class="control-label" for="inputPassenger">Passenger</label>
            <div class="controls">
                <select name="inputPassenger">                    
                    <c:forEach var="passenger" items="${passengers}">

                        <option>${passenger.passengerid}</option>

                    </c:forEach>
                </select>
            </div>
        </div>

        <div class="control-group">
            <label class="control-label" for="inputFlight">Flight</label>
            <div class="controls">
                <select name="inputFlight">                    
                    <c:forEach var="flight" items="${flights}">

                        <option>${flight.flightno}</option>

                    </c:forEach>
                </select>
            </div>
        </div>
        
        <div class="control-group">
            <div class="controls">
                <button type="submit" class="btn">Create</button>
                <button type="reset" class="btn">Reset</button>
            </div>
        </div>
    </form>
</div>   
<%@ include file="/includes/footer.jsp" %>
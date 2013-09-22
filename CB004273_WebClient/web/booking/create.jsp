<%@ include file="/includes/header.jsp" %>

<div class="well well-large">
    <form class="form-horizontal" action="<%=request.getContextPath()%>/do?action=create&type=booking" method="POST">
        <div class="control-group">
            <label class="control-label" for="inputBID">Booking No</label>
            <div class="controls">
                <input type="text" name="inputBID" id="inputBID" placeholder="Booking No">
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
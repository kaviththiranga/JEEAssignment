<%@ include file="/includes/header.jsp" %>
<div class="navbar">
    <div class="navbar-inner">
        <a class="brand" href="#">Add a Passenger Record</a>
        <ul class="nav">
            <li><a href="<%=request.getContextPath()%>">Home</a></li>
            <li><a href="<%=request.getContextPath()%>/manage.jsp">Manage</a></li>
            <li><a href="../booking.jsp">Place a Booking</a></li>
            <li><a href="../query.jsp">Query Information</a></li>
        </ul>
    </div>
</div>
<div class="well well-large">
    <form class="form-horizontal" action="/do?action=create&type=passenger" method="POST">
        <div class="control-group">
            <label class="control-label" for="inputPID">Passenger Id</label>
            <div class="controls">
                <input type="text" id="inputPID" placeholder="Passenger Id">
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="inputFN">First Name</label>
            <div class="controls">
                <input type="text" id="inputFN" placeholder="First Name">
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="inputLN">Last Name</label>
            <div class="controls">
               <input type="text" id="inputLN" placeholder="Last Name">
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
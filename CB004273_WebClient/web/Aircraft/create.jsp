<%@ include file="/includes/header.jsp" %>
<div class="navbar">
    <div class="navbar-inner">
        <a class="brand" href="#">Add an Aircraft</a>
        <ul class="nav">
            <li><a href="<%=request.getContextPath()%>">Home</a></li>
            <li><a href="<%=request.getContextPath()%>/manage.jsp">Manage</a></li>
            <li><a href="../booking.jsp">Place a Booking</a></li>
            <li><a href="../query.jsp">Query Information</a></li>
        </ul>
    </div>
</div>
<div class="well well-large">
    <form class="form-horizontal" action="/do?action=create&type=aircraft" method="POST">
        <div class="control-group">
            <label class="control-label" for="inputACID">Aircraft ID</label>
            <div class="controls">
                <input type="text" id="inputACID" placeholder="Aircraft ID">
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="inputManufacturer">Manufacturer</label>
            <div class="controls">
                <input type="text" id="inputManufacturer" placeholder="Manufacturer">
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="inputDetails">Details</label>
            <div class="controls">
               <textarea rows="4" cols="20" id="inputDetails" >
                </textarea>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="inputCapacity">Capacity</label>
            <div class="controls">
               <input type="text" id="inputCapacity" placeholder="Capacity">
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
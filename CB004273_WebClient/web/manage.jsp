<%@ include file="includes/header.jsp" %>
<div class="navbar">
    <div class="navbar-inner">
        <a class="brand" href="#">Airline Services</a>
        <ul class="nav">
            <li ><a href="<%=request.getContextPath()%>">Home</a></li>
            <li class="active"><a href="<%=request.getContextPath()%>/manage.jsp">Manage</a></li>
            <li><a href="booking.jsp">Place a Booking</a></li>
            <li><a href="query.jsp">Query Information</a></li>
        </ul>
    </div>
</div>
<div class="span4 well">
    <ul class="nav nav-list">
        <li class="nav-header">Manage Aircrafts</li>
        <li><a href="<%=request.getContextPath()%>/do?action=create&type=aircraft">Create</a></li>
        <li><a href="<%=request.getContextPath()%>/do?action=list&type=aircraft">List</a></li>
        <li class="nav-header">Manage Flights</li>
        <li><a href="<%=request.getContextPath()%>/do?action=create&type=flight">Create</a></li>
        <li><a href="<%=request.getContextPath()%>/do?action=list&type=flight">List</a></li>
        <li class="nav-header">Manage Passengers</li>
        <li><a href="<%=request.getContextPath()%>/do?action=create&type=passenger">Create</a></li>
        <li><a href="<%=request.getContextPath()%>/do?action=list&type=passenger">List</a></li>
        <li class="nav-header">Manage Bookings</li>
        <li><a href="<%=request.getContextPath()%>/do?action=create&type=booking">Create</a></li>
        <li><a href="<%=request.getContextPath()%>/do?action=list&type=booking">List</a></li>
    </ul>
</div>
<div class="span4 well"></div>

<%@ include file="includes/footer.jsp" %>
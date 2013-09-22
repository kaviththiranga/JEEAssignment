<%@ include file="includes/header.jsp" %>
<div class="row">
    <div class="span4 well">
        <ul class="nav nav-list">
            <li class="nav-header">Manage Aircrafts</li>
            <li><a href="<%=request.getContextPath()%>/do?action=create&type=aircraft">Create</a></li>
            <li><a href="<%=request.getContextPath()%>/do?action=list&type=aircraft">List</a></li>
        </ul>
    </div>
    <div class="span4 well">
        <ul class="nav nav-list">
            <li class="nav-header">Manage Flights</li>
            <li><a href="<%=request.getContextPath()%>/do?action=create&type=flight">Create</a></li>
            <li><a href="<%=request.getContextPath()%>/do?action=list&type=flight">List</a></li>
        </ul>
    </div>
</div>
<div class="row">
    <div class="span4 well">
        <ul class="nav nav-list">
            <li class="nav-header">Manage Passengers</li>
            <li><a href="<%=request.getContextPath()%>/do?action=create&type=passenger">Create</a></li>
            <li><a href="<%=request.getContextPath()%>/do?action=list&type=passenger">List</a></li>
        </ul>
    </div>
    <div class="span4 well">
        <ul class="nav nav-list">
            <li class="nav-header">Manage Bookings</li>
            <li><a href="<%=request.getContextPath()%>/do?action=create&type=booking">Create</a></li>
            <li><a href="<%=request.getContextPath()%>/do?action=list&type=booking">List</a></li>
        </ul>
    </div>
</div>
<%@ include file="includes/footer.jsp" %>
<%@ include file="/includes/header.jsp" %>
<div class="navbar">
    <div class="navbar-inner">
        <a class="brand" href="#">Schedule a flight</a>
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
            <label class="control-label" for="inputFID">Flight ID</label>
            <div class="controls">
                <input type="text" id="inputFID" placeholder="Flight ID">
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="inputDeptAirport">Departure Airport</label>
            <div class="controls">
                <input type="text" id="inputDeptAirport" placeholder="Departure Airport">
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="inputArrAirport">Arriving Airport</label>
            <div class="controls">
                <input type="text" id="inputArrAirport" placeholder="Arriving Airport">
            </div>
        </div>
         <div class="control-group">
            <label class="control-label" for="inputDeptTime">Departure Time</label>
            <div class="controls">
                <div id="datetimepicker1" class="input-append date">
                    <input id="inputDeptTime" placeholder="Click on calender icon ->" data-format="dd/MM/yyyy hh:mm" type="text"></input>
                    <span class="add-on">
                        <i data-time-icon="icon-time" data-date-icon="icon-calendar">
                        </i>
                    </span>
                </div>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="inputArrTime">Arriving Time</label>
            <div class="controls">
                <div id="datetimepicker2" class="input-append date">
                    <input id="inputArrTime"  placeholder="Click on calender icon ->" data-format="dd/MM/yyyy hh:mm" type="text"></input>
                    <span class="add-on">
                        <i data-time-icon="icon-time" data-date-icon="icon-calendar">
                        </i>
                    </span>
                </div>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="inputArrTime">Arriving Time</label>
            <div class="controls">
                <select name="flightaircraft">                    
                    <c:forEach var="aircraft" items="${aircrafts}">

                        <option>${aircraft}</option>

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
<script type="text/javascript">
  $(function() {
    $('#datetimepicker1').datetimepicker({
      language: 'pt-BR'
    });
  });
</script>
<script type="text/javascript">
  $(function() {
    $('#datetimepicker2').datetimepicker({
      language: 'pt-BR'
    });
  });
</script>
<%@ include file="/includes/footer.jsp" %>
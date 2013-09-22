<%@ include file="/includes/header.jsp" %>
<div class="well well-large">
    <form class="form-horizontal" action="<%=request.getContextPath()%>/do?action=create&type=passenger" method="POST">
        <div class="control-group">
            <label class="control-label" for="inputPID">Passenger Id</label>
            <div class="controls">
                <input type="text" name="inputPID" placeholder="Passenger Id">
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="inputFN">First Name</label>
            <div class="controls">
                <input type="text" name="inputFN" placeholder="First Name">
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="inputLN">Last Name</label>
            <div class="controls">
               <input type="text" name="inputLN" placeholder="Last Name">
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
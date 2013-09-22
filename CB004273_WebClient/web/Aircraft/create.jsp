<%@ include file="/includes/header.jsp" %>
<div class="well well-large">
    <form class="form-horizontal" action="<%=request.getContextPath()%>/do?action=create&type=aircraft" method="POST">
        <div class="control-group">
            <label class="control-label" for="inputACID">Aircraft ID</label>
            <div class="controls">
                <input type="text" name="inputACID" id="inputACID" placeholder="Aircraft ID">
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="inputManufacturer">Manufacturer</label>
            <div class="controls">
                <input type="text" name="inputManufacturer" id="inputManufacturer" placeholder="Manufacturer">
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="inputDetails">Details</label>
            <div class="controls">
               <textarea rows="4" name="inputDetails" cols="20" id="inputDetails" ></textarea>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="inputCapacity">Capacity</label>
            <div class="controls">
               <input name="inputCapacity"  type="text" id="inputCapacity" placeholder="Capacity">
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
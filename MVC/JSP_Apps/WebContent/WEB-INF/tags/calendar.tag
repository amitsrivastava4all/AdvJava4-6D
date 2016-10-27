<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="txtName"  type="java.lang.String" required="true" %>
<%@ attribute name="noofmonth" type="java.lang.Integer" required="true" %>
<script>
  $( function() {
    $( "#${txtName}" ).datepicker({
      numberOfMonths: ${noofmonth},
      showButtonPanel: true
    });
  } );
  </script>
  <input type='text' id='${txtName}'/>

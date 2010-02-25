<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>

<script type="text/javascript">
function displaymessage()
{
	alert("123");
	document.listItemsForm.action="/sim/deleteItems";
}
</script>

<html>
	<body>List Items</body>
	<%
    Class.forName("com.mysql.jdbc.Driver"); 
    String url = "jdbc:mysql://mysql.nirmalya.net/db1"; 
    Connection conn = DriverManager.getConnection(url,"sandeepr","sandeep");
    String query = "SELECT itemId, displayName, description FROM au_simuniv";
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery(query);
    %>
    <form method="post" action="/sim/updateItem" name="listItemsForm">
    	
	    <table border="1">
	    <%
	    while (rs.next()) {
			%>
			<tr>
				<td><%=rs.getInt("itemId") %></td>
				<td><%=rs.getString("displayName") %></td>
				<td><%=rs.getString("description") %></td>
				<td><input type="checkbox" name="itemIdSelected" value="<%=rs.getInt("itemId") %>"/></td>
			</tr>
	<%
	    	}
		%>
		</table>
		<input type="submit" value="delete selected" onClick="displaymessage()"/>		
		<input type="submit" value="modify selected"/>
	</form>
</html>

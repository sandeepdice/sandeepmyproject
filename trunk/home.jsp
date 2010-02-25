<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>

<html>
	<%
    Class.forName("com.mysql.jdbc.Driver"); 
    String url = "jdbc:mysql://mysql.nirmalya.net/db1"; 
    Connection conn = DriverManager.getConnection(url,"sandeepr","sandeep");
    String query = "SELECT itemId, displayName, description FROM au_simuniv";
    Statement stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery(query);
    %>
    <table>
    <%
    while (rs.next()) {
		%>
		<tr>
			<td><%=rs.getInt("itemId") %></td>
			<td><%=rs.getString("displayName") %></td>
			<td><%=rs.getString("description") %></td>
		</tr>
<%
    	}
	%>
	</table>
	
	<form method="post" action="/sim/addItem">
		itemId: <input type="text" name="itemId"/>
		displayName: <input type="text" name="displayName"/>
		description: <input type="text" name="description"/>
		<input type="submit"/>
	</form>
	
	<a href="<%=request.getContextPath()%>/listItems">List Items</a>
	
</html>

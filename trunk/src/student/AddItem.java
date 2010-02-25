package student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddItem extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String itemId = req.getParameter("itemId");
		String description = req.getParameter("description");
		String displayName = req.getParameter("displayName");
		
	    try {
			Class.forName("com.mysql.jdbc.Driver"); 
			String url = "jdbc:mysql://mysql.nirmalya.net/db1"; 
			Connection conn = DriverManager.getConnection(url,"sandeepr","sandeep");
			String query = "SELECT itemId, displayName, description FROM au_simuniv";
			PreparedStatement stmt = conn.prepareStatement("insert into au_simuniv values (?, ?, ?)");
			stmt.setInt(1, Integer.parseInt(itemId));
			stmt.setString(2, displayName);
			stmt.setString(3, description);
			int rowsUpdated = stmt.executeUpdate();
			System.out.println("rows updated:" + rowsUpdated);
			resp.sendRedirect(resp.encodeRedirectURL("/sim/home.jsp"));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

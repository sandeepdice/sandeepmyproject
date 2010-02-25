package student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteItems extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		PreparedStatement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			String url = "jdbc:mysql://mysql.nirmalya.net/db1"; 
			Connection conn = DriverManager.getConnection(url,"sandeepr","sandeep");
			stmt = conn.prepareStatement("delete from au_simuniv where itemId=?");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
        String[] paramValues = req.getParameterValues("itemIdSelected");
        for(String paramValue : paramValues)
        {
		    try {
				stmt.setInt(1, Integer.parseInt(paramValue));
				int rowsUpdated = stmt.executeUpdate();
				System.out.println("rows updated:" + rowsUpdated);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
	    resp.sendRedirect(resp.encodeRedirectURL("/sim/listItems.jsp"));
	}
}

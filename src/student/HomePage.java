package student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomePage extends HttpServlet {
	@Override
	  public void doGet (HttpServletRequest req,
              HttpServletResponse res)
		throws ServletException, IOException
		{
////			/*
//			PrintWriter out = res.getWriter();
//			
//			out.println("Hello, world!");
//			out.close(); 
////			*/
//	      try {
//			Class.forName("com.mysql.jdbc.Driver");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
//	      // Step 2: Establish the connection to the database. 
//	      String url = "jdbc:mysql://mysql.nirmalya.net/db1"; 
//	      try {
//			Connection conn = DriverManager.getConnection(url,"sandeepr","sandeep");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}  		
		System.out.println("redircting...");
		System.out.println("encodeurl: "+res.encodeRedirectURL("/sim/home.jsp"));
	    res.sendRedirect(res.encodeRedirectURL("/sim/home.jsp"));
		}
}

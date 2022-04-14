package Hrc;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Statement;

/**
 * Servlet implementation class delete_Servlet
 */
@WebServlet("/deleteServlet")
public class delete_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delete_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    static String url ="jdbc:mysql://localhost:3306/grey_goose";
	  static String user = "root";
	  static  String pass ="rohit";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		


		String sl_no=request.getParameter("sl_no");
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con1 = null;
			
			con1 = DriverManager.getConnection(url,user,pass);
			
			String Query="Delete FROM winter_internship where sl_no= "+ sl_no;
			System.out.print(Query);
			Statement st=con1.createStatement();
			st.executeUpdate(Query);
		
		
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
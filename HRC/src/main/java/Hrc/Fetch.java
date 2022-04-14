package Hrc;
import javax.servlet.http.HttpServlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;



@WebServlet("/FetchServlet")
public class Fetch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Fetch() {
        super();
        // TODO Auto-generated constructor stub
    }
    static String url ="jdbc:mysql://localhost:3306/grey_goose";
	  static String user = "root";
	  static  String pass ="rohit"; 
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ConcurrentModificationException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		List<Pojo> customer = new ArrayList<>();
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = null;
		
		con = DriverManager.getConnection(url,user,pass);
		
		String Query="SELECT * FROM winter_internship";
		Statement st;
	
		st = con.createStatement();
		
		ResultSet rs=st.executeQuery(Query);
			
			while (rs.next()) {
				
				Pojo cus =new Pojo();
				cus.setSl_no(rs.getInt(1));
				cus.setBusiness_code(rs.getString("business_code"));
				cus.setCust_number( rs.getInt("cust_number"));
				cus.setClear_date(rs.getString("clear_date"));
				cus.setBuisness_year(rs.getInt("buisness_year"));
				cus.setDoc_id( rs.getString("doc_id"));
				cus.setPosting_date(rs.getString("posting_date"));
				cus.setDocument_create_date(rs.getString("document_create_date"));
				cus.setDue_in_date(rs.getString("due_in_date"));
				cus.setInvoice_currency(rs.getString("invoice_currency")); 
				cus.setDocument_type( rs.getString("document_type"));
				cus.setPosting_id( rs.getInt("posting_id"));
				cus.setTotal_open_amount(rs.getDouble("total_open_amount"));
				cus.setBaseline_create_date(rs.getString("baseline_create_date"));
				cus.setCust_payment_terms(rs.getString("cust_payment_terms"));
				cus.setInvoice_id(rs.getInt("invoice_id"));
				cus.setIsOpen(rs.getInt("isOpen"));
				customer.add(cus);
				
			}
				Gson gson= new GsonBuilder().setPrettyPrinting().create();
				String jsonString=gson.toJson(customer);
				
				response.setContentType("application/json");
				response.getWriter().append(jsonString);
				response.setHeader("Access-Control-Allow-Origin", "*");
				
				
			
		}catch(SQLException | ClassNotFoundException e){
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

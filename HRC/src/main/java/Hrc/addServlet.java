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
 * Servlet implementation class insert_Servlet
 */
@WebServlet("/addServlet")
public class addServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addServlet() {
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
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = null;
			con = DriverManager.getConnection(url,user,pass);
			Statement st=con.createStatement();
	
					
			String a1=request.getParameter("business_code");   //business_code
			String a2=request.getParameter("cust_number");	//cust_number
			String a3=request.getParameter("clear_date");	//clear_date
			String a4=request.getParameter("buisness_year");	//buisness_year
			String a5=request.getParameter("doc_id");   //doc_id
			String a6=request.getParameter("posting_date");	//posting_date
			String a7=request.getParameter("document_create_date");	//document_create_date			
			String a8=request.getParameter("due_in_date");	//due_in_date
			String a9=request.getParameter("invoice_currency");   //invoice_currency
			String a10=request.getParameter("doc_type");	//doc_type
			String a11=request.getParameter("posting_id");	//positng_id
			String a12=request.getParameter("total_open_amount");	//total_open_amount
			String a13=request.getParameter("baseline_create_date"); //baseline_create_date
			String a14=request.getParameter("cust_payment_terms");	//cust_payment_terms
			String a15=request.getParameter("invoice_id");	//invoice_id
			//String a16=request.getParameter("p16");	//is_open
				
				
					
			String Insert_query = "INSERT INTO WINTER_INTERNSHIP (business_code,cust_number,clear_date,buisness_year,doc_id,posting_date,document_create_date,due_in_date,invoice_currency,document_type,posting_id,total_open_amount,baseline_create_date,cust_payment_terms,invoice_id) VALUES('"+a1+"','"+a2+"','"+a3+"','"+a4+"','"+a5+"','"+a6+"','"+a7+"',"+ "'"+a8+"','"+a9+"','"+a10+"','"+a11+"',"+ "'"+a12+"','"+a13+"','"+a14+"','"+a15+"')";
			int rs= st.executeUpdate(Insert_query);
			System.out.print(Insert_query);
			System.out.println(rs);
			
		} catch (SQLException | ClassNotFoundException e) {
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
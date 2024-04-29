

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class profile
 */
@WebServlet("/Profile")
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    public Profile() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}


	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		

		response.setContentType("text/html");
		
		PrintWriter pw = response.getWriter();
		
		HttpSession session = request.getSession(false);
		
		if(session == null) {
			response.sendRedirect("login.jsp");	
		}
		try {
			
			Connection con = ConnectDB.connect();
			String fetch_students = "select * from student";
			String count_student = "select count(*) from student";

			PreparedStatement pst = con.prepareStatement(fetch_students);
			ResultSet rs = pst.executeQuery();
			
			PreparedStatement pst2 = con.prepareStatement(count_student);
			ResultSet rs2 = pst2.executeQuery();
			rs2.next();
		
			
			pw.print(  "<html>"
					+ "<head><title> Profile </title>"
					+ "<style>"
					     +"td,th{padding:14px 30px;}"
					     + "body {font-family:arial; background-image: url('web6.jpg');}"
					     + "table{border:1px solid black; padding:20px;}"
					     + "a {text-decoration:none; border:1px solid black; padding:10px 10px;}"
					     + "a:hover{color:red;}"
					    + " table {"
					    + "   width: 100%;"
					    + "   border-collapse: collapse;}"

					    + " table, th, td { border: 1px solid black;}"
					    + " th, td { padding: 8px; text-align: left;}"

                        + "  tr:nth-child(even) { background-color: #f2f2f2;}"

                        + " 	th {background-color: #4CAF50; color: white;}"
					 + "</style>"
					 + "</head>"
					 
					 + "<body>"
					 + "<center>"
					
					 + "<br>"
					
					
                   +"<div style='clear:both;'></div><div style='float:right;'><a href='OperationForm?Id=Add'>Add Student</a>"
					 
					 +"<a href='Logout' style='margin-left:10px;'>Log Out</a></div>"
					 
					 +"<br><br><br>"
					 
					
					+"<div style='clear:both'><h2>Student Detail</h2>"
					
					);
			if( session.getAttribute("role") == null){
				response.sendRedirect("login.jsp");
			}

			pw.print("<table margin-top:-80px;><tr><th>Id</th>"
					+ "<th>student</th>"
					
					+ "<th>BOD</th>"
					+ "<th>Gender</th>"
					+ "<th>phone</th>"
				
					+ "<th>update</th>"
					+ "<th>delete</th></tr>");
			while(rs.next()) {
				pw.print("<tr><td>"+ rs.getInt(1)+"</td>"
						
						+ "<td>"+ rs.getString(2) +"</td>"
						+ "<td>"+ rs.getString(3) +"</td>"
						+ "<td>"+ rs.getString(4) +"</td>"
						+ "<td>"+ rs.getString(5) +"</td>"
					
						
                        + "<td> <a href='OperationForm?Id="+ rs.getInt(1) +"'>Update</a></td>"
                        
                        + "<td> <a href='OperationWithDatabase?OperationType=Delete&Id="+ rs.getInt(1) +"'>Delete</a></td>"
                        +"</tr> <br><br>"
						);
				
			}
			pw.print("</table></div></body></html>");
			con.close();
				
					 
		} catch (Exception ex) {
			pw.print(ex);
		}
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

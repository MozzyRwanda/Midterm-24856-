

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
 * Servlet implementation class OperationForm
 */
@WebServlet("/OperationForm")
public class OperationForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OperationForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
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
		Connection con = ConnectDB.connect();
		
		try {
			String fetch_students = "select * from student";
		    String count_student ="select count(*) from student";
		    PreparedStatement pst = con.prepareStatement(fetch_students);
		    ResultSet rs = pst.executeQuery(fetch_students);
		    
		    PreparedStatement pst2 = con.prepareStatement(count_student);
		    ResultSet rs2 = pst2.executeQuery(count_student);
		    rs2.next();
		    
		   
		    pw.print("<html>"
		    		+ "<head><title> Operation form</title>"
		    		
                 + "<style>"
                    +"td,th{padding:10px 10px;}"
                    + "body {font-family:arial; background-image: url('web6.jpg');}"
                    + "table{border:1px solid black; padding:20px;}"
                    + "a {text-decoration:none; border:1px solid black; padding:10px 10px;}"
                    + "a:hover{color:red;}"
                    
                     + " body { font-family: Arial, sans-serif; background-color: #f4f4f4;margin: 0; padding: 0; display: flex;justify-content: center; align-items: center;"
                     + " height: 100vh;}"
                      
                      + ".container {"
                      + " background-color: #fff;"
                        + " padding: 40px;"
                        + " border-radius: 8px;"
                         + "box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);"
                         + "text-align: center;"
                         + "max-width: 400px;"
                         + "width: 100%;}"

                         + " h2 { margin-bottom: 20px; }"

               + " input[type='text'], input[type='password'],"
            	+ "select { width: calc(100% - 20px);padding: 10px;margin: 8px 0;border: 1px solid #ccc; border-radius: 4px;box-sizing: border-box;}"

            + "button {background-color: #4caf50;color: white; padding: 14px 20px;margin: 8px 0;border: none;border-radius: 4px;cursor: pointer;width: 100%;}"

            + " button:hover {background-color: #45a049;}"

             + " .signup-link {margin-top: 20px;font-size: 14px;}"

                 + "</style>"
                 + "</head>"
               
		    		);
		    if( session.getAttribute("role") == null){
				response.sendRedirect("login.jsp");
			}

		    
		    pw.print("<body>"
		    		+"<div class='container'>"
		    		+"<div style='clear:both;'></div><div style='float:right;'><a href='Profile'>view Student</a>"
					 
					 +"<a href='Logout' style='margin-left:10px;'>Log Out</a></div>"
 +"<br><br><br>"
					 
					+"<br><br><br>"
					+"<br><br><br>"
					 
					+"<br><br><br>"
					 + "</div>"
		    		+ "<center>"
					
					 + "<br>"
                     
					 
					
		    		);
		    
		    String Id = request.getParameter("Id");
		    String Sname, enrollment,gender, phone;
		    ResultSet rs4 =null;
		    
		    if(Id.equals("Add")) {
		    

					
		    			
		  
		    	pw.print("<div class='container'>"
		    			+ "<h1> Add new student</h1>");
		    	pw.print("<form action='Add' method='post' id='signin-form'>"
		    			+ "<table>"
		    			   + "<tr>"
		    			     + "<td> student Name</td>"
		    			     + "<td><input type='text' name='sname' placeholder='Student name'></td>"
		    			    + "</tr>"
		    			    
		    			
		    			    
		    			   + "<tr>"
		    			     + "<td> Data of birth</td>"
		    			     + "<td><input type='date' name='bod'></td>"
		    			    + "</tr>"
		    			   
		    			   + "<tr>"
		    			     + "<td> Gender</td>"
		    			     + "<td><input type='radio' name='gender' value='Male'>Male"
		    			     + " <input type='radio' name='gender' value='Female'>Female </td>"
		    			    + "</tr>"
		    			   
                            + "<tr>"
                               + "<td> Phone</td>"
                                + "<td><input type='text' name='phone' placeholder='Phone no'></td>"
                             + "</tr>"
                             
                          
                           
                         + "<tr>"
                           + "<input type='hidden' value='Add' name='OperationType'>"
                           + "<td><input type='submit' value='Add' class='btn'></td>"
                         + "</tr>"
                         + "</table></form>"
                         + ""
                         + "</div></center>" 
                           
		    			);
		    }
		    else {
		    	pw.print("<h1>Update Student Id = "+ Id +"</h1>");
		    	
		    	String q = "select * from student where id ="+Integer.parseInt(Id)+"";
		    	PreparedStatement pst1= con.prepareStatement(q);
		    	rs4 = pst1.executeQuery();
		    	rs4.next();
		    	
		    	pw.print("<form action='UpdateServlet' method='post'>"
		    			+ "<table>"
		    			   + "<tr>"
		    			     + "<td> student Name</td>"
		    			     + "<td><input type='text' name='sname' placeholder='Student name' value='"+rs4.getString(2) +"'></td>"
		    			    + "</tr>"
		    			    
		    			 
		    			    
		    			   + "<tr>"
		    			     + "<td> Data of birth</td>"
		    			     + "<td><input type='date' name='bod' value='"+rs4.getString(3) +"'></td>"
		    			    + "</tr>"
		    	
		    			   + "<tr>"
		    			     + "<td> Gender</td>"
		    			   );
		    	 if(rs4.getString(4).equals("Male")) {
 			    	pw.print("<td><input type='radio' name='gender' value='Male' checked>Male"
 			    			+ "<input type='radio' name='gender' value='Female'>Female </td>");
 			    }
		    	 else {
		    		 pw.print("<td><input type='radio' name='gender' value='Male' >Male"
	 			    			+ "<input type='radio' name='gender' value='Female' checked>Female </td>");
	 			  
		    	 }
		    	 pw.print("</tr>"
		    			 
                         + "<tr>"
                         + "<td> Phone</td>"
                          + "<td><input type='text' name='phone' placeholder='Phone no' value='"+rs4.getString(5) +"'></td>"
                       + "</tr>"
		    			 );
		    
		    	 pw.print("<tr>"
                           + "<input type='hidden' value='Update' name='OperationType'>"
                           + "<input type='hidden' value='"+rs4.getString("Id")+"' name='Id'>"
                           + "<td><input type='submit' value='Update' class='btn'> </td>"
                         + "</tr>"
                         + "</table></form>" 
                           
		    			);
		    	 
		    }
		    pw.print("</center></body></html>");
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

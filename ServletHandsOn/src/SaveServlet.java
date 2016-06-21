

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	
	private static final long serialVersionUID = -8836780490863351377L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("name");
		String gender=request.getParameter("gender");
		String email=request.getParameter("email");
		String country=request.getParameter("country");
		
		Emp e=new Emp();
		e.setName(name);
		e.setGender(gender);
		e.setEmail(email);
		e.setCountry(country);
		
		boolean status=EmpDao.save(e);
		if(status){
			out.print("<p>Record saved successfully!</p>");
			request.getRequestDispatcher("index.html").include(request, response);
		}else{
			out.println("Sorry! unable to save record");
		}
		
		out.close();
	}

}



import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/login")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public loginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if((username != null && username.equals("Sudhanshu"))
				&& (password != null && password.equals("123"))) {
			HttpSession session = request.getSession();
			session.setAttribute("isloggedin", true);
			session.setAttribute("username", username);
			response.sendRedirect("dashboard");
		}
		else {
			PrintWriter out = response.getWriter();
			out.print("<html> <body>");
			out.print("Invalid Credentials");
			out.print("<form action = 'login' method = 'POST'<br> ");
			out.print("username : <input type=\"text\" name = \"username\"/>");
			out.print("password : <input type=\"text\" name = \"password\"/>");
			out.print("<button type= \"submit\"> login </button>");
			out.print("</form>");
			out.print("</body> </html>");
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

package GameWeb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GameServlet
 */
public class GameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        //String firstName = request.getParameter("firstName").toString();
	        //String surname = request.getParameter("surname").toString();
	        String vals = request.getParameter("Vals").toString();
	        out.println("<html>");
	        out.println("<head>");
	        out.println("<title>Servlet GreetingServlet</title>");
	        out.println("</head>");
	        out.println("<body>");
	        out.println("<h1>Servlet GreetingServlet at " + request.getContextPath () + "</h1>");
	        //out.println("<p>Welcome " + firstName + " " + surname + "</p>");
	        out.println("<p>Hello " + vals + "</p>");
	        out.println("</body>");
	        out.println("</html>");

	        out.close();
	}

}

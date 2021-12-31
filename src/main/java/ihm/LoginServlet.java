package ihm;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bll.TableManager;
import bo.Table;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			
		if (request.getParameter("login")!=null)
		{
			String login = request.getParameter("login");
			String mdp = request.getParameter("mdp");
			
			System.out.println(login +" "+mdp);
			
			try {
				Class.forName("com.mysql.jdbc.Driver");    
				
				boolean permission = TableManager.authentifier(login,mdp);
				System.out.println("............................................"+permission);
				if (!permission)
				{
					request.setAttribute("erreur","Utilisateur introuvable !");
					request.setAttribute("login", "");
					request.setAttribute("mdp", "");
				}
				else
				{
					HttpSession session = request.getSession();
					session.setAttribute("login",login);
					session.setAttribute("mdp",mdp);
					request.setAttribute("erreur","Authentification correcte");
					
					ApplicationServlet as = new ApplicationServlet();
					as.doGet(request, response);
				}
			} catch (Exception e) {
				request.setAttribute("erreur",e.getMessage());
			}
				
		}
				
		request.getRequestDispatcher("WEB-INF/LoginPage.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

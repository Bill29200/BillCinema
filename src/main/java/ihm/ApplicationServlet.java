package ihm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import bll.TableManager;
import bo.Table;

/**
 * Servlet implementation class ApplicationServlet
 */
@WebServlet("")
public class ApplicationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplicationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("valider")!=null)
		{
			try {
				Class.forName("com.mysql.jdbc.Driver");     
				TableManager.initList(request.getParameter("nomTable"));
				List<Table> listTable=TableManager.getList();
				
				//Model model=new Model(request.getParameter("nomTable"));
				request.setAttribute("nomTable",request.getParameter("nomTable"));
				//request.setAttribute("nomColones",listTable.get(0).getColonnes());
				request.setAttribute("donnees",listTable);
			} catch (Exception e) {
				request.setAttribute("tableErreur",e.getMessage());
			}
			
		}
		request.getRequestDispatcher("WEB-INF/table.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

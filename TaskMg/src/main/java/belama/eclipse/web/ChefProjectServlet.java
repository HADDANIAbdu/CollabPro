package belama.eclipse.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import belama.eclipse.model.ChefProject;
import belama.eclipse.dao.connecteDB;

@WebServlet("/")
public class ChefProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private connecteDB conn;
	
	public void init() {
		conn = new connecteDB();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertChefProject(request, response);
				break;
			case "/delete":
				deleteChefProject(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateChefProject(request, response);
				break;
			default:
				listChefProject(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listChefProject(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<ChefProject> listChef_pr = conn.selectAllChefProjects();
		request.setAttribute("listChefProject", listChef_pr);
		RequestDispatcher dispatcher = request.getRequestDispatcher("chefproject-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("chefproject-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		ChefProject existingChef_pr = conn.selectChefProject(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("chefproject-form.jsp");
		request.setAttribute("Chef_pr", existingChef_pr);
		dispatcher.forward(request, response);

	}

	private void insertChefProject(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		String department = request.getParameter("department");
		ChefProject newChef_pr = new ChefProject(name, email, country, department);
		conn.insertChefProject(newChef_pr);
		response.sendRedirect("list");
	}

	private void updateChefProject(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		String department = request.getParameter("department");
		ChefProject Chef_pr = new ChefProject(id, name, email, country, department);
		conn.updateChefProject(Chef_pr);
		response.sendRedirect("list");
	}

	private void deleteChefProject(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		conn.deleteChefProject(id);
		response.sendRedirect("list");

	}
}

package belama.eclipse.web;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import belama.eclipse.model.Project;
import belama.eclipse.dao.connecteDB;

@WebServlet(urlPatterns = {"/projects","/new_pr","/insert_pr","/delete_pr","/edit_pr","/update_pr"})
public class ProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private connecteDB conn;
	
	public void init() {
		conn = new connecteDB();
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String action = req.getServletPath();

		try {
			switch (action) {
			case "/new_pr":
				showNewPrForm(req, resp);
				break;
			case "/insert_pr":
				insertProject(req, resp);
				break;
			case "/delete_pr":
				deleteProject(req, resp);
				break;
			case "/edit_pr":
				showEditPrForm(req, resp);
				break;
			case "/update_pr":
				updateProject(req, resp);
				break;
			default:
				listProject(req, resp);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void listProject(HttpServletRequest req, HttpServletResponse resp)
			throws SQLException, IOException, ServletException {
		List<Project> listProject = conn.selectAllProjects();
		req.setAttribute("listProject", listProject);
		RequestDispatcher dispatcher = req.getRequestDispatcher("project-list.jsp");
		dispatcher.forward(req, resp);
	}

	private void showNewPrForm(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("project-form.jsp");
		dispatcher.forward(req, resp);
	}

	private void showEditPrForm(HttpServletRequest req, HttpServletResponse resp)
			throws SQLException, ServletException, IOException {
		int pr_id = Integer.parseInt(req.getParameter("pr_id"));
		Project existingProject = conn.selectProject(pr_id);
		RequestDispatcher dispatcher = req.getRequestDispatcher("project-form.jsp");
		req.setAttribute("project", existingProject);
		dispatcher.forward(req, resp);
	}

	private void insertProject(HttpServletRequest req, HttpServletResponse resp) 
			throws SQLException, IOException, ParseException {
		int chef_id = Integer.parseInt(req.getParameter("chef_id"));
		String title = req.getParameter("title");
		String description = req.getParameter("description");
		String start_str = req.getParameter("start_date");
		System.out.println(start_str);
		String end_str = req.getParameter("end_date");
		System.out.println(end_str);
		Date start_date = null;
		Date end_date = null;
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			start_date = dateFormat.parse(start_str);
			end_date = dateFormat.parse(end_str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if(end_date == null){System.out.println("noooooooooone");}
		else {System.out.println("maydyaghn mayk");}
		int duration = Integer.parseInt(req.getParameter("duration"));
		Project new_pr = new Project(chef_id,title, description, start_date, end_date, duration);
		conn.insertProject(new_pr);
		resp.sendRedirect("projects");
	}

	private void updateProject(HttpServletRequest req, HttpServletResponse resp) 
			throws SQLException, IOException, ParseException {
		int pr_id = Integer.parseInt(req.getParameter("pr_id"));
		int chef_id = Integer.parseInt(req.getParameter("chef_id"));
		String title = req.getParameter("title");
		String description = req.getParameter("description");
		String start_str = req.getParameter("start_date");
		String end_str = req.getParameter("end_date");
		Date start_date = null;
		Date end_date = null;
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			start_date = dateFormat.parse(start_str);
			end_date = dateFormat.parse(end_str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int duration = Integer.parseInt(req.getParameter("duration"));
		if(start_date == null){System.out.println("noooooooooone");}
		else {System.out.println("maydyaghn mayk");}
		Project new_pr = new Project(pr_id,chef_id,title, description, start_date, end_date, duration);
		conn.updateProject(new_pr);
		resp.sendRedirect("projects");
	}

	private void deleteProject(HttpServletRequest req, HttpServletResponse resp) 
			throws SQLException, IOException {
		int pr_id = Integer.parseInt(req.getParameter("pr_id"));
		conn.deleteProject(pr_id);
		resp.sendRedirect("projects");

	}
}
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Vehicle;

/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/navigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NavigationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		VehicleHelper vh = new VehicleHelper();
		String act = request.getParameter("doThisToItem");
		String path = "/viewAllVehiclesServlet";

		if (act.equals("delete")) {
			// DELETE
			try {
				String tempPlateNum = request.getParameter("plateNum");
				Vehicle toDelete = vh.searchForVehicleByPlateNum(tempPlateNum);
				vh.deleteItem(toDelete);
			} catch (Exception e) {
				System.out.println("Error " + e);
			}
		} else if (act.equals("edit")) {
			// EDIT
			try {
				String tempPlateNum = request.getParameter("plateNum");
				Vehicle toEdit = vh.searchForVehicleByPlateNum(tempPlateNum);
				request.setAttribute("itemToEdit", toEdit);
			} catch (Exception e) {
				System.out.println("Error " + e);
			}
			path = "/edit-vehicle.jsp";
		} else if (act.equals("add")) {
			// ADD
			path = "/index.html";
		}

		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}

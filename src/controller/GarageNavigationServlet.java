package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GarageList;

/**
 * Servlet implementation class GarageNavigationServlet
 */
@WebServlet("/garageNavigationServlet")
public class GarageNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GarageNavigationServlet() {
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
		// TODO Auto-generated method stub
		GarageListHelper glh = new GarageListHelper();
		String act = request.getParameter("doThisToList");

		if (act == null) {
			getServletContext().getRequestDispatcher("/viewAllGaragesServlet").forward(request, response);
		} else if (act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("ID"));
				System.out.println("tempId " + tempId);
				GarageList garageToDel = glh.searchForListDetailsById(tempId);
				System.out.println(garageToDel.toString());
				glh.deleteGarage(garageToDel);
			} catch (NumberFormatException e) {
				System.out.println("Error " + e);
			} finally {
				getServletContext().getRequestDispatcher("/viewAllGaragesServlet").forward(request, response);
			}
		} else if (act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("ID"));
				GarageList garageToEdit = glh.searchForListDetailsById(tempId);
				request.setAttribute("listToEdit", garageToEdit);
				VehicleHelper vh = new VehicleHelper();
				request.setAttribute("allItems", vh.showAllVehicles());

				if (vh.showAllVehicles().isEmpty()) {
					request.setAttribute("allItems", " ");
				}
				getServletContext().getRequestDispatcher("/edit-garage.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				getServletContext().getRequestDispatcher("/viewAllGaragesServlet").forward(request, response);
			}
		} else if (act.equals("add")) {
			getServletContext().getRequestDispatcher("/new-garage.jsp").forward(request, response);
		}
	}

}

package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GarageList;
import model.Owner;
import model.Vehicle;

/**
 * Servlet implementation class EditGarageListServlet
 */
@WebServlet("/editGarageListServlet")
public class EditGarageListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditGarageListServlet() {
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
		VehicleHelper vh = new VehicleHelper();
		OwnerHelper oh = new OwnerHelper();

		Integer tempId = Integer.parseInt(request.getParameter("ID"));
		GarageList garageToUpate = glh.searchForListDetailsById(tempId);

		String newGarageName = request.getParameter("garageName");
		String newOwnerName = request.getParameter("ownerName");

		Owner newOwner = oh.findOwner(newOwnerName);

		try {
			String[] selectedItems = request.getParameterValues("allItemsToAdd");
			List<Vehicle> selectedVehiclesInList = new ArrayList<Vehicle>();

			for (int i = 0; i < selectedItems.length; i++) {
				Vehicle v = vh.searchForVehicleByPlateNum((selectedItems[i]));
				selectedVehiclesInList.add(v);
			}
			garageToUpate.setVehicles(selectedVehiclesInList);
		} catch (NullPointerException ex) {
			List<Vehicle> selectedVehiclesInList = new ArrayList<Vehicle>();
			garageToUpate.setVehicles(selectedVehiclesInList);
		}
		garageToUpate.setGarageName(newGarageName);
		garageToUpate.setGarageOwner(newOwner);

		glh.updateList(garageToUpate);

		getServletContext().getRequestDispatcher("/viewAllGaragesServlet").forward(request, response);
	}

}

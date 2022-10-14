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
 * Servlet implementation class CreateNewGarageServlet
 */
@WebServlet("/createNewGarageServlet")
public class CreateNewGarageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateNewGarageServlet() {
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
		VehicleHelper vh = new VehicleHelper();
		String garageName = request.getParameter("garageName");
		String ownerName = request.getParameter("ownerName");
		String[] selectedItems = request.getParameterValues("allItemsToAdd");
		List<Vehicle> selectedItemsInList = new ArrayList<Vehicle>();

		if (selectedItems != null && selectedItems.length > 0) {
			for (int i = 0; i < selectedItems.length; i++) {
				Vehicle v = vh.searchForVehicleByPlateNum(selectedItems[i]);
				selectedItemsInList.add(v);
			}
		}
		Owner owner = new Owner(ownerName);
		GarageList g = new GarageList(garageName, owner);
		g.setVehicles(selectedItemsInList);
		GarageListHelper glh = new GarageListHelper();
		glh.insertNewGarageList(g);

		System.out.println("Success");

		getServletContext().getRequestDispatcher("/viewAllGaragesServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

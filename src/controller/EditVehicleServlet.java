package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Vehicle;

/**
 * Servlet implementation class EditVehicleServlet
 */
@WebServlet("/editVehicleServlet")
public class EditVehicleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditVehicleServlet() {
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		VehicleHelper vh = new VehicleHelper();
		String ownerName = request.getParameter("ownerName");
		String makeModelYear = request.getParameter("makeModelYear");
		String plateNum = request.getParameter("plateNum");
		System.out.println(plateNum);

		Vehicle toUpdate = vh.searchForVehicleByPlateNum(plateNum);
		toUpdate.setOwnerNamme(ownerName);
		toUpdate.setMakeModelYear(makeModelYear);
		vh.updateVehicle(toUpdate);

		getServletContext().getRequestDispatcher("/viewAllVehiclesServlet").forward(request, response);
	}

}

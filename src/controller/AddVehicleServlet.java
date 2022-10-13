package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Vehicle;

/** @author Elijah Edlund */

/**
 * Servlet implementation class AddVehicleServlet
 */
@WebServlet("/addVehicleServlet")
public class AddVehicleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddVehicleServlet() {
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
		// get platenum
		String plateNum = request.getParameter("plateNum");
		String ownerName = request.getParameter("ownerName");
		String makeModelYear = request.getParameter("makeModelYear");

		// create
		Vehicle veh = new Vehicle(ownerName, makeModelYear, plateNum);
		VehicleHelper vh = new VehicleHelper();
		// save
		vh.insertVehicle(veh);

		// return
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}

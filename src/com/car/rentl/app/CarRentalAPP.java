package com.car.rentl.app;

public class CarRentalAPP {
	public static void main(String[] args) {
		double totalAmtForCar = calculateExp("Car", "Disel", "NonAC", "Pune-Mumbai", 7);
		double totalAmtForBus = calculateExp("Bus", "Disel", "NonAC", "Pune-Chennai-Pune", 50);
		double totalAmtForVan = calculateExp("Van", "Disel", "NonAC", "Pune-Mumbai-Pune", 15);
		double totalAmtForSUV = calculateExp("Van", "Disel", "NonAC", "Pune-Mumbai", 15);
		System.out.println("Total Trip Expense For Car-->" + totalAmtForCar);
		System.out.println("Total Trip Expense For Bus-->" + totalAmtForBus);
		System.out.println("Total Trip Expense For Van-->" + totalAmtForVan);
		System.out.println("Total Trip Expense For SUV-->" + totalAmtForSUV);
	}
	
	/**
	 * 
	 * @param vechileType
	 * @param fuel
	 * @param airCond
	 * @param tripdetails
	 * @param noOfPPL
	 * @return amount
	 */
	private static double calculateExp(String vechileType, String fuel, String airCond, String tripdetails,
			int noOfPPL) {
		AbstractVechile vechile = null;
		double amount = 0;
		if (null != vechileType) {
			switch (vechileType) {
			case "Car":
				vechile = new Car(fuel, airCond);
				amount = vechile.calculateTotalTripExp(tripdetails, noOfPPL);
				break;

			case "Bus":
				vechile = new Bus(fuel, airCond);
				amount = vechile.calculateTotalTripExp(tripdetails, noOfPPL);
				break;

			case "Van":
				vechile = new Van(fuel, airCond);
				amount = vechile.calculateTotalTripExp(tripdetails, noOfPPL);
				break;

			case "SUV":
				vechile = new SUV(fuel, airCond);
				amount = vechile.calculateTotalTripExp(tripdetails, noOfPPL);
				break;

			}
		}
		return amount;
	}
}

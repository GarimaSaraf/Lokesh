/**
 * 
 */
package com.car.rentl.app;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 461894
 *
 */
public abstract class AbstractVechile implements Vechile {

	int baseamount;
	int addChargeAC = 2;
	int standardRateForPetrol = 15;
	int standardRateForDisel = 14;
	private String fuelType;
	private String isAcorNonAc;

	/**
	 * 
	 * @param fuelType
	 * @param isAcorNonAc
	 */
	public AbstractVechile(String fuelType, String isAcorNonAc) {
		super();
		this.fuelType = fuelType;
		this.isAcorNonAc = isAcorNonAc;
	}
	/**
	 * @return fuel
	 */
	public String fuelType() {
		return fuelType;
	}
	/**
	 * @return boolean
	 */
	public boolean isAcOrNonAC() {
		if (isAcorNonAc.equalsIgnoreCase("AC")) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @param fuelType
	 * @param isAcorNonAC
	 * @return baseAmount
	 */
	public int calculateBaseAmount(String fuelType, boolean isAcorNonAC) {

		if (null != fuelType & fuelType.equalsIgnoreCase("Petrol")) {

			if (isAcorNonAC) {
				baseamount = standardRateForPetrol + addChargeAC;
			} else {
				baseamount = standardRateForPetrol;
			}

		} else if (null != fuelType & fuelType.equalsIgnoreCase("Disel")) {

			if (isAcorNonAC) {
				baseamount = standardRateForDisel + addChargeAC;
			} else {
				baseamount = standardRateForDisel;
			}
		}
		return baseamount;

	}

	/**
	 * 
	 * @param tourDetails
	 * @return boolean
	 */
	boolean calucalteRoundTip(String tourDetails) {
		String[] splitTourDetails = tourDetails.split("-");
		if (splitTourDetails.length > 2) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @param totaldistance
	 * @return map
	 */
	Map<String, Double> calucalteTotalDistance() {
		Map<String, Double> tourMap = new HashMap<>();
		tourMap.put("Mumbai", 200.0);
		tourMap.put("Banglore", 1000.0);
		tourMap.put("Delhi", 2050.0);
		tourMap.put("Chennai", 1234.5);

		return tourMap;

	}

	/**
	 * 
	 * @param totalTripDistance
	 * @return totalAmount
	 */
	abstract Double calculateTotalTripExp(String totalTripDistance, int noOfPPL);

}

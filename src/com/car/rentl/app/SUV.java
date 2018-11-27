package com.car.rentl.app;

public class SUV extends AbstractVechile {

	int maxLimit = 7;
	double tourdistance;
	double baseAmnt;
	double totalAmt;
	String fuelType = "Disel";
	boolean isAcOrNonAC = true;

	/**
	 * 
	 * @param fuelType
	 * @param isAcorNonAc
	 */
	public SUV(String fuelType, String isAcorNonAc) {
		super(fuelType, isAcorNonAc);

	}
	
	@Override
	Double calculateTotalTripExp(String totalTripDistance, int noOfPPL) {

		if (noOfPPL > maxLimit) {
			baseAmnt = super.calculateBaseAmount(fuelType, isAcOrNonAC);
			baseAmnt = baseAmnt + (noOfPPL - maxLimit);
			System.out.println("BasedAmount Modifed -->" + baseAmnt);
		} else {
			baseAmnt = calculateBaseAmount(fuelType, isAcOrNonAC);
		}
		System.out.println(totalTripDistance);
		if (calucalteRoundTip(totalTripDistance)) {
			System.out.println("For Rounded Trip");
			totalTripDistance = totalTripDistance.substring(totalTripDistance.indexOf("-") + 1,
					totalTripDistance.lastIndexOf("-"));
			tourdistance = calucalteTotalDistance().get(totalTripDistance) * 2;
		} else {
			System.out.println("For One Way Trip");
			totalTripDistance = totalTripDistance.substring(totalTripDistance.indexOf("-") + 1);
			tourdistance = calucalteTotalDistance().get(totalTripDistance);
		}
		System.out.println("totalAmt--" + baseAmnt * tourdistance);
		totalAmt = baseAmnt * tourdistance;
		return totalAmt;
	}

}

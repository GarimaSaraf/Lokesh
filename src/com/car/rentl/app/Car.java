/**
 * 
 */
package com.car.rentl.app;

/**
 * @author 461894
 *
 */
public class Car extends AbstractVechile {
	
	double tourdistance;
	int baseAmnt;
	double totalAmt;
	int maxLimit = 4;
	
	
	/**
	 * 
	 * @param fuelType
	 * @param isAcorNonAc
	 */
	public Car(String fuelType, String isAcorNonAc) {
		super(fuelType, isAcorNonAc);
	}

	
	@Override
	Double calculateTotalTripExp(String totalTripDistance, int noOfPpl) {
		if (noOfPpl > maxLimit) {
			baseAmnt = super.calculateBaseAmount(fuelType(), isAcOrNonAC());
			baseAmnt = baseAmnt + (noOfPpl - maxLimit);
			System.out.println("BasedAmount Modifed -->" + baseAmnt);
		} else {
			baseAmnt = calculateBaseAmount(fuelType(), isAcOrNonAC());
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

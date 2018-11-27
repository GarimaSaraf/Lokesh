package com.car.rentl.app;

public class Bus extends AbstractVechile {

	double tourdistance;
	double baseAmnt;
	double totalAmt;
	int maxLimit = 48;

	public Bus(String fuelType, String isAcorNonAc) {
		super(fuelType, isAcorNonAc);

	}

	@Override
	Double calculateTotalTripExp(String totalTripDistance, int noOfPPL) {
		System.out.println("Trip Expense for Bus");
		if (noOfPPL > maxLimit) {
			baseAmnt = super.calculateBaseAmount(fuelType(), isAcOrNonAC());
			baseAmnt = ((baseAmnt * 0.02) + (noOfPPL - maxLimit));
			System.out.println("BasedAmount Modifed -->" + baseAmnt);
		} else {
			baseAmnt = calculateBaseAmount(fuelType(), isAcOrNonAC());
			baseAmnt = baseAmnt * 0.02;
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

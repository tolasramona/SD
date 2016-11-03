package ro.tuc.dsrl.ds.handson.assig.two.server.services;

import ro.tuc.dsrl.ds.handson.assig.two.common.entities.Car;
import ro.tuc.dsrl.ds.handson.assig.two.common.serviceinterfaces.ISellingPriceService;


public class SellingPriceService implements ISellingPriceService {

	

	@Override
	public double computeSellingPrince(Car c) {
		
		double pourchasingPrice=c.getPourchasingPrice();
		int year=c.getYear();
		if (pourchasingPrice <= 0) {
			throw new IllegalArgumentException("Pourchasing price must be grater than 0.");
		}
		if (year <= 1800) {
			throw new IllegalArgumentException("Year must be grater than 1800");
		}
		
		return pourchasingPrice-(pourchasingPrice*(2015-year))/7;
	}

	
}

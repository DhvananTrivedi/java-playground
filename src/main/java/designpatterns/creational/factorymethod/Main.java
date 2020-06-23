package designpatterns.creational.factorymethod;

/* 
=> Definition  
A Factory Pattern or Factory Method Pattern says that just define an interface or abstract class for creating an object
but let the subclasses decide which class to instantiate. 
In other words, subclasses are responsible to create the instance of the class.

=> Usage of Factory Design Pattern

    When a class doesn't know what sub-classes will be required to create
    When a class wants that its sub-classes specify the objects to be created.
    When the parent classes choose the creation of objects to its sub-classes
*/
public class Main {

	public static void main(String[] a) {
		final PlanFactory planFactory = new PlanFactory();
		Plan p = null;
		System.out.println("Calculating domestice plan");
	    p = planFactory.getPlan("DOMESTICPLAN");
	    p.calculateBill(100);
	    
		System.out.println("Calculating commercial plan");
	    p = planFactory.getPlan("COMMERCIALPLAN");
	    p.calculateBill(100);
	    
		System.out.println("Calculating instisutional plan");
	    p = planFactory.getPlan("INSTITUTIONALPLAN");
	    p.calculateBill(100);
	}

}

abstract class Plan {

	abstract double getRate();

	public void calculateBill(int units) {
		System.out.println(units * getRate());
	}
}

class DomesticPlan extends Plan {
	double rate = 3.50;
	@Override
	public double getRate() {
		return rate;
	}
}

class CommercialPlan extends Plan {
	double rate = 7.50;
	@Override
	public double getRate() {
		return rate;
	}
}

class InstitutionalPlan extends Plan {
	double rate = 5.50;
	@Override
	public double getRate() {
		return rate;
	}
}

class PlanFactory {

	// use getPlan method to get object of type Plan
	public Plan getPlan(String planType) {
		if (planType == null) {
			return null;
		}
		if (planType.equalsIgnoreCase("DOMESTICPLAN")) {
			return new DomesticPlan();
		} else if (planType.equalsIgnoreCase("COMMERCIALPLAN")) {
			return new CommercialPlan();
		} else if (planType.equalsIgnoreCase("INSTITUTIONALPLAN")) {
			return new InstitutionalPlan();
		}
		return null;
	}
}

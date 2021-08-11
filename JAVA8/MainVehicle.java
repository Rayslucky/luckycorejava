package JAVA8;

public class MainVehicle {

	public static void main(String[] args) {
		Vehicle vehicl = new Car();
		vehicl.mileage();
		vehicl.modification();
		
		vehicl = new Bike();
		vehicl.mileage();
		vehicl.modification();

	}

}

package JAVA8;
@FunctionalInterface 
public interface Vehicle {
void mileage();
//after 5 years modification

 default void modification(){
	 System.out.println("Testet Okk...\n");
 }

}

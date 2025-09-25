package Exercise1.StructuralDP.decorator;

public class PizzaShop {
    public static void main(String[] args) {
        Pizza myPizza = new PlainPizza();

        myPizza = new CheeseDecorator(myPizza);
        myPizza = new VeggieDecorator(myPizza);
        myPizza = new CheeseDecorator(myPizza);

        System.out.println("Your Order: " + myPizza.getDescription());
        System.out.printf("Total Cost: $%.2f%n", myPizza.getCost());
    }
}
package Exercise1.StructuralDP.decorator;

public class VeggieDecorator extends ToppingDecorator {
    public VeggieDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Bacon";
    }

    @Override
    public double getCost() {
        return super.getCost() + 2.25;
    }
}
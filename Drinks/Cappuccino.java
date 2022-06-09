public class Cappuccino extends AllOfDrinks implements toMakeDrink {
    public Cappuccino () {
        this.Name = "Cappuccino";
        setPrice(20);
    }
    @Override
    public void makeDrink() {
        System.out.println(this.Name + " is made");
    }

}

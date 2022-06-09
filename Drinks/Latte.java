public class Latte extends AllOfDrinks  {
    public Latte () {
        this.Name = "Latte";
        setPrice(25);
    }

    @Override
    public void makeDrink() {
        System.out.println(this.Name + " is made");
    }
}

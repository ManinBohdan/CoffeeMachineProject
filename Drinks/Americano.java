public class Americano extends AllOfDrinks implements toMakeDrink {
    public Americano () {
        this.Name = "Americano";
        setPrice(15);
    }
    @Override
    public void makeDrink() {
        System.out.println(this.Name + " is made");
    }

}

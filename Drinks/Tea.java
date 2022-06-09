public class Tea extends AllOfDrinks implements toMakeDrink {
    public Tea () {
        this.Name = "Tea";
        setPrice(10);
    }
    @Override
    public void makeDrink() {
        System.out.println(this.Name + " is made");
    }
}

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        var coffeeMachine = new CoffeeMachine();
        coffeeMachine.Welcome();
        coffeeMachine.checkCreateCollectDrinks(coffeeMachine.enterDrinksFromConsole());
        coffeeMachine.LoopToEnterAnotherDrinks();
        coffeeMachine.showListOfOrders();
        coffeeMachine.sumPricesOfOrders();
        coffeeMachine.makeAllOrders();
    }
}

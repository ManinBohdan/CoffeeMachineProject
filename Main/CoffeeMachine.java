import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CoffeeMachine implements EnterDrinksFromConsole, EnterAnotherDrinksYouWant, CheckCreateAndCollectDrinks, CollectObjectToArrayList, ShowListOfTheOrders, SumThePricesOfOrders, ToMakeAllOrders{
    // Создание коллекции обьектов типа AllOfDrinks (родительский класс)
    ArrayList <AllOfDrinks> arrayList = new ArrayList();
    static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    // Приветсвие
    public void Welcome () {
        System.out.println("Hi! Enter the drink you want to make: ");
    }
    // Сооздать поле ENUM со значением, которое ввел пользователь, сравнить его с другими полями, которые записаны в ENUM.
    // В том случае, если поля совпали, создать обьект класса введенного типа напитка.
    @Override
    public void checkCreateCollectDrinks(String str) throws IOException {
        ListOfAllDrinks list = ListOfAllDrinks.valueOf(str);
        switch (list) {
            case Latte:
                var latte = new Latte();
                Collect(latte);
                break;
            case Americano:
                var americano = new Americano();
                Collect(americano);
                break;
            case Cappuccino:
                var cappuccino = new Cappuccino();
                Collect(cappuccino);
                break;
            case Tea:
                var tea = new Tea();
                Collect(tea);
                break;
            default:
                System.out.println("Your answer unfortunately is incorrect, please try again.");
                this.enterDrinksFromConsole();
        }
    }

    // Цикл для заказа других видов напитков клиентом
   @Override
   public void LoopToEnterAnotherDrinks() throws IOException {
       Integer temp = 0;
       String DrinksString = null;
       while (temp != 1) {
           System.out.println("Maybe some other drinks? Write 'n' if you want to finish with your order.");
           DrinksString = this.enterDrinksFromConsole();
           if (DrinksString.equalsIgnoreCase("n")) temp = 1;
           else this.checkCreateCollectDrinks(DrinksString);
       }
   }

   // Ввод желаемого типа напитка из консоли
    @Override
    public String enterDrinksFromConsole() throws IOException {
        String str = String.valueOf(READER.readLine());
        return str;
    }

    // Добавить обьект в коллекцию
    @Override
    public void Collect(AllOfDrinks obj) {
        arrayList.add(obj);
    }

    // Вывод в консоль всех заказаных напитков клиентом (получение имени обьекта через обращение к его полю с именнем)
    @Override
    public void showListOfOrders() {
        System.out.println("Your order is: ");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i).Name + " ");
        }
        System.out.println("");
    }

    // Подсчет сумы за заказанные напитки (обращение через getter () к полю цены элемента в коллекции)
    @Override
    public void sumPricesOfOrders() {
        double sum = 0;
        System.out.println("Your cheque for order is: ");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i).Name + " " + arrayList.get(i).getPrice() + " ");
            sum += arrayList.get(i).getPrice();
        }
        System.out.println("");
        System.out.println("sum is: " + sum);
    }

    // Приготовление напитка (вызов метода у элемента коллекции)
    @Override
    public void makeAllOrders() {
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.get(i).makeDrink();
        }
    }
}

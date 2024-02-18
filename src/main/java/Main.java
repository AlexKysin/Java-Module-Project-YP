import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double sum = 0;
        int quantity = 0;

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("На скольких человек необходимо разделить счёт?");
            quantity = scanner.nextInt();
            if (quantity < 2) {
                System.out.println("Неверное значение");
            } else {
                break;
            }
        }
        ArrayList<Product> productsList = new ArrayList<>();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Введите название товара");
            String name = sc.nextLine();
            if (name.equalsIgnoreCase("Завершить")) {

                for (int i = 0; i < productsList.size(); i++) {
                    Product element = productsList.get(i);
                    System.out.println(element.name + " " + element.price);
                    sum += element.price;
                }
                String rub = Format.formatRub(sum / quantity);
                System.out.printf("Итого с человека: %.2f" + rub, sum / quantity);
                break;

            } else {
                System.out.println("Введите цену");
                Double price = sc.nextDouble();
                Product newProduct = new Product(name, price);
                productsList.add(newProduct);
                System.out.println("Добавленные товары: ");
                for (Product k : productsList) {
                    System.out.println(k.name);
                }
            }
        }
    }
}
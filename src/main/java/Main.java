import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double sum = 0;
        int quantity = 0;

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("На скольких человек необходимо разделить счёт?");

            if (scanner.hasNextInt()) {
                quantity = scanner.nextInt();
                if (quantity < 2) {
                    System.out.println("Неверное значение");
                } else {
                    break;
                }
            } else {
                System.out.println("Неверное значение");
            }
        }

        ArrayList<Product> productsList = new ArrayList<>();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Введите название товара");
            String name = sc.nextLine();
            if (name.trim().isEmpty()) {
                System.out.println("Что-нибудь еще, кроме пустоты?");
            } else {
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
                    while (true) {
                        Scanner sc1 = new Scanner(System.in);
                        System.out.println("Введите цену");
                        if (sc1.hasNextDouble()) {
                            double price = sc1.nextDouble();
                            Product newProduct = new Product(name, price);
                            productsList.add(newProduct);
                            System.out.println("Добавленные товары: ");
                            for (Product k : productsList) {
                                System.out.println(k.name);
                            }
                            break;
                        } else {
                            System.out.println("Неверное значение цены");
                        }
                    }
                }
            }
        }
    }
}
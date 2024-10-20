import attractions.Carousel;
import attractions.FerrisWheel;
import attractions.RollerCoaster;
import model.Attraction;
import model.Customer;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Customer customer1 = new Customer("Alice Devon", 25);
        Scanner scanner = new Scanner(System.in);

        Attraction[] attractions = initializeAttractions();
        boolean run = true;
        while (run) {
            run = displayMenu(customer1, attractions, scanner);
        }
        scanner.close();
    }

    public static Attraction[] initializeAttractions() {
        Attraction rollerCoaster = new RollerCoaster("Thunderbolt", 5, 12,
                20, 15.99);
        Attraction ferrisWheel = new FerrisWheel("SkyView", 10, 6,
                15, 10.50);
        Attraction carousel = new Carousel("Animal carousel", 3, 5,
                10, 10);
        return new Attraction[]{rollerCoaster, ferrisWheel, carousel};
    }

    private static boolean displayMenu(Customer customer, Attraction[] attractions, Scanner scanner) {
        System.out.println("\nWelcome to the Energylandia Amusement Park");
        System.out.println("Choose one of the available options:");
        System.out.println(
                "1. Show available attractions\n" +
                        "2. Buy ticket\n" +
                        "3. Reserve spot for attraction\n" +
                        "4. Exit");

        try {
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    showAttractions(attractions);
                    break;
                case 2:
                    buyTicket(customer, scanner, attractions);
                    break;
                case 3:
                    reserveSpot(scanner, attractions, customer);
                    break;
                case 4:
                    System.out.println("Thank you for visiting our amusement park!");
                    return false;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine();
        }
        return true;
    }

    private static void showAttractions(Attraction[] attractions) {
        for (Attraction attraction : attractions) {
            System.out.println("-".repeat(30));
            attraction.displayInfo();
        }
    }

    private static void buyTicket(Customer customer, Scanner scanner, Attraction[] attractions) {
        System.out.println("Choose attraction: \n" +
                "1. attractions.RollerCoaster\n" +
                "2. attractions.FerrisWheel\n" +
                "3. attractions.Carousel\n");

        int attractionTicket = scanner.nextInt();
        switch (attractionTicket) {
            case 1:
                customer.buyTicket(attractions[0]);
                customer.printTicket("attractions.RollerCoaster.txt");
                break;
            case 2:
                customer.buyTicket(attractions[1]);
                customer.printTicket("attractions.FerrisWheel.txt");
                break;
            case 3:
                customer.buyTicket(attractions[2]);
                customer.printTicket("attractions.Carousel.txt");
                break;
            default:
                System.out.println("Something went wrong, try again.");
        }
    }
    private static void reserveSpot(Scanner scanner, Attraction[] attractions, Customer customer) {
        System.out.println("For which attraction do you want to reserve a spot?: \n" +
                "1. attractions.RollerCoaster\n" +
                "2. attractions.FerrisWheel\n" +
                "3. attractions.Carousel\n");

        int attraction = scanner.nextInt();
        switch (attraction) {
            case 1:
                attractions[0].reserveSpot(customer);
                break;
            case 2:
                attractions[1].reserveSpot(customer);
                break;
            case 3:
                attractions[2].reserveSpot(customer);
                break;
            default:
                System.out.println("Wrong attraction chosen, try again.");
        }
    }
}
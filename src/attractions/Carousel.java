package attractions;

import model.Attraction;

public class Carousel extends Attraction {
    public Carousel(String name, int duration, int minAge, int capacity, double price) {
        super(name, duration, minAge, capacity, price);
    }

    @Override
    public void startRide() {
        System.out.println("Welcome to the " + getName() + " attraction. Let's get started");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
    }
}

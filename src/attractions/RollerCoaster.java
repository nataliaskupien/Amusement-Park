package attractions;

import model.Attraction;

public class RollerCoaster extends Attraction {

    public RollerCoaster(String name, int duration, int minAge, int capacity, double price) {
        super(name, duration, minAge, capacity, price);
    }

    @Override
    public void startRide() {
        System.out.println("Hold tight! The " + getName() + "is about to start");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
    }
}

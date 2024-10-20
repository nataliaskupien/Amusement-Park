package attractions;

import model.Attraction;

public class FerrisWheel extends Attraction {

    private int height;

    public FerrisWheel(String name, int duration, int minAge, int capacity, double price) {
        super(name, duration, minAge, capacity, price);
        this.height = 100;
    }

    @Override
    public void startRide() {
        System.out.println(getName() + "is about to start");
        System.out.println("Enjoy the view from the top of " + getName() + "from " + height + " meters");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
    }
}

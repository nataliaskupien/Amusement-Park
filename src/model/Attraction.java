package model;

public class Attraction {
    private String name;
    private int duration;
    private int minAge;
    private int capacity;
    private double price;

    public Attraction(String name, int duration, int minAge, int capacity, double price) {
        this.name = name;
        this.duration = duration;
        this.minAge = minAge;
        this.capacity = capacity;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void displayInfo() {
        System.out.println("model.Attraction: " + name);
        System.out.println("Price: " + price);
        System.out.println("Duration: " + duration + " minutes");
        System.out.println("Minimum age: " + minAge);
        System.out.println("Capacity: " + capacity);
    }

    public void startRide() {
        System.out.println(name + " ride is starting! Enjoy!");
    }
    public boolean reserveSpot(Customer customer) {
        if (customer.getAge() > minAge) {
            System.out.println("Spot reserved for " + name);
            return true;
        } else {
            System.out.println("Sorry you're too young for " + name);
            System.out.println("Minimum age is: " + minAge);
            return false;
        }
    }
}

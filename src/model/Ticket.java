package model;

public class Ticket {
    private Attraction attraction;
    private boolean isUsed;

    public Ticket(Attraction attraction) {
        this.attraction = attraction;
        this.isUsed = false;
    }

    public Attraction getAttraction() {
        return attraction;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void useTicket() {
        if (!isUsed) {
            isUsed = true;
            System.out.println("model.Ticket for " + attraction.getName() + "used");
        } else {
            System.out.println("This ticket has already been used.");
        }
    }

    public void displayTicketInfo() {
        System.out.println("*".repeat(3) + "model.Ticket for: " +
                attraction.getName() + "*".repeat(3));
        System.out.println("Price: $" + attraction.getPrice());
        System.out.println("Used: " + (isUsed ? "Yes" : "No"));
    }
}

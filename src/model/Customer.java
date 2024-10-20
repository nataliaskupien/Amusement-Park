package model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Customer {
    private String name;
    private int age;
    private ArrayList<Ticket> tickets;

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
        this.tickets = new ArrayList<>();
    }

    public int getAge() {
        return age;
    }

    public void buyTicket(Attraction attraction) {
        if (age >= attraction.getMinAge()) {
            Ticket newTicket = new Ticket(attraction);
            tickets.add(newTicket);
            System.out.println(name + " bought a ticket for " + attraction.getName());
        } else {
            System.out.println(name + " is too young for " + attraction.getName());
        }
    }

    public void useTicket(Attraction attraction) {
        for (Ticket ticket : tickets) {
            if(ticket.getAttraction() == attraction && !ticket.isUsed()) {
                ticket.useTicket();
                return;
            }
        }
        System.out.println("No valid ticket found for " + attraction.getName());
    }

    public void displayTickets() {
        System.out.println(name + "'s tickets:");
        for (Ticket ticket : tickets) {
            ticket.displayTicketInfo();
        }
    }

    public void printTicket(String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (Ticket ticket : tickets) {
                writer.println("model.Attraction: " + ticket.getAttraction().getName());
                writer.println("Price: " + ticket.getAttraction().getPrice());
                writer.println("Min age: " + ticket.getAttraction().getMinAge());
                writer.println();
            }
            System.out.println("model.Ticket print successfully ");
        } catch (IOException e) {
            System.out.println("Error printing ticket" + e.getMessage());
        }
    }
}

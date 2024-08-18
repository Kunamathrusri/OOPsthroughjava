package myproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Expense {
    private String description;
    private double amount;
    private String category;

    public Expense(String description, double amount, String category) {
        this.description = description;
        this.amount = amount;
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Description: " + description + ", Amount: $" + amount + ", Category: " + category;
    }
}

class ExpenseTracker {
    private List<Expense> expenses;

    public ExpenseTracker() {
        expenses = new ArrayList<>();
    }

    public void addExpense(String description, double amount, String category) {
        Expense expense = new Expense(description, amount, category);
        expenses.add(expense);
    }

    public void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded.");
        } else {
            for (Expense expense : expenses) {
                System.out.println(expense);
            }
        }
    }

    public double calculateTotalExpenses() {
        double total = 0;
        for (Expense expense : expenses) {
            total += expense.getAmount();
        }
        return total;
    }
}

public class Project {
    public static void main(String[] args) {
        ExpenseTracker tracker = new ExpenseTracker();
        Scanner sc = new Scanner(System.in);
        int choice;
        Double income;
        System.out.println("Please enter your income per month to analyse your expenses");
        income=sc.nextDouble();
        

        do {
            System.out.println("Expense Tracker");
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. Calculate Total Expenses");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter description: ");
                    String description = sc.nextLine();
                    System.out.print("Enter amount: ");
                    double amount = sc.nextDouble();
                    sc.nextLine(); // Consume newline
                    System.out.print("Enter category: ");
                    String category = sc.nextLine();
                    tracker.addExpense(description, amount, category);
                    break;
                case 2:
                    tracker.viewExpenses();
                    break;
                case 3:
                    double totalExpenses = tracker.calculateTotalExpenses();
                    System.out.println("Total Expenses: $" + totalExpenses);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
        
if(tracker.calculateTotalExpenses()>=income) {
	System.out.println("---Please control your expenses---");
}else {
	System.out.println("---You are on the Good tracks of spending---");
}
    }
}


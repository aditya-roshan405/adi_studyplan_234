import java.util.Scanner;

/**
 * UserInput.java
 * Handles all user input collection and validation.
 * Separates input logic from business logic (good design practice).
 */
public class UserInput {

    /**
     * Prompts the user to enter a new subject and adds it to the planner.
     *
     * @param scanner  The shared Scanner object
     * @param planner  The StudyPlanner to add the subject to
     */
    public static void addSubject(Scanner scanner, StudyPlanner planner) {
        System.out.println("\n--- ADD SUBJECT ---");

        // Get subject name
        System.out.print("Enter subject name: ");
        String subject = scanner.nextLine().trim();

        if (subject.isEmpty()) {
            System.out.println("Subject name cannot be empty.");
            return;
        }

        // Get total weekly hours with validation
        int totalHours = 0;
        while (totalHours < 1) {
            System.out.print("Enter total hours per week for this subject (1-30): ");
            String hoursInput = scanner.nextLine().trim();
            try {
                totalHours = Integer.parseInt(hoursInput);
                if (totalHours < 1 || totalHours > 30) {
                    System.out.println("Please enter a number between 1 and 30.");
                    totalHours = 0; // Reset to loop again
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        // Get priority
        String priority = "";
        while (!priority.equals("high") && !priority.equals("medium") && !priority.equals("low")) {
            System.out.print("Enter priority (High / Medium / Low): ");
            priority = scanner.nextLine().trim().toLowerCase();
            if (!priority.equals("high") && !priority.equals("medium") && !priority.equals("low")) {
                System.out.println("Please enter: High, Medium, or Low");
            }
        }

        // Capitalize priority for display
        priority = capitalize(priority);

        // Add to planner
        planner.addSubject(subject, totalHours, priority);
    }

    /**
     * Prompts the user to mark a specific task as complete.
     *
     * @param scanner  The shared Scanner object
     * @param planner  The StudyPlanner to update
     */
    public static void markComplete(Scanner scanner, StudyPlanner planner) {
        System.out.println("\n--- MARK TASK COMPLETE ---");

        System.out.print("Enter subject name: ");
        String subject = scanner.nextLine().trim();

        System.out.print("Enter day (e.g. Monday): ");
        String day = scanner.nextLine().trim();

        boolean success = planner.markTaskComplete(subject, day);

        if (success) {
            System.out.println("Task marked as complete!");
        } else {
            System.out.println("Task not found. Check the subject name and day.");
        }
    }

    /**
     * Capitalizes the first letter of a string.
     * E.g. "high" becomes "High"
     */
    private static String capitalize(String word) {
        if (word == null || word.isEmpty()) return word;
        return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
    }
}

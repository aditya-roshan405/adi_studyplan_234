import java.util.Scanner;

/**
 * Main.java
 * Entry point of the Study Planner application.
 * Displays the main menu and routes user choices.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudyPlanner planner = new StudyPlanner();

        // Load any previously saved data from file
        FileManager.loadFromFile(planner);

        System.out.println("==========================================");
        System.out.println("       WELCOME TO STUDY PLANNER          ");
        System.out.println("==========================================");

        boolean running = true;

        while (running) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Add a subject");
            System.out.println("2. View weekly schedule");
            System.out.println("3. Mark task as complete");
            System.out.println("4. View progress report");
            System.out.println("5. Save and Exit");
            System.out.print("Enter your choice: ");

            String input = scanner.nextLine().trim();

            switch (input) {
                case "1":
                    UserInput.addSubject(scanner, planner);
                    break;
                case "2":
                    planner.displaySchedule();
                    break;
                case "3":
                    UserInput.markComplete(scanner, planner);
                    break;
                case "4":
                    planner.displayProgress();
                    break;
                case "5":
                    FileManager.saveToFile(planner);
                    System.out.println("Progress saved. Goodbye! Keep studying!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1-5.");
            }
        }

        scanner.close();
    }
}

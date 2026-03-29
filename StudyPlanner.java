import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * StudyPlanner.java
 * Core logic of the application.
 * Manages the list of tasks, generates the weekly schedule,
 * and tracks progress.
 */
public class StudyPlanner {

    // ArrayList stores all tasks dynamically (no fixed size needed)
    private ArrayList<Task> tasks;

    // Days of the week used for schedule distribution
    private static final String[] DAYS = {
        "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
    };

    // Constructor
    public StudyPlanner() {
        tasks = new ArrayList<>();
    }

    /**
     * Adds a new subject and distributes it across the week
     * based on available hours and priority.
     *
     * @param subject       Name of the subject
     * @param totalHours    Total hours the student wants to study this subject per week
     * @param priority      "High", "Medium", or "Low"
     */
    public void addSubject(String subject, int totalHours, String priority) {
        // Determine how many days to spread the subject across
        // High priority = 5 days, Medium = 3 days, Low = 2 days
        int daysToSpread;
        switch (priority.toLowerCase()) {
            case "high":   daysToSpread = 5; break;
            case "medium": daysToSpread = 3; break;
            default:       daysToSpread = 2; break; // low
        }

        // Calculate hours per day (at least 1 hour per session)
        int hoursPerDay = Math.max(1, totalHours / daysToSpread);

        // Assign the subject to the first `daysToSpread` days
        for (int i = 0; i < daysToSpread; i++) {
            Task task = new Task(subject, hoursPerDay, DAYS[i], priority);
            tasks.add(task);
        }

        System.out.println("\nSubject added! " + subject + " scheduled for "
                + daysToSpread + " day(s) at " + hoursPerDay + " hr(s)/day.");
    }

    /**
     * Displays the full weekly schedule, sorted by priority.
     * High priority subjects appear first.
     */
    public void displaySchedule() {
        if (tasks.isEmpty()) {
            System.out.println("\nNo subjects added yet. Use option 1 to add subjects.");
            return;
        }

        // Sort tasks: High > Medium > Low priority
        ArrayList<Task> sorted = new ArrayList<>(tasks);
        Collections.sort(sorted, new Comparator<Task>() {
            @Override
            public int compare(Task a, Task b) {
                return priorityRank(a.getPriority()) - priorityRank(b.getPriority());
            }
        });

        System.out.println("\n==========================================");
        System.out.println("          YOUR WEEKLY SCHEDULE           ");
        System.out.println("==========================================");

        String currentDay = "";
        for (Task task : sorted) {
            // Print day header when day changes
            if (!task.getDay().equals(currentDay)) {
                currentDay = task.getDay();
                System.out.println("\n  [ " + currentDay.toUpperCase() + " ]");
            }
            System.out.println("    " + task);
        }

        System.out.println("\n==========================================");
    }

    /**
     * Marks a task as complete by matching subject name and day.
     *
     * @param subject   Subject name to find
     * @param day       Day of the week
     * @return true if task was found and marked, false otherwise
     */
    public boolean markTaskComplete(String subject, String day) {
        for (Task task : tasks) {
            if (task.getSubject().equalsIgnoreCase(subject)
                    && task.getDay().equalsIgnoreCase(day)) {
                task.setCompleted(true);
                return true;
            }
        }
        return false; // Task not found
    }

    /**
     * Displays a progress summary — how many tasks are done vs total.
     */
    public void displayProgress() {
        if (tasks.isEmpty()) {
            System.out.println("\nNo tasks yet. Add subjects first.");
            return;
        }

        int total = tasks.size();
        int completed = 0;

        for (Task task : tasks) {
            if (task.isCompleted()) {
                completed++;
            }
        }

        int percentage = (completed * 100) / total;

        System.out.println("\n==========================================");
        System.out.println("           PROGRESS REPORT               ");
        System.out.println("==========================================");
        System.out.println("  Total Tasks   : " + total);
        System.out.println("  Completed     : " + completed);
        System.out.println("  Remaining     : " + (total - completed));
        System.out.println("  Completion    : " + percentage + "%");

        // Motivational message based on progress
        if (percentage == 100) {
            System.out.println("\n  Great job! You have completed everything!");
        } else if (percentage >= 50) {
            System.out.println("\n  Halfway there! Keep going!");
        } else {
            System.out.println("\n  Just getting started. You've got this!");
        }

        System.out.println("==========================================");
    }

    /**
     * Returns the list of all tasks (used by FileManager to save data).
     */
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    /**
     * Adds a task directly (used when loading from file).
     */
    public void addTaskDirectly(Task task) {
        tasks.add(task);
    }

    /**
     * Helper method to assign a numeric rank to priority strings.
     * Lower number = higher priority (so High sorts first).
     */
    private int priorityRank(String priority) {
        switch (priority.toLowerCase()) {
            case "high":   return 1;
            case "medium": return 2;
            default:       return 3; // low
        }
    }
}

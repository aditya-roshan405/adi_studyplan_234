/**
 * Task.java
 * Represents a single study task assigned to a day of the week.
 * Tracks subject, duration, day, priority, and completion status.
 */
public class Task {

    // Fields (data stored inside each Task object)
    private String subject;      // Name of the subject, e.g. "Mathematics"
    private int hoursPerDay;     // Study hours assigned per day
    private String day;          // Day of the week this task is assigned to
    private String priority;     // "High", "Medium", or "Low"
    private boolean completed;   // Whether the student has finished this task

    // Constructor - called when creating a new Task
    public Task(String subject, int hoursPerDay, String day, String priority) {
        this.subject = subject;
        this.hoursPerDay = hoursPerDay;
        this.day = day;
        this.priority = priority;
        this.completed = false; // New tasks start as incomplete
    }

    // --- Getters (to read the fields from outside this class) ---

    public String getSubject() {
        return subject;
    }

    public int getHoursPerDay() {
        return hoursPerDay;
    }

    public String getDay() {
        return day;
    }

    public String getPriority() {
        return priority;
    }

    public boolean isCompleted() {
        return completed;
    }

    // --- Setter ---

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    /**
     * Returns a readable summary of this task.
     * Used when displaying the schedule.
     */
    @Override
    public String toString() {
        String status = completed ? "[DONE]" : "[    ]";
        return status + " " + day + " | " + subject
                + " | " + hoursPerDay + " hr(s) | Priority: " + priority;
    }

    /**
     * Converts task to a saveable string format for the file.
     * Format: subject,hoursPerDay,day,priority,completed
     */
    public String toFileString() {
        return subject + "," + hoursPerDay + "," + day + "," + priority + "," + completed;
    }

    /**
     * Recreates a Task object from a saved file line.
     */
    public static Task fromFileString(String line) {
        String[] parts = line.split(",");
        if (parts.length != 5) return null; // Skip malformed lines

        String subject = parts[0];
        int hours = Integer.parseInt(parts[1]);
        String day = parts[2];
        String priority = parts[3];
        boolean completed = Boolean.parseBoolean(parts[4]);

        Task task = new Task(subject, hours, day, priority);
        task.setCompleted(completed);
        return task;
    }
}

import java.io.*;
import java.util.ArrayList;

/**
 * FileManager.java
 * Handles saving and loading tasks to/from a plain text file.
 * This allows study progress to persist between sessions.
 *
 * File format (one line per task):
 *   subject,hoursPerDay,day,priority,completed
 */
public class FileManager {

    // The file where tasks are stored
    private static final String FILE_NAME = "study_data.txt";

    /**
     * Saves all tasks from the planner to a text file.
     * Overwrites the file each time (latest state wins).
     *
     * @param planner  The StudyPlanner whose tasks will be saved
     */
    public static void saveToFile(StudyPlanner planner) {
        ArrayList<Task> tasks = planner.getTasks();

        try {
            // FileWriter with false = overwrite (not append)
            FileWriter fw = new FileWriter(FILE_NAME, false);
            BufferedWriter bw = new BufferedWriter(fw);

            for (Task task : tasks) {
                bw.write(task.toFileString());
                bw.newLine(); // Write each task on its own line
            }

            bw.close();
            System.out.println("Data saved to " + FILE_NAME);

        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    /**
     * Loads tasks from the save file into the planner.
     * Called once at startup.
     *
     * @param planner  The StudyPlanner to load tasks into
     */
    public static void loadFromFile(StudyPlanner planner) {
        File file = new File(FILE_NAME);

        // If file doesn't exist yet, skip loading (first run)
        if (!file.exists()) {
            return;
        }

        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line;
            int loaded = 0;

            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    Task task = Task.fromFileString(line);
                    if (task != null) {
                        planner.addTaskDirectly(task);
                        loaded++;
                    }
                }
            }

            br.close();

            if (loaded > 0) {
                System.out.println("Loaded " + loaded + " task(s) from previous session.");
            }

        } catch (IOException e) {
            System.out.println("Could not load saved data: " + e.getMessage());
        }
    }
}


package Exercise2.astranautScheduler;

import Exercise2.astranautScheduler.factory.TaskFactory;
import Exercise2.astranautScheduler.manager.ScheduleManager;
import Exercise2.astranautScheduler.model.Task;
import Exercise2.astranautScheduler.observer.UserNotifier;
import java.util.List;
import java.util.Scanner;

/**
 * Main application class for the Astronaut Daily Schedule Organizer.
 * This class provides a console-based user interface for interacting with the system.
 */
public class Main {
    public static void main(String[] args) {
        // Get the singleton instance of the ScheduleManager
        ScheduleManager scheduleManager = ScheduleManager.getInstance();

        // Setup the observer for conflict notifications
        UserNotifier userNotifier = new UserNotifier();
        scheduleManager.getConflictNotifier().subscribe(userNotifier);

        // Setup console input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Astronaut Daily Schedule Organizer");
        printHelp();

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            String[] parts = input.split(" ");
            String command = parts[0].toLowerCase();

            try {
                switch (command) {
                    case "add":
                        // Expected format: add "Task Description" HH:mm HH:mm Priority
                        String[] taskDetails = input.substring(4).split("\"");
                        if (taskDetails.length < 2) throw new IllegalArgumentException("Invalid add format.");
                        
                        String description = taskDetails[1];
                        String[] otherDetails = taskDetails[2].trim().split(" ");
                        if (otherDetails.length < 3) throw new IllegalArgumentException("Invalid add format.");

                        String startTime = otherDetails[0];
                        String endTime = otherDetails[1];
                        String priority = otherDetails[2];

                        Task newTask = TaskFactory.createTask(description, startTime, endTime, priority);
                        String result = scheduleManager.addTask(newTask);
                        System.out.println(result);
                        break;

                    case "remove":
                        // Expected format: remove "Task Description"
                        String[] removeDetails = input.substring(7).split("\"");
                         if (removeDetails.length < 2) throw new IllegalArgumentException("Invalid remove format.");
                        String descToRemove = removeDetails[1];
                        System.out.println(scheduleManager.removeTask(descToRemove));
                        break;

                    case "view":
                        List<Task> tasks = scheduleManager.getTasks();
                        if (tasks.isEmpty()) {
                            System.out.println("No tasks scheduled for the day.");
                        } else {
                            System.out.println("Scheduled Tasks:");
                            tasks.forEach(System.out::println);
                        }
                        break;

                    case "help":
                        printHelp();
                        break;

                    case "exit":
                        System.out.println("Exiting application.");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Error: Unknown command. Type 'help' for a list of commands.");
                        break;
                }
            } catch (Exception e) {
                // Gracefully handle all exceptions
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void printHelp() {
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Available Commands:");
        System.out.println("  add \"<description>\" <start_time> <end_time> <priority>");
        System.out.println("    -> Example: add \"Morning Exercise\" 07:00 08:00 High");
        System.out.println("  remove \"<description>\"");
        System.out.println("    -> Example: remove \"Morning Exercise\"");
        System.out.println("  view");
        System.out.println("  help");
        System.out.println("  exit");
        System.out.println("-----------------------------------------------------------------");
    }
}
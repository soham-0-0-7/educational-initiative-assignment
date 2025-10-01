package Exercise2.astranautScheduler.observer;

import  Exercise2.astranautScheduler.model.Task;

/**
 * A concrete implementation of the ConflictListener (Observer).
 * This class is responsible for displaying conflict notifications to the user console.
 */
public class UserNotifier implements ConflictListener {
    @Override
    public void onConflict(Task existingTask, Task newTask) {
        System.out.printf("Error: Task conflicts with existing task \"%s\".%n", existingTask.description());
    }
}
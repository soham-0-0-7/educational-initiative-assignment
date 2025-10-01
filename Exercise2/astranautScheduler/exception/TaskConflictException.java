package Exercise2.astranautScheduler.exception;
import Exercise2.astranautScheduler.model.Task;

public class TaskConflictException extends Exception {
    public TaskConflictException(Task existingTask, Task newTask) {
        super(String.format("Error: Task '%s' conflicts with existing task '%s'.",
                newTask.description(), existingTask.description()));
    }
}
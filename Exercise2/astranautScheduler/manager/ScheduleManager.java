
package Exercise2.astranautScheduler.manager;

import Exercise2.astranautScheduler.exception.TaskConflictException;
import Exercise2.astranautScheduler.model.Task;
import Exercise2.astranautScheduler.observer.ConflictNotifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ScheduleManager {
    // 1. The sole instance of ScheduleManager (Eager Initialization)
    private static final ScheduleManager INSTANCE = new ScheduleManager();

    private final List<Task> tasks;
    private final ConflictNotifier conflictNotifier;
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    // 2. Private constructor to prevent external instantiation
    private ScheduleManager() {
        tasks = new ArrayList<>();
        conflictNotifier = new ConflictNotifier();
    }

    // 3. Public static method to get the singleton instance
    public static ScheduleManager getInstance() {
        return INSTANCE;
    }

   
    public String addTask(Task newTask) throws TaskConflictException {
        lock.writeLock().lock();
        try {
            for (Task existingTask : tasks) {
                if (newTask.isOverlapping(existingTask)) {
                    conflictNotifier.notifyConflict(existingTask, newTask);
                    throw new TaskConflictException(existingTask, newTask);
                }
            }
            tasks.add(newTask);
            // Keep the list sorted by start time upon insertion
            tasks.sort(Comparator.comparing(Task::startTime));
            return String.format("Task \"%s\" added successfully. No conflicts.", newTask.description());
        } finally {
            lock.writeLock().unlock();
        }
    }

    public String removeTask(String description) {
        lock.writeLock().lock();
        try {
            Optional<Task> taskToRemove = tasks.stream()
                    .filter(task -> task.description().equalsIgnoreCase(description))
                    .findFirst();

            if (taskToRemove.isPresent()) {
                tasks.remove(taskToRemove.get());
                return String.format("Task \"%s\" removed successfully.", description);
            } else {
                return "Error: Task not found.";
            }
        } finally {
            lock.writeLock().unlock();
        }
    }


    public List<Task> getTasks() {
        lock.readLock().lock();
        try {
            // Return a copy to prevent external modifications
            return Collections.unmodifiableList(new ArrayList<>(tasks));
        } finally {
            lock.readLock().unlock();
        }
    }

    public ConflictNotifier getConflictNotifier() {
        return conflictNotifier;
    }
}
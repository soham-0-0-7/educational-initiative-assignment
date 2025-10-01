package Exercise2.astranautScheduler.observer;

import  Exercise2.astranautScheduler.model.Task;


public interface ConflictListener {
    void onConflict(Task existingTask, Task newTask);
}
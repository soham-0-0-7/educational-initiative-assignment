package Exercise2.astranautScheduler.observer;

import Exercise2.astranautScheduler.model.Task;
import java.util.ArrayList;
import java.util.List;


public class ConflictNotifier {
    private final List<ConflictListener> listeners = new ArrayList<>();

    public void subscribe(ConflictListener listener) {
        listeners.add(listener);
    }

    public void unsubscribe(ConflictListener listener) {
        listeners.remove(listener);
    }

    public void notifyConflict(Task existingTask, Task newTask) {
        for (ConflictListener listener : listeners) {
            listener.onConflict(existingTask, newTask);
        }
    }
}

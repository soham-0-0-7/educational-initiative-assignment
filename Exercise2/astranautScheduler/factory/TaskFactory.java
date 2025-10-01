package Exercise2.astranautScheduler.factory;

import Exercise2.astranautScheduler.model.Task;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;


public class TaskFactory {

    public static Task createTask(String description, String startTimeStr, String endTimeStr, String priority)
            throws DateTimeParseException, IllegalArgumentException {
        LocalTime startTime = LocalTime.parse(startTimeStr);
        LocalTime endTime = LocalTime.parse(endTimeStr);
        return new Task(description, startTime, endTime, priority);
    }
}
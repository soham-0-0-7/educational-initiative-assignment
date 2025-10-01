package Exercise2.astranautScheduler.model;

import java.time.LocalTime;
import java.util.Objects;


public record Task(String description, LocalTime startTime, LocalTime endTime, String priority) {

    public Task {
        Objects.requireNonNull(description, "Description cannot be null");
        Objects.requireNonNull(startTime, "Start time cannot be null");
        Objects.requireNonNull(endTime, "End time cannot be null");
        Objects.requireNonNull(priority, "Priority cannot be null");

        if (!endTime.isAfter(startTime)) {
            throw new IllegalArgumentException("End time must be after start time.");
        }
    }

  
    public boolean isOverlapping(Task other) {
        return this.startTime.isBefore(other.endTime) && this.endTime.isAfter(other.startTime);
    }

  
    @Override
    public String toString() {
        return String.format("%s - %s: %s [%s]",
                startTime,
                endTime,
                description,
                priority);
    }
}
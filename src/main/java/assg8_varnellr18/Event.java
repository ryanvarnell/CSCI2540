package assg8_varnellr18;

/**
 * Record of an event's time and type.
 * @author Ryan Varnell
 */
public class Event {
    private final int time;
    private final char type;

    Event(int time, char type) {
        this.time = time;
        this.type = type;
    }

    /**
     * Gets the time the event occurred.
     * @return Time the event occurred.
     */
    public int getTime() {
        return time;
    }

    /**
     * Gets the type of event that occurred.
     * @return Type of event that occurred.
     */
    public char getType() {
        return type;
    }
}

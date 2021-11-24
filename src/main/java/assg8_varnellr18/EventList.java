package assg8_varnellr18;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Class to contain arrival and departure events for the bank line simulation. Since the EventList class needed to
 * include methods that allowed it to insert, remove, or retrieve an event from itself, I thought it would be best to
 * just extend another class that could already do that.
 * @author Ryan Varnell
 */
public class EventList extends ArrayList<Event>{
    /**
     * Default constructor. Nothing special.
     */
    EventList() {
        super();
    }

    /**
     * Sorts the list by time of events.
     */
    void sort() {
        this.sort(Comparator.comparing(Event::getTime));

        // This is a really really really slow and bad way to ensure that arrival events always come before departure
        // events in the case that they share the same execution time. The loop just straight up iterates through the
        // entire event list and if it finds duplicate event times, it swaps the two events if the departure event is
        // listed first. Pressed for time so this is a band-aid fix but realistically this whole program is kind of a
        // mess.
        for (int i = 0; i < this.size() - 1; i++) {
            if (this.get(i).getTime() == this.get(i + 1).getTime()) {
                if (this.get(i).getType() == 'D') {
                    Event temp;
                    temp = this.get(i);
                    this.set(i, this.get(i + 1));
                    this.set(i + 1, temp);
                }
            }
        }
    }
}

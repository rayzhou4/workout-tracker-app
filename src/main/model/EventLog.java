package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

// Class that can represent the log of workout tracker events
// Used the Singleton Design Pattern to ensure there is only one
// globally-accessible EventLog instance
public class EventLog implements Iterable<Event> {
    private static EventLog theLog; // the only EventLog in the system (Singleton Design Pattern)
    private Collection<Event> events;

    // this
    // EFFECTS: contructs the EventLog instance
    private EventLog() {
        events = new ArrayList<Event>();
    }

    // EFFECTS: gets instance of EventLog (creates a new instance, if one doesn't exist yet)
    public static EventLog getInstance() {
        if (theLog == null) {
            theLog = new EventLog();
        }
        return theLog;
    }

    // EFFECTS: adds an event to the event log
    /**
     * Adds an event to the event log.
     * @param e the event to be added
     */
    public void logEvent(Event e) {
        events.add(e);
    }

    /**
     * Clears the event log and logs the event.
     */
    public void clear() {
        events.clear();
        logEvent(new Event("Event log cleared."));
    }

    @Override
    public Iterator<Event> iterator() {
        return events.iterator();
    }
}

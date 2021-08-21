package demo.pattern.eventmode;

import java.util.ArrayList;
import java.util.List;

/**
 * User: BigStrong
 * Date: 2021/8/21
 * Description: No Description
 */
public class EventSource {

    private List<EventListener> listeners = new ArrayList<>();

    public void register(EventListener eventListener) {
       this.listeners.add(eventListener);
    }

    public void publicEvent(Event event) {
        for (EventListener listener : listeners) {
            listener.processEvent(event);
        }
    }
}

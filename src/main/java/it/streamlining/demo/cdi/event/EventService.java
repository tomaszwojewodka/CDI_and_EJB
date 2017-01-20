package it.streamlining.demo.cdi.event;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;

@RequestScoped
public class EventService {
    @Inject
    private Event<MyEvent> event;

    public void fire(MyEvent myEvent) {
        event.fire(myEvent);
    }
}

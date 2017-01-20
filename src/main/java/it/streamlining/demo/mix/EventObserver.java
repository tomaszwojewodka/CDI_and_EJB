package it.streamlining.demo.mix;

import it.streamlining.demo.cdi.event.MyEvent;
import it.streamlining.demo.ejb.AsynchronousEjb;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.enterprise.event.Observes;

@Stateless
public class EventObserver {
    final Logger logger = LoggerFactory.getLogger(EventObserver.class);

    @Asynchronous
    public void handleEvent(@Observes MyEvent event) throws InterruptedException {
        //        Don't try it at home
        Thread.sleep(5000);
        logger.info("Event Observer");
    }
}

package it.streamlining.demo.mix;

import it.streamlining.demo.cdi.CdiView;
import it.streamlining.demo.cdi.event.EventService;
import it.streamlining.demo.cdi.event.MyEvent;
import it.streamlining.demo.ejb.AsynchronousEjb;
import it.streamlining.demo.ejb.scope.SingletonEjb;
import it.streamlining.demo.ejb.scope.StatefulEjb;
import it.streamlining.demo.ejb.scope.StatelessEjb;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Named
@Stateless
public class MixView {
    final Logger logger = LoggerFactory.getLogger(MixView.class);

    @Inject
    private StatelessEjb statelessEjb;

    @Inject
    private StatefulEjb statefulEjb;

    @Inject
    private SingletonEjb singletonEjb;

    @Inject
    private AsynchronousEjb asynchronousEjb;

    @Inject
    private EventService eventService;

    @PostConstruct
    public void init() {
        logger.info("Initializing RequestScoped CdiView");
    }

    public String getInfo() {
        statelessEjb.increase();
        statefulEjb.increase();
        singletonEjb.increase();
        eventService.fire(new MyEvent("Tomaszs' event"));
        return "MIX";
    }

    public String getStatelessCounter() {
        return statelessEjb.getCounter();
    }

    public String getStatefulCounter() {
        return statefulEjb.getCounter();
    }

    public String getSingletonCounter() {
        return singletonEjb.getCounter();
    }

    public String getAsynchronous() throws InterruptedException, ExecutionException {
        asynchronousEjb.async();
        return "Calling async";
    }
}

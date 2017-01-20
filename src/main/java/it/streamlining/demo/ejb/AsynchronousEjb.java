package it.streamlining.demo.ejb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import java.util.Date;

@Stateless
public class AsynchronousEjb {
    final Logger logger = LoggerFactory.getLogger(AsynchronousEjb.class);
    @Asynchronous
    public void async() throws InterruptedException {
//        Don't try it at home
        Thread.sleep(5000);
        logger.info("Async time {}", String.valueOf(new Date()));
    }
}

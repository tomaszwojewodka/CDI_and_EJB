package it.streamlining.demo.mix;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;

public class BaseBean {
    final Logger logger = LoggerFactory.getLogger(BaseBean.class);

    @PostConstruct
    public void init() {
        logger.info("Initializing {}", getClass().getName());
    }
    int counter = 0;

    public void increase() {
        counter++;
    }

    public String getCounter() {
        return String.valueOf(counter);
    }
}

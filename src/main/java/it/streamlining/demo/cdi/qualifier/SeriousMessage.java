package it.streamlining.demo.cdi.qualifier;

import javax.enterprise.inject.Default;

//@Serious
@Default
public class SeriousMessage implements Message {
    @Override
    public String getMessage() {
        return "Serious Message";
    }
}

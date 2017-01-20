package it.streamlining.demo.cdi.qualifier;

@Fun
public class FunMessage implements Message {
    @Override
    public String getMessage() {
        return "Fun Message";
    }
}

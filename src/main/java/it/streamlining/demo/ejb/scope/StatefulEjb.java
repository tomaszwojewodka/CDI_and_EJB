package it.streamlining.demo.ejb.scope;

import it.streamlining.demo.mix.BaseBean;

import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@Stateful
@SessionScoped
public class StatefulEjb extends BaseBean implements Serializable {
}

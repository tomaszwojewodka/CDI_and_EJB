package it.streamlining.demo.cdi.scope;

import it.streamlining.demo.mix.BaseBean;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@SessionScoped
public class SessionScopedBean extends BaseBean implements Serializable{

}

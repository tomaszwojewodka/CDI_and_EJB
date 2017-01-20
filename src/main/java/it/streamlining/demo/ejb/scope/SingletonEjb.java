package it.streamlining.demo.ejb.scope;

import it.streamlining.demo.mix.BaseBean;

import javax.ejb.Singleton;
import javax.ejb.Stateful;

@Singleton
// TODO: 20.01.2017 Add @Startup and @Scheduler
public class SingletonEjb extends BaseBean {
}

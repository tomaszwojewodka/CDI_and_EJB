package it.streamlining.demo.cdi;

import it.streamlining.demo.cdi.qualifier.Fun;
import it.streamlining.demo.cdi.qualifier.Message;
import it.streamlining.demo.cdi.scope.ApplicationScopedBean;
import it.streamlining.demo.cdi.scope.RequestScopedBean;
import it.streamlining.demo.cdi.scope.SessionScopedBean;
import it.streamlining.demo.mix.JustAPojo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

//@Model
@Named
@RequestScoped
public class CdiView {
    final Logger logger = LoggerFactory.getLogger(CdiView.class);

    @Inject
    private JustAPojo justAPojo;

    @Inject
    private RequestScopedBean requestScopedBean;

    @Inject
    private SessionScopedBean sessionScopedBean;

    @Inject
    private ApplicationScopedBean applicationScopedBean;

    @Inject
//    @Serious
    @Fun
    private Message message;

    @PostConstruct
    public void init() {
        logger.info("Initializing RequestScoped CdiView");
    }

    public String getInfo() {
        requestScopedBean.increase();
        sessionScopedBean.increase();
        applicationScopedBean.increase();
        return "CDI";
    }

    public String getRequestScopedBeanCounter() {
        return requestScopedBean.getCounter();
    }

    public String getSessionScopedBeanCounter() {
        return sessionScopedBean.getCounter();
    }

    public String getApplicationScopedBeanCounter() {
        return applicationScopedBean.getCounter();
    }

    public String getMessage() {
        return message.getMessage();
    }

    public String getPojoMessage() {
        return justAPojo.getMessage();
    }

    @PreDestroy
    private void destroy() {
        logger.info("Destroying RequestScoped CdiView");
    }
}

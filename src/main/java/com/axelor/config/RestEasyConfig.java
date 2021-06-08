package com.axelor.config;

import com.axelor.controller.ContactController;

import javax.ws.rs.core.Application;
import java.util.Collections;
import java.util.Set;

public class RestEasyConfig extends Application {
    private Set<Object> set= Collections.emptySet();

    static {
        System.out.println("const");
    }
    public RestEasyConfig() {

        set.add(new ContactController());
    }

    @Override
    public Set<Object> getSingletons() {
        return set;
    }

}

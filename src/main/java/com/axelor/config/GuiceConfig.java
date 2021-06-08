package com.axelor.config;

import com.axelor.controller.ContactController;
import com.axelor.controller.ContactControllerJSP;
import com.axelor.service.ContactService;
import com.axelor.service.impl.ContactServiceImpl;
import com.google.inject.AbstractModule;

public class GuiceConfig extends AbstractModule {
    @Override
    public void configure() {
        bind(ContactController.class);
        bind(ContactControllerJSP.class);
        bind(ContactService.class).to(ContactServiceImpl.class);

    }
}

package com.newage.erp.common.controllers;

import com.newage.erp.security.services.SecurityService;
import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.security.enterprise.SecurityContext;

/**
 *
 * @author mohammed
 */
@Named(value = "testController")
@ViewScoped
public class TestController implements Serializable {

    @Inject
    private SecurityService ss;
    @Inject
    private SecurityContext sc;

    public void test() {
        System.out.println(ss.hasPermission("SecurityUser.list"));
        System.out.println(sc.isCallerInRole("SecurityUser.list"));
    }

}

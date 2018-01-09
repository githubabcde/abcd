package com.newage.erp.common.controllers;

import com.newage.erp.common.services.GeneralDAO;
import com.newage.erp.security.entities.SecurityUser;
import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author mohammed
 */
@Named(value = "testController")
@ViewScoped
public class TestController implements Serializable {

    @Inject
    private GeneralDAO generalDAO;
    
    public void test() {
        System.out.println(generalDAO.getNewId(SecurityUser.class));
    }

}

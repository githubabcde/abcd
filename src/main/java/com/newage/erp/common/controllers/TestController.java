package com.newage.erp.common.controllers;

import com.newage.erp.common.services.DataAccessObject;
import com.newage.erp.security.entities.SecurityUser;
import com.newage.erp.security.services.SecurityUserService;
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
    private SecurityUserService dao;
    
    public void test() {
        
    }

}

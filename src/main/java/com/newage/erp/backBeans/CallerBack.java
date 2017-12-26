package com.newage.erp.backBeans;

import com.newage.erp.entities.security.ErpUser;
import com.newage.erp.services.GeneralDAO;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author mohammed
 */
@Named
@ViewScoped
public class CallerBack implements Serializable {

    @Inject
    private GeneralDAO generalDAO;

    /**
     * Creates a new instance of CallerBack
     */
    public CallerBack() {
    }

    public List<ErpUser> getCallers() {
        System.out.println("com.newage.erp.backBeans.CallerBack.getCallers()");
        return generalDAO.find(ErpUser.class);
    }
    
    public void create() {
        System.out.println("com.newage.erp.backBeans.CallerBack.create()");
//        generalDAO.persist(new Caller(1l), 1l);
    }
    
    public String hello() {
        return "hello from back";
    }

}

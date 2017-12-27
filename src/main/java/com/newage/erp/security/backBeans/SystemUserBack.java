package com.newage.erp.security.backBeans;

import com.newage.erp.security.entities.SecurityUser;
import com.newage.erp.common.services.GeneralDAO;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author mohammed
 */
@Named(value = "systemUserBack")
@ViewScoped
public class SystemUserBack implements Serializable {

    @Inject
    private GeneralDAO generalDAO;

    /**
     * Creates a new instance of CallerBack
     */
    public SystemUserBack() {
    }

    public List<SecurityUser> getCallers() {
        return generalDAO.find(SecurityUser.class);
    }

    public void create() {
        SecurityUser securityUser = new SecurityUser(1l);
        securityUser.setName("Mohammed");
        generalDAO.persist(securityUser, 1l);
    }

}

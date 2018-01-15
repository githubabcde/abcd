package com.newage.erp.security.controllers;

import static com.newage.erp.common.controllers.utli.Helper.message;
import com.newage.erp.security.entities.SecurityUser;
import com.newage.erp.security.services.SecurityUserService;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author mohammed
 */
@Named(value = "userController")
@ViewScoped
public class UserController implements Serializable {

    private SecurityUser item;
    private List<SecurityUser> items;

    @Inject
    private SecurityUserService securityUserService;

    public void prepareList() {
        items = securityUserService.find(SecurityUser.class);
    }

    public void prepareAdd() {
        item = new SecurityUser();
    }

    public void prepareEdit(Long id) {
        item = securityUserService.find(SecurityUser.class, id);
    }

    public void add() {
        securityUserService.persist(item);
        message(FacesMessage.SEVERITY_INFO, "saved");
        prepareAdd();
    }

    public String edit() {
        securityUserService.merge(item);
        return "list?faces-redirect=true";
    }

    public String remove() {
        securityUserService.remove(item);
        return "list?faces-redirect=true";
    }

    public SecurityUser getItem() {
        return item;
    }

    public void setItem(SecurityUser item) {
        this.item = item;
    }

    public List<SecurityUser> getItems() {
        return items;
    }

    public void setItems(List<SecurityUser> items) {
        this.items = items;
    }
}

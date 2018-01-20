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
        items = securityUserService.find();
    }

    public void prepareCreate() {
        item = new SecurityUser();
    }

    public void prepareUpdate(Long id) {
        item = securityUserService.find(id);
    }

    public void create() {
        securityUserService.create(item);
        message(FacesMessage.SEVERITY_INFO, "saved");
        prepareCreate();
    }

    public String update() {
        securityUserService.update(item);
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

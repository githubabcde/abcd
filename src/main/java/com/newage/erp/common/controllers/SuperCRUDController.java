package com.newage.erp.common.controllers;

import static com.newage.erp.common.controllers.utli.Helper.redirect;
import com.newage.erp.common.entities.SuperEntity;
import com.newage.erp.common.services.SuperCRUDService;
import com.newage.erp.common.services.SecurityService;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import static com.newage.erp.common.controllers.utli.Helper.addFacesMessage;
import javax.ejb.EJBAccessException;

/**
 *
 * @author mohammed
 * @param <T>
 */
public class SuperCRUDController<T extends SuperEntity> implements Serializable {

    protected T item;
    protected List<T> items;

    protected SuperCRUDService<T> supperCRUDService;

    @Inject
    protected SecurityService ss;

    public void prepareList() {
        try {
            items = supperCRUDService.find();
        } catch (EJBAccessException e) {
            redirect("/error403.xhtml");
        }
    }

    public void prepareCreate() {
        if (!ss.hasPermission(supperCRUDService.getEntityClass().getSimpleName() + ".create")) {
            redirect("/error403.xhtml");
            return;
        }
        try {
            Constructor<T> constructor = supperCRUDService.getEntityClass().getDeclaredConstructor();
            item = constructor.newInstance();
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(SuperCRUDController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void prepareUpdate(Long id) {
        if (!ss.hasPermission(supperCRUDService.getEntityClass().getSimpleName() + ".update")) {
            redirect("/error403.xhtml");
            return;
        }
        item = supperCRUDService.find(id);
    }

    public void create() {
        try {
            supperCRUDService.create(item);
            addFacesMessage(FacesMessage.SEVERITY_INFO, "saved");
            prepareCreate();
        } catch (EJBAccessException e) {
            redirect("/error403.xhtml");
        }
    }

    public String update() {
        try {
            supperCRUDService.update(item);
            addFacesMessage(FacesMessage.SEVERITY_INFO, "updated");
            return "list?faces-redirect=true";
        } catch (EJBAccessException e) {
            redirect("/error403.xhtml");
            return "/error403.xhtml";
        }
    }

    public String remove() {
        try {
            supperCRUDService.remove(item);
            addFacesMessage(FacesMessage.SEVERITY_INFO, "removed");
            return "list?faces-redirect=true";
        } catch (EJBAccessException e) {
            redirect("/error403.xhtml");
            return "/error403.xhtml";
        }
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}

package com.newage.erp.common.controllers;

import static com.newage.erp.common.controllers.utli.Helper.message;
import static com.newage.erp.common.controllers.utli.Helper.redirect;
import com.newage.erp.common.entities.SupperEntity;
import com.newage.erp.common.services.SupperCRUDService;
import com.newage.erp.security.services.SecurityService;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJBAccessException;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;

/**
 *
 * @author mohammed
 * @param <T>
 */
public class SupperCRUDController<T extends SupperEntity> implements Serializable {

    protected T item;
    protected List<T> items;

    protected Class clazz;
    protected SupperCRUDService<T> supperCRUDService;
    
    @Inject
    protected SecurityService ss;

    public void prepareList() throws EJBAccessException {
        if (!ss.hasPermission(clazz.getSimpleName()+".desplay")) {
            redirect("/error403.xhtml");
            return;
        }
        items = supperCRUDService.find();
    }

    public void prepareCreate() {
        if (!ss.hasPermission(clazz.getSimpleName()+".create")) {
            redirect("/error403.xhtml");
            return;
        }
        try {
            Constructor<T> constructor = clazz.getDeclaredConstructor();
            item = constructor.newInstance();
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(SupperCRUDController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void prepareUpdate(Long id) {
        if (!ss.hasPermission(clazz.getSimpleName()+".update")) {
            redirect("/error403.xhtml");
            return;
        }
        item = supperCRUDService.find(id);
    }

    public void create() {
        supperCRUDService.create(item);
        message(FacesMessage.SEVERITY_INFO, "saved");
        prepareCreate();
    }

    public String update() {
        supperCRUDService.update(item);
        return "list?faces-redirect=true";
    }

    public String remove() {
        if (!ss.hasPermission(clazz.getSimpleName()+".remove")) {
            redirect("/error403.xhtml");
            return "/error403.xhtml";
        }
        supperCRUDService.remove(item);
        return "list?faces-redirect=true";
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

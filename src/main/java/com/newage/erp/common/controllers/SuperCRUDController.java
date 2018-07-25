package com.newage.erp.common.controllers;

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
        items = supperCRUDService.find();
    }

    public void prepareCreate() {
        try {
            Constructor<T> constructor = supperCRUDService.getEntityClass().getDeclaredConstructor();
            item = constructor.newInstance();
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(SuperCRUDController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void prepareUpdate(Long id) {
        item = supperCRUDService.find(id);
    }

    public void create() {
        supperCRUDService.create(item);
        addFacesMessage(FacesMessage.SEVERITY_INFO, "saved");
        prepareCreate();
    }

    public String update() {
        supperCRUDService.update(item);
        addFacesMessage(FacesMessage.SEVERITY_INFO, "updated");
        return "list?faces-redirect=true";
    }

    public String remove() {
        supperCRUDService.remove(item);
        addFacesMessage(FacesMessage.SEVERITY_INFO, "removed");
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

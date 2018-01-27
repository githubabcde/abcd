package com.newage.erp.common.controllers;

import static com.newage.erp.common.controllers.utli.Helper.message;
import com.newage.erp.common.entities.SupperEntity;
import com.newage.erp.common.services.SupperCRUDService;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;

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

    public void prepareList() {
        items = supperCRUDService.find();
    }

    public void prepareCreate() {
        try {
            Constructor<T> constructor = clazz.getDeclaredConstructor();
            item = constructor.newInstance();
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(SupperCRUDController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void prepareUpdate(Long id) {
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

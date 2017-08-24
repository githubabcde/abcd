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
public class SuperCRUDController<E extends SuperEntity, S extends SuperCRUDService<E>> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	protected E item;
    protected List<E> items;

    @Inject
    protected S service;

    @Inject
    protected SecurityService ss;

    public void prepareList() {
    	item = null;
        items = service.find();
    }

    public void prepareCreate() {
        try {
            Constructor<E> constructor = service.getEntityClass().getDeclaredConstructor();
            item = constructor.newInstance();
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(SuperCRUDController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void prepareUpdate(Long id) {
        item = service.find(id);
    }

    public void create() {
        service.create(item);
        addFacesMessage(FacesMessage.SEVERITY_INFO, "saved");
        prepareCreate();
    }

    public String update() {
        service.update(item);
        addFacesMessage(FacesMessage.SEVERITY_INFO, "updated");
        item = null;
        return "list?faces-redirect=true";
    }

    public String remove() {
        service.remove(item);
        addFacesMessage(FacesMessage.SEVERITY_INFO, "removed");
        item = null;
        return "list?faces-redirect=true";
    }

    public E getItem() {
        return item;
    }

    public void setItem(E item) {
        this.item = item;
    }

    public List<E> getItems() {
        return items;
    }

    public void setItems(List<E> items) {
        this.items = items;
    }
}

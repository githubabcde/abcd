package com.newage.erp.converters;

import com.newage.erp.entities.security.ErpUser;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author mohammed
 */
public class CallerConverter implements Converter<ErpUser> {

    @Override
    public ErpUser getAsObject(FacesContext context, UIComponent component, String value) {
        return new ErpUser(Long.parseLong(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, ErpUser value) {
        return value.getId().toString();
    }

}

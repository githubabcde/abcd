package com.newage.erp.security.converters;

import com.newage.erp.security.entities.SecurityUser;
import java.util.Objects;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author mohammed
 */
public class SecurityUserConverter implements Converter<SecurityUser> {

    @Override
    public SecurityUser getAsObject(FacesContext context, UIComponent component, String value) {
        return Objects.isNull(value) ? null : new SecurityUser(Long.parseLong(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, SecurityUser value) {
        return Objects.isNull(value) ? null : value.getId().toString();
    }

}
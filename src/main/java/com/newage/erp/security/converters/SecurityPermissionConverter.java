package com.newage.erp.security.converters;

import com.newage.erp.security.entities.SecurityPermission;
import java.util.Objects;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author mohammed
 */
@FacesConverter(value = "securityPermissionConverter")
public class SecurityPermissionConverter implements Converter<SecurityPermission> {

    @Override
    public SecurityPermission getAsObject(FacesContext context, UIComponent component, String value) {
        return Objects.isNull(value) ? null : new SecurityPermission(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, SecurityPermission value) {
        return Objects.isNull(value) ? null : value.getId().toString();
    }

}

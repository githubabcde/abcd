package com.newage.erp.security.converters;

import com.newage.erp.security.entities.SecurityGroup;
import java.util.Objects;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author mohammed
 */
@FacesConverter(value = "securityGroupConverter")
public class SecurityGroupConverter implements Converter<SecurityGroup> {

    @Override
    public SecurityGroup getAsObject(FacesContext context, UIComponent component, String value) {
        return Objects.isNull(value) ? null : new SecurityGroup(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, SecurityGroup value) {
        return Objects.isNull(value) ? null : value.getId().toString();
    }

}

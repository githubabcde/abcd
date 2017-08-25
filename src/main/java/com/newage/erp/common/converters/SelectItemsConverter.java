package com.newage.erp.common.converters;

import java.util.Objects;
import java.util.Vector;

import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.newage.erp.common.entities.SuperEntity;

/**
 *
 * @author mohammed
 */
@FacesConverter(value = "selectItemsConverter")
public class SelectItemsConverter implements Converter<SuperEntity> {

	@Override
	public SuperEntity getAsObject(FacesContext context, UIComponent component, String value) {
		for (Object child : component.getChildren()) {
			if (child instanceof UISelectItems) {
				Vector<SuperEntity> items = (Vector<SuperEntity>) ((UISelectItems) child).getValue();
				for (SuperEntity item : items) {
					if (Objects.equals(item.getId(), Long.valueOf(value))) {
						return item;
					}
				}
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, SuperEntity value) {
		return Objects.isNull(value) ? null : value.getId().toString();
	}
}

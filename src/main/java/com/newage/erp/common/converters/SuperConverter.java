package com.newage.erp.common.converters;

import java.util.Objects;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.newage.erp.common.entities.SuperEntity;

/**
 *
 * @author mohammed
 */
@FacesConverter(value = "superConverter")
public class SuperConverter<T extends SuperEntity> implements Converter<T> {

	@Override
	public T getAsObject(FacesContext context, UIComponent component, String value) {
		return Objects.isNull(value) ? null : (T) new SuperEntity(Long.valueOf(value));
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, T value) {
		return Objects.isNull(value) ? null : value.getId().toString();
	}
}

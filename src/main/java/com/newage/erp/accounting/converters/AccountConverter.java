package com.newage.erp.accounting.converters;

import java.util.Objects;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.newage.erp.accounting.entities.Account;

/**
 *
 * @author mohammed
 */
@FacesConverter(value = "accountConverter")
public class AccountConverter implements Converter<Account> {

	@Override
	public Account getAsObject(FacesContext context, UIComponent component, String value) {
		return Objects.isNull(value) ? null : new Account(Long.valueOf(value));
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Account value) {
		return Objects.isNull(value) ? null : value.getId().toString();
	}
}

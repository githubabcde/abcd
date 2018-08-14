package com.newage.erp.accounting.converters;

import java.util.Objects;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.newage.erp.accounting.entities.Currency;

/**
 *
 * @author mohammed
 */
@FacesConverter(value = "currencyConverter")
public class CurrencyConverter implements Converter<Currency> {

    @Override
    public Currency getAsObject(FacesContext context, UIComponent component, String value) {
        return Objects.isNull(value) ? null : new Currency(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Currency value) {
        return Objects.isNull(value) ? null : value.getId().toString();
    }

}

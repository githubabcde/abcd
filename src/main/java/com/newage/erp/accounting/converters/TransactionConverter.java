package com.newage.erp.accounting.converters;

import java.util.Objects;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.newage.erp.accounting.entities.Transaction;

/**
 *
 * @author mohammed
 */
@FacesConverter(value = "transactionConverter")
public class TransactionConverter implements Converter<Transaction> {

    @Override
    public Transaction getAsObject(FacesContext context, UIComponent component, String value) {
        return Objects.isNull(value) ? null : new Transaction(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Transaction value) {
        return Objects.isNull(value) ? null : value.getId().toString();
    }

}

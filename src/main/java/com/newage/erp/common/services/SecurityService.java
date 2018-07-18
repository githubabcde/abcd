package com.newage.erp.common.services;

import java.util.Objects;
import javax.ejb.EJBAccessException;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.security.enterprise.SecurityContext;

/**
 *
 * @author mohammed
 */
@Stateless
public class SecurityService {

    @Inject
    private SecurityContext sc;

    public boolean hasPermission(String permission) {
        if (Objects.equals(sc.getCallerPrincipal().getName(), "admin")) {
            return true;
        }
        return sc.isCallerInRole(permission);
    }

    public void applyPermission(String permission) {
        if (!hasPermission(permission)) {
            throw new EJBAccessException();
        }
    }
}

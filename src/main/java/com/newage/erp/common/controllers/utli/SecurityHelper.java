package com.newage.erp.common.controllers.utli;

import com.newage.erp.security.services.SecurityService;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.security.enterprise.AuthenticationException;

/**
 *
 * @author mohammed
 */
@SessionScoped
public class SecurityHelper implements Serializable {

    @Inject
    private SecurityService securityService;

    public void applySecurty(String permission) throws AuthenticationException {
        if (!securityService.hasPermission(permission)) {
            throw new javax.security.enterprise.AuthenticationException(permission+": mot permited");
        }
    }
}

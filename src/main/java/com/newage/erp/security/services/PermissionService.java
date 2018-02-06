package com.newage.erp.security.services;

import com.newage.erp.common.services.SupperCRUDService;
import com.newage.erp.security.entities.SecurityPermission;
import javax.annotation.security.DeclareRoles;
import javax.ejb.Stateless;

/**
 *
 * @author mohammed
 */
@Stateless
@DeclareRoles({"SecurityPermission.create", "SecurityPermission.remove", "SecurityPermission.update", "SecurityPermission.desplay"})
public class PermissionService extends SupperCRUDService<SecurityPermission> {

    public PermissionService() {
        super(SecurityPermission.class);
    }
}

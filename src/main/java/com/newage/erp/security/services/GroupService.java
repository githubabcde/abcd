package com.newage.erp.security.services;

import com.newage.erp.common.services.SupperCRUDService;
import com.newage.erp.security.entities.SecurityGroup;
import javax.annotation.security.DeclareRoles;
import javax.ejb.Stateless;

/**
 *
 * @author mohammed
 */
@Stateless
@DeclareRoles({"SecurityGroup.create", "SecurityGroup.remove", "SecurityGroup.update", "SecurityGroup.desplay"})
public class GroupService extends SupperCRUDService<SecurityGroup> {

    public GroupService() {
        super(SecurityGroup.class);
    }
}

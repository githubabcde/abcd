package com.newage.erp.security.controllers;

import com.newage.erp.common.controllers.SupperCRUDController;
import com.newage.erp.security.entities.SecurityPermission;
import com.newage.erp.security.services.PermissionService;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author mohammed
 */
@Named
@ViewScoped
public class PermissionController extends SupperCRUDController<SecurityPermission> {

    @Inject
    private PermissionService groupService;

    @PostConstruct
    private void init() {
        super.clazz = SecurityPermission.class;
        super.supperCRUDService = groupService;
    }
}

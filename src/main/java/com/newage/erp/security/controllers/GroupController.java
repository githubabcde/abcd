package com.newage.erp.security.controllers;

import com.newage.erp.common.controllers.SupperCRUDController;
import com.newage.erp.security.entities.SecurityGroup;
import com.newage.erp.security.services.GroupService;
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
public class GroupController extends SupperCRUDController<SecurityGroup> {

    @Inject
    private GroupService groupService;

    @PostConstruct
    private void init() {
        super.supperCRUDService = groupService;
    }
}
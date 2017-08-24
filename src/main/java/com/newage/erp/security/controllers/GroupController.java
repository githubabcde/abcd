package com.newage.erp.security.controllers;

import com.newage.erp.common.controllers.SuperCRUDController;
import com.newage.erp.security.entities.SecurityGroup;
import com.newage.erp.security.services.GroupService;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author mohammed
 */
@Named
@ViewScoped
public class GroupController extends SuperCRUDController<SecurityGroup, GroupService> {
}

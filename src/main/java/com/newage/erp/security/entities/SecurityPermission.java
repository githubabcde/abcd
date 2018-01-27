package com.newage.erp.security.entities;

import com.newage.erp.common.entities.StampedEntity;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author mohammed
 */
@Entity(name = "SecurityPermission")
@Table(name = "SECURITY_PERMISSION")
public class SecurityPermission extends StampedEntity {

    @Column(name = "NAME", unique = true, nullable = false)
    private String name;
    @ManyToMany(mappedBy = "permissions")
    private List<SecurityUser> users;
    @ManyToMany(mappedBy = "permissions")
    private List<SecurityGroup> groups;

    public SecurityPermission() {
    }
    
    public SecurityPermission(Long id) {
        super(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SecurityUser> getUsers() {
        return users;
    }

    public void setUsers(List<SecurityUser> users) {
        this.users = users;
    }

    public List<SecurityGroup> getGroups() {
        return groups;
    }

    public void setGroups(List<SecurityGroup> groups) {
        this.groups = groups;
    }
}

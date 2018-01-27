package com.newage.erp.security.entities;

import com.newage.erp.common.entities.StampedEntity;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author mohammed
 */
@Entity(name = "SecurityGroup")
@Table(name = "SECURITY_GROUP")
public class SecurityGroup extends StampedEntity {

    @Column(name = "NAME", unique = true, nullable = false)
    private String name;
    @ManyToMany(mappedBy = "groups")
    private List<SecurityUser> users;
    @ManyToMany
    @JoinTable(name = "GROUP_PERMISSION",
            joinColumns = @JoinColumn(name = "GROUP_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "PERMISSION_ID", referencedColumnName = "ID"))
    private List<SecurityPermission> permissions;

    public SecurityGroup() {
    }

    public String getName() {
        return name;
    }

    public SecurityGroup(Long id) {
        super(id);
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

    public List<SecurityPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<SecurityPermission> permissions) {
        this.permissions = permissions;
    }
}

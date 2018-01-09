package com.newage.erp.security.entities;

import com.newage.erp.common.entities.EntityMasterStamped;
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
@Entity(name = "SecurityUser")
@Table(name = "SECURITY_USER")
public class SecurityUser extends EntityMasterStamped {

    @Column(name = "NAME", unique = true, nullable = false)
    private String name;
    @Column(name = "PASSWORD")
    private String password;
    @ManyToMany
    @JoinTable(name = "USER_GROUP",
            joinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "GROUP_ID", referencedColumnName = "ID"))
    List<SecurityGroup> groups;
    @ManyToMany
    @JoinTable(name = "USER_PERMISSION",
            joinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "PERMISSION_ID", referencedColumnName = "ID"))
    List<SecurityPermission> permissions;

    public SecurityUser() {
    }

    public SecurityUser(Long id) {
        super(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<SecurityGroup> getGroups() {
        return groups;
    }

    public void setGroups(List<SecurityGroup> groups) {
        this.groups = groups;
    }

    public List<SecurityPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<SecurityPermission> permissions) {
        this.permissions = permissions;
    }

}

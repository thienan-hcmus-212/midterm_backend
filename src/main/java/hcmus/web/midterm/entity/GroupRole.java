package hcmus.web.midterm.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GroupRole {

    @Id
    private String roleName;
    private String roleDescription;

    public GroupRole(String roleName, String roleDescription) {
        this.roleName = roleName;
        this.roleDescription = roleDescription;
    }

    public GroupRole() {

    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }
}

package hcmus.web.midterm.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User {

    private String userFirstName;

    @Id
    private String userEmail;

    private String userLastName;
    private String userPassword;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLE",
            joinColumns = {
                    @JoinColumn(name = "USER_ID")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "ROLE_ID")
            }
    )
    private Set<Role> role;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_GROUPS",
            joinColumns = {
                    @JoinColumn(name = "USER_ID")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "GROUP_ID")
            }
    )
    private Set<GroupDetails> groups;

    public Set<GroupDetails> getGroups() {
        return groups;
    }

    public void setGroups(Set<GroupDetails> groups) {
        this.groups = groups;
    }

    public void addGroup(GroupDetails group){
        this.groups.add(group);
    }

//    private Set<GroupMember> userGroups = new HashSet<GroupMember>();
//    @OneToMany(mappedBy = "primaryKey.user",
//            cascade = CascadeType.ALL)
//    public Set<GroupMember> getUserGroups() {
//        return userGroups;
//    }
//
//    public void setUserGroups(Set<GroupMember> userGroups) {
//        this.userGroups = userGroups;
//    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}

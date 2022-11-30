package hcmus.web.midterm.entity;

import javax.persistence.*;
//
//@Entity
//@Table(name = "USERS_GROUPS")
//@AssociationOverrides({
//        @AssociationOverride(name = "primaryKey.user",
//                joinColumns = @JoinColumn(name = "USER_ID")),
//        @AssociationOverride(name = "primaryKey.groupDetails",
//                joinColumns = @JoinColumn(name = "GROUP_ID")) })
//public class GroupMember {
//    private GroupMemberId primaryKey = new GroupMemberId();
//
//    private GroupRole groupRole;
//
//    @EmbeddedId
//    public GroupMemberId getPrimaryKey() {
//        return primaryKey;
//    }
//
//    public void setPrimaryKey(GroupMemberId primaryKey) {
//        this.primaryKey = primaryKey;
//    }
//
//    @ManyToOne
//    public GroupRole getGroupRole() {
//        return groupRole;
//    }
//
//    public void setGroupRole(GroupRole groupRole) {
//        this.groupRole = groupRole;
//    }
//}

@Entity
public class GroupMember{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userEmail;

    private Long groupId;

    private String roleName;

    public GroupMember(String userEmail, Long groupId, String roleName) {
        this.userEmail = userEmail;
        this.groupId = groupId;
        this.roleName = roleName;
    }

    public GroupMember() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }


    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}

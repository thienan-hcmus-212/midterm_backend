package hcmus.web.midterm.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Entity
public class GroupDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    private Set<GroupMember> members = new HashSet<GroupMember>();

    public GroupDetails() {

    }

    public void addMember(GroupMember member){
        this.members.add(member);
    }

    public GroupDetails(String name) {
        this.name = name;
    }

    public Set<GroupMember> getMembers() {
        return members;
    }

    public void setMembers(Set<GroupMember> members) {
        this.members = members;
    }

    //    private Set<GroupMember> userGroups = new HashSet<GroupMember>();
//
//    @OneToMany(mappedBy = "primaryKey.groupDetails",
//            cascade = CascadeType.ALL)
//    public Set<GroupMember> getUserGroups() {
//        return userGroups;
//    }
//
//    public void setUserGroups(Set<GroupMember> userGroups) {
//        this.userGroups = userGroups;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

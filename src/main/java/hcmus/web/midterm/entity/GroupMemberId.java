//package hcmus.web.midterm.entity;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Embeddable;
//import javax.persistence.ManyToOne;
//import java.io.Serializable;
//
//@Embeddable
//public class GroupMemberId implements Serializable {
//    private User user;
//    private GroupDetails groupDetails;
//
//    @ManyToOne(cascade = CascadeType.ALL)
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    @ManyToOne(cascade = CascadeType.ALL)
//    public GroupDetails getGroupDetails() {
//        return groupDetails;
//    }
//
//    public void setGroupDetails(GroupDetails groupDetails) {
//        this.groupDetails = groupDetails;
//    }
//}

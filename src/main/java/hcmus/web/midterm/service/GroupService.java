package hcmus.web.midterm.service;


import hcmus.web.midterm.dao.GroupDetailsDao;
import hcmus.web.midterm.dao.GroupMemberDao;
import hcmus.web.midterm.dao.GroupRoleDao;
import hcmus.web.midterm.dao.UserDao;
import hcmus.web.midterm.entity.GroupDetails;
import hcmus.web.midterm.entity.GroupMember;
import hcmus.web.midterm.entity.GroupRole;
import hcmus.web.midterm.entity.User;
import hcmus.web.midterm.payload.MessagePayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class GroupService {

    @Autowired
    private GroupDetailsDao groupDao;

    @Autowired
    private GroupMemberDao groupMemberDao;

    @Autowired
    private GroupRoleDao groupRoleDao;

    @Autowired
    private UserDao userDao;

    public void initRoleAndGroup(){
        GroupRole roleOwner = new GroupRole("Owner","User first create a group");
        groupRoleDao.save(roleOwner);

        GroupRole roleCoOwner = new GroupRole("Co-owner","Owner set user is Co-owner");
        groupRoleDao.save(roleCoOwner);

        GroupRole roleMember = new GroupRole("Member","User join a group");
        groupRoleDao.save(roleMember);


        //add midterm add group
        GroupDetails group1 = new GroupDetails("Group1");
        group1.setId(1l);
        Long group1Id = groupDao.save(group1).getId();
        String userEmail = "midterm@gmail.com";

        User user = userDao.findById("midterm@gmail.com").get();
        user.addGroup(group1);
        userDao.save(user);

        GroupMember groupMember = new GroupMember(userEmail,group1Id,roleOwner.getRoleName());
        groupMember.setId(1l);
        groupMember = groupMemberDao.save(groupMember);

        group1.addMember(groupMember);
        groupDao.save(group1);

        // add midterm 1 as co-owner
        user = userDao.findById("midterm1@gmail.com").get();
        user.addGroup(group1);
        userDao.save(user);

        groupMember = new GroupMember(user.getUserEmail(),group1Id,roleCoOwner.getRoleName());
        groupMember.setId(2l);
        groupMember = groupMemberDao.save(groupMember);

        group1.addMember(groupMember);
        groupDao.save(group1);

        // add midterm 2 as member
        user = userDao.findById("midterm2@gmail.com").get();
        user.addGroup(group1);
        userDao.save(user);

        groupMember = new GroupMember(user.getUserEmail(),group1Id,roleMember.getRoleName());
        groupMember.setId(3l);
        groupMember = groupMemberDao.save(groupMember);

        group1.addMember(groupMember);
        groupDao.save(group1);

        // add midterm 3 as member
        user = userDao.findById("midterm3@gmail.com").get();
        user.addGroup(group1);
        userDao.save(user);

        groupMember = new GroupMember(user.getUserEmail(),group1Id,roleMember.getRoleName());
        groupMember.setId(4l);
        groupMember = groupMemberDao.save(groupMember);

        group1.addMember(groupMember);
        groupDao.save(group1);
    }

    public ResponseEntity<?> creatNewGroup(GroupDetails groupDetails){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        String userEmail = userDetails.getUsername();
        User user = userDao.findById(userEmail).get();

        Long groupId = groupDao.save(groupDetails).getId();
        user.addGroup(groupDetails);
        userDao.save(user);

        GroupRole roleOwner = groupRoleDao.findById("Owner").get();
        GroupMember groupMember = new GroupMember(userEmail,groupId,roleOwner.getRoleName());
        groupMember = groupMemberDao.save(groupMember);

        groupDetails.addMember(groupMember);
        groupDao.save(groupDetails);

        MessagePayload payload = new MessagePayload("OK");
        return new ResponseEntity<>(payload, HttpStatus.OK);
    }

    public Set<GroupDetails> getListGroup(){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        String userEmail = userDetails.getUsername();
        User user = userDao.findById(userEmail).get();
        return user.getGroups();
    }

}

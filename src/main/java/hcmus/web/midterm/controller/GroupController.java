package hcmus.web.midterm.controller;

import hcmus.web.midterm.entity.GroupDetails;
import hcmus.web.midterm.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Set;

@RestController
public class GroupController {

    @Autowired
    private GroupService groupService;

    @PostMapping({"/createNewGroup"})
    public ResponseEntity createNewGroup(@RequestBody GroupDetails groupDetails){
        return groupService.creatNewGroup(groupDetails);
    }

    @GetMapping({"/getListGroup"})
    public Set<GroupDetails> getListGroup(){
        return groupService.getListGroup();
    }

}

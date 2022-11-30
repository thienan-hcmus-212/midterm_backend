package hcmus.web.midterm.dao;

import hcmus.web.midterm.entity.GroupMember;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupMemberDao extends CrudRepository<GroupMember,Long> {


}

package hcmus.web.midterm.dao;

import hcmus.web.midterm.entity.GroupRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRoleDao extends CrudRepository<GroupRole,String> {
}

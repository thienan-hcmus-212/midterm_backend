package hcmus.web.midterm.dao;

import hcmus.web.midterm.entity.GroupDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupDetailsDao extends CrudRepository<GroupDetails,Long> {
}

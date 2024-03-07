package autobotzi.departments;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentsMembersRepository extends JpaRepository<DepartmentsMembers, Long> {


    List<DepartmentsMembers> findByDepartmentName(String departmentName);

    DepartmentsMembers findByUserId(Long userId);

    DepartmentsMembers findByDepartmentId(Long departmentId);
}

package autobotzi.project.assignments;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProjectAssignmentsRepository extends JpaRepository<ProjectAssignments, Long> {
}

package autobotzi.project.skill;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectSkillsRepository extends JpaRepository<ProjectSkills, Long> {

}

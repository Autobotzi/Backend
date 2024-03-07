package autobotzi.user.skill;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSkillsRepository extends JpaRepository<UserSkills, Long> {
}

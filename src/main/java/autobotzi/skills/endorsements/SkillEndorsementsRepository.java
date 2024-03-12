package autobotzi.skills;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillEndorsementsRepository extends JpaRepository<SkillEndorsements, Long> {
}

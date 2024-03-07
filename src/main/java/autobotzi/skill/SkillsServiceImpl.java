package autobotzi.skill;

import autobotzi.skill.SkillsRepository;
import autobotzi.skill.SkillsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SkillsServiceImpl implements SkillsService {

        private final SkillsRepository skillsRepository;
}

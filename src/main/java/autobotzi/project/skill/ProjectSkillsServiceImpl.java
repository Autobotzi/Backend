package autobotzi.project.skill;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectSkillsServiceImpl implements ProjectSkillsService {

    private final ProjectSkillsRepository projectSkillsRepository;
}

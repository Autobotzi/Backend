package autobotzi.user.skill;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserSkillsServiceImpl implements UserSkillsService {

        private final UserSkillsRepository userSkillsRepository;
}

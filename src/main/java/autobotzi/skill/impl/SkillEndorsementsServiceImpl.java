package autobotzi.skill.impl;

import autobotzi.skill.SkillEndorsementsRepository;
import autobotzi.skill.SkillEndorsementsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SkillEndorsementsServiceImpl implements SkillEndorsementsService {

    private final SkillEndorsementsRepository skillEndorsementsRepository;
}

package autobotzi.project.roles;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectRolesServiceImpl implements ProjectRolesService {

    private final ProjectRolesRepository projectRolesRepository;
}

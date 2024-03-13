package autobotzi.project;

import autobotzi.project.ProjectsRepository;
import autobotzi.project.ProjectsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectsServiceImpl implements ProjectsService {

    private final ProjectsRepository projectsRepository;
}

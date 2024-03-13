package autobotzi.project.assignments;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class ProjectAssignmentsServiceImpl implements ProjectAssignmentsService {

    private final ProjectAssignmentsRepository projectAssignmentsRepository;
}

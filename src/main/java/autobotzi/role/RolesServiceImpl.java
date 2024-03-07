package autobotzi.role;

import autobotzi.role.RolesRepository;
import autobotzi.role.RolesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RolesServiceImpl implements RolesService {

    private final RolesRepository rolesRepository;
}

package autobotzi.user.role;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRolesServiceImpl implements UserRolesService {

    private final UserRolesRepository userRolesRepository;
}

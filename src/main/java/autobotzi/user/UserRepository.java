package autobotzi.user;

import autobotzi.organizations.Organizations;
import autobotzi.user.Utils.Role;
import autobotzi.user.dto.UsersDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    Optional<Users> findByEmail(String email);

    Long getIdByEmail(String email);

    List<Users> findByRole(Role role);


}

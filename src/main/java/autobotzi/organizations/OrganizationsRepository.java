package autobotzi.organizations;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrganizationsRepository extends JpaRepository<Organizations, Long> {
    Optional<Organizations> findByName(String organizationName);



}

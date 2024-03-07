package autobotzi.user;

import autobotzi.user.dto.UsersAdminViewDto;
import autobotzi.user.dto.UsersDto;
import autobotzi.user.dto.UsersPreViewDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService {
    UserDetailsService userDetailsService();
    List<UsersDto> getAllUsers();

    List<Users> getAll();

    List<UsersAdminViewDto> getallUsersforAdmin();

    List<UsersPreViewDto> getallUsersforPreView();

    Users getUserByEmail(String email);

    String getDepartmentNameByUserId(Long userId);

    Users updateUser(String email, UsersDto usersDto);

    Long countUsers();

    Long getUsersIdByEmail(String email);
}

package autobotzi.user;

import autobotzi.user.dto.UsersAdminViewDto;
import autobotzi.user.dto.UsersDto;
import autobotzi.user.dto.UsersPreViewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<String> getUser() {
        return ResponseEntity.ok("Hello User");
    }
    @GetMapping("/all")
    public List<Users> getAllUsers() {
        return userService.getAll();
    }

    @GetMapping("/dto")
    public List<UsersDto> getAllUsersDto() {
        return userService.getAllUsers();
    }

    @GetMapping("/admin-view")
    public List<UsersAdminViewDto> getAllUsersAdminView() {
        return userService.getallUsersforAdmin();
    }

    @GetMapping("/preview")
    public List<UsersPreViewDto> getAllUsersPreView() {
        return userService.getallUsersforPreView();
    }


    @GetMapping("/{email}")
    public Users getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

    @GetMapping("/department/{userId}")
    public String getDepartmentNameByUserId(@PathVariable Long userId) {
        return userService.getDepartmentNameByUserId(userId);
    }

    @PutMapping("/{email}")
    public Users updateUser(@PathVariable String email, @RequestBody UsersDto usersDto) {
        return userService.updateUser(email, usersDto);
    }

    @GetMapping("/count")
    public Long countUsers() {
        return userService.countUsers();
    }

    @GetMapping("/email/{email}/id")
    public Long getUserIdByEmail(@PathVariable String email) {
        return userService.getUsersIdByEmail(email);
    }
}

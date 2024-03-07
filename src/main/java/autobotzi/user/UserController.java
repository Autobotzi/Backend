package autobotzi.user;

import autobotzi.user.dto.AdminEmailDto;
import autobotzi.user.dto.UsersAdminViewDto;
import autobotzi.user.dto.UsersDto;
import autobotzi.user.dto.UsersPreViewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@PreAuthorize("hasRole('admin')")
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

    @PreAuthorize("hasRole('user')")
    @GetMapping("/preview")
    public List<UsersPreViewDto> getAllUsersPreView() {
        return userService.getallUsersforPreView();
    }
    @GetMapping("/admin-emails")
    public List<AdminEmailDto> getAllAdminEmails() {
        return userService.getAllAdminEmails();
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

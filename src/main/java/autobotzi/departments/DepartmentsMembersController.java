package autobotzi.departments;

import autobotzi.departments.dto.DepartmentsMembersDto;
import autobotzi.user.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/departments-members")
@RequiredArgsConstructor
public class DepartmentsMembersController {

    private final DepartmentsMembersService departmentsMembersService;


    @GetMapping("/department")
    public List<Users> getUsersByDepartmentName(@RequestParam String departmentName) {
        return departmentsMembersService.getUsersByDepartmentName(departmentName);
    }
    @GetMapping("/count-department")
    public long countUsersByDepartmentName(@RequestParam String departmentName) {
        return departmentsMembersService.countUsersByDepartmentName(departmentName);
    }

    @GetMapping("/count")
    public long countDepartmentsMembers() {
        return departmentsMembersService.countDepartmentsMembers();
    }
}

package autobotzi.departments;

import autobotzi.departments.dto.DepartmentsDto;
import autobotzi.departments.dto.DepartmentsResponse;
import autobotzi.user.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
@RequiredArgsConstructor
public class DepartmentsController {

    private final DepartmentsService departmentsService;

    @GetMapping
    public List<DepartmentsResponse> getAllDepartments() {
        return departmentsService.getAllDepartments();
    }

    @PostMapping
    public Departments addDepartment(@RequestBody DepartmentsDto departmentsDto) {
        return departmentsService.addDepartment(departmentsDto);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable Long id) {
        departmentsService.deleteDepartment(id);
    }
}

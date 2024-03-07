package autobotzi.departments;

import autobotzi.departments.dto.DepartmentsDto;
import autobotzi.departments.dto.DepartmentsResponse;
import autobotzi.user.Users;

import java.util.List;

public interface DepartmentsService {


    Departments addDepartment(DepartmentsDto departmentsDto);

    void deleteDepartment(Long id);
    List<DepartmentsResponse> getAllDepartments();


}

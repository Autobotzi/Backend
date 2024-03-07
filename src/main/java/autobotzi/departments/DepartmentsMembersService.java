package autobotzi.departments;

import autobotzi.departments.dto.DepartmentsMembersDto;
import autobotzi.user.Users;

import java.util.List;

public interface DepartmentsMembersService {


    long countDepartmentsMembers();

    List<Users> getUsersByDepartmentName(String departmentName);

    long countUsersByDepartmentName(String departmentName);
}

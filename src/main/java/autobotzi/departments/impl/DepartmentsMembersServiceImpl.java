package autobotzi.departments.impl;

import autobotzi.departments.DepartmentsMembers;
import autobotzi.departments.DepartmentsMembersRepository;
import autobotzi.departments.DepartmentsMembersService;
import autobotzi.departments.DepartmentsRepository;
import autobotzi.user.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class DepartmentsMembersServiceImpl implements DepartmentsMembersService {


    private final DepartmentsMembersRepository departmentsMembersRepository;
    private final DepartmentsRepository departmentsRepository;

    public List<Users> getUsersByDepartmentName(String departmentName) {

        List<DepartmentsMembers> departmentsMembers = departmentsMembersRepository.findByDepartmentName(departmentName);
        return departmentsMembers.stream()
                .map(DepartmentsMembers::getUser)
                .collect(Collectors.toList());
    }
    public long countUsersByDepartmentName(String departmentName) {
        List<DepartmentsMembers> departmentsMembers = departmentsMembersRepository.findByDepartmentName(departmentName);
        return departmentsMembers.size();
    }




    public long countDepartmentsMembers() {
        return departmentsMembersRepository.count();
    }
}

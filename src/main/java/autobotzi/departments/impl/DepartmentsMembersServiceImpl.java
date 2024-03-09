package autobotzi.departments.impl;

import autobotzi.departments.*;
import autobotzi.departments.dto.DepartmentsMembersDto;
import autobotzi.user.UserRepository;
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
    private final UserRepository userRepository;
    public DepartmentsMembers assignDepartmentToUser(DepartmentsMembersDto departmentsMembersDto) {
        Users user = userRepository.findByEmail(departmentsMembersDto.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        Departments department = departmentsRepository.findByName(departmentsMembersDto.getDepartment())
                .orElseThrow(() -> new IllegalArgumentException("Department not found"));

        DepartmentsMembers departmentsMembers = new DepartmentsMembers();
        departmentsMembers.setUser(user);
        departmentsMembers.setDepartment(department);

        return departmentsMembersRepository.save(departmentsMembers);
    }
    public List<DepartmentsMembersDto> getDepartmentsMembers() {
        return departmentsMembersRepository.findAll().stream()
                .map(departmentsMembers -> DepartmentsMembersDto.builder()
                        .email(departmentsMembers.getUser().getEmail())
                        .department(departmentsMembers.getDepartment().getName())
                        .build())
                .collect(Collectors.toList());
    }
    public List<DepartmentsMembersDto> getDepartmentsMembersByDepartment(String departmentName) {
        return departmentsMembersRepository.findAllByDepartmentName(departmentName).stream()
                .map(departmentsMembers -> DepartmentsMembersDto.builder()
                        .email(departmentsMembers.getUser().getEmail())
                        .department(departmentsMembers.getDepartment().getName())
                        .build())
                .collect(Collectors.toList());
    }
    public Integer getDepartmentMembersCount(String departmentName) {
        return departmentsMembersRepository.findAllByDepartmentName(departmentName).size();
    }

    public void deleteDepartmentMember(String email) {
        Users user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        List<DepartmentsMembers> departmentsMembersList = departmentsMembersRepository.findByUser(user);

        if (departmentsMembersList.isEmpty()) {
            throw new IllegalArgumentException("Department member not found");
        }

        departmentsMembersRepository.deleteAll(departmentsMembersList);
    }


}

package autobotzi.departments.impl;

import autobotzi.departments.Departments;
import autobotzi.departments.DepartmentsRepository;
import autobotzi.departments.DepartmentsService;
import autobotzi.departments.dto.DepartmentsDto;
import autobotzi.departments.dto.DepartmentsResponse;
import autobotzi.user.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentsServiceImpl implements DepartmentsService {

    private final DepartmentsRepository departmentsRepository;


    public List<DepartmentsResponse> getAllDepartments() {
        return departmentsRepository.findAll().stream()
                .map(department -> {
                    DepartmentsResponse departmentDto = new DepartmentsResponse();
                    departmentDto.setName(department.getName());
                    departmentDto.setDescription(department.getDescription());
                    Users user = department.getUser();
                    if (user != null) {
                        departmentDto.setDepartmentManager(user.getName());
                    }
                    return departmentDto;
                })
                .collect(Collectors.toList());
    }

    public Departments addDepartment(DepartmentsDto departmentsDto) {
        Departments department = Departments.builder()
                .name(departmentsDto.getName())
                .description(departmentsDto.getDescription())
                .build();
        return departmentsRepository.save(department);
    }


    public void deleteDepartment(Long id) {
        departmentsRepository.deleteById(id);
    }


}

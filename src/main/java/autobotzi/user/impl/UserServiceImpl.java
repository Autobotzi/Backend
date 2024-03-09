package autobotzi.user.impl;

import autobotzi.departments.Departments;
import autobotzi.departments.DepartmentsMembersRepository;
import autobotzi.departments.DepartmentsRepository;
import autobotzi.user.UserRepository;
import autobotzi.user.UserService;
import autobotzi.user.dto.UsersAdminViewDto;
import autobotzi.user.dto.UsersDto;
import autobotzi.user.dto.UsersOrganizationsDto;
import autobotzi.user.dto.UsersPreViewDto;
import autobotzi.user.utils.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final DepartmentsRepository departmentsRepository;
    private final DepartmentsMembersRepository departmentsMembersRepository;

    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
                return userRepository.findByEmail(email)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
        };
    }


    public List<UsersDto> getAll() {
        return userRepository.findAll().stream()
                .map(user -> UsersDto.builder()
                        .name(user.getName())
                        .email(user.getEmail())
                        .role(user.getRole())
                        .build())
                .collect(java.util.stream.Collectors.toList());
    }
    public List<UsersPreViewDto> getAllPreView() {
        return userRepository.findAll().stream()
                .map(user -> UsersPreViewDto.builder()
                        .name(user.getName())
                        .email(user.getEmail())
                        .build())
                .collect(java.util.stream.Collectors.toList());
    }
    public List<UsersAdminViewDto> getAllAdminView() {
        return userRepository.findAll().stream()
                .map(user -> UsersAdminViewDto.builder()
                        .name(user.getName())
                        .email(user.getEmail())
                        .role(user.getRole())
                        .created_at(user.getCreated_at())
                        .build())
                .collect(java.util.stream.Collectors.toList());
    }
    public List<UsersOrganizationsDto> getAllUsersWithOrganizations() {
        return userRepository.findAll().stream()
                .map(user -> new UsersOrganizationsDto(
                        user.getName(),
                        user.getOrganization().getName()))
                .collect(Collectors.toList());
    }
    public List<UsersDto> getUsersByRole(String role) {
        return userRepository.findByRole(Role.valueOf(role)).stream()
                .map(user -> UsersDto.builder()
                        .name(user.getName())
                        .email(user.getEmail())
                        .role(user.getRole())
                        .build())
                .collect(Collectors.toList());
    }

    public UsersDto getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(user -> UsersDto.builder()
                        .name(user.getName())
                        .email(user.getEmail())
                        .role(user.getRole())
                        .build())
                .orElse(null);
    }
    public List<UsersDto> getUsersByDepartment(String departmentName) {
        Departments department = departmentsRepository.findByName(departmentName)
                .orElseThrow(() -> new IllegalArgumentException("Department not found"));

        return departmentsMembersRepository.findByDepartment(department).stream()
                .map(departmentsMembers -> UsersDto.builder()
                        .name(departmentsMembers.getUser().getName())
                        .email(departmentsMembers.getUser().getEmail())
                        .role(departmentsMembers.getUser().getRole())
                        .build())
                .collect(Collectors.toList());
    }
    public UsersDto updateUserRole(String email, String role) {
        return userRepository.findByEmail(email)
                .map(user -> {
                    user.setRole(Role.valueOf(role));
                    return userRepository.save(user);
                })
                .map(user -> UsersDto.builder()
                        .name(user.getName())
                        .email(user.getEmail())
                        .role(user.getRole())
                        .build())
                .orElse(null);
    }
    public UsersDto updateUserByEmail(String email, String name) {
        return userRepository.findByEmail(email)
                .map(user -> {
                    user.setName(name);
                    return userRepository.save(user);
                })
                .map(user -> UsersDto.builder()
                        .name(user.getName())
                        .email(user.getEmail())
                        .role(user.getRole())
                        .build())
                .orElse(null);
    }
}





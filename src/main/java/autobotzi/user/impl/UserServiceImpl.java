package autobotzi.user.impl;

import autobotzi.departments.DepartmentsRepository;
import autobotzi.departments.impl.NotFoundException;
import autobotzi.user.UserRepository;
import autobotzi.user.UserService;
import autobotzi.user.Users;
import autobotzi.user.Utils.Role;
import autobotzi.user.dto.AdminEmailDto;
import autobotzi.user.dto.UsersAdminViewDto;
import autobotzi.user.dto.UsersDto;
import autobotzi.user.dto.UsersPreViewDto;
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

    public List<Users> getAll() {
        return userRepository.findAll();
    }

    public List<UsersDto> getAllUsers() {
        return userRepository.findAll().stream().map(users -> {
            UsersDto usersDto = new UsersDto();
            usersDto.setEmail(usersDto.getEmail());
            usersDto.setName(usersDto.getName());
            return usersDto;
        }).collect(Collectors.toList());
    }

    public List<UsersAdminViewDto> getallUsersforAdmin() {
        return userRepository.findAll().stream().map(users -> {
            UsersAdminViewDto usersAdminViewDto = new UsersAdminViewDto();
            usersAdminViewDto.setEmail(users.getEmail());
            usersAdminViewDto.setName(users.getName());
            usersAdminViewDto.setRole(users.getRole());
            return usersAdminViewDto;
        }).collect(Collectors.toList());
    }

    public List<AdminEmailDto> getAllAdminEmails() {
        return userRepository.findByRole(Role.ADMIN).stream()
                .map(admin -> new AdminEmailDto(admin.getEmail()))
                .collect(Collectors.toList());
    }

    public List<UsersPreViewDto> getallUsersforPreView() {
        return userRepository.findAll().stream().map(users -> {
            UsersPreViewDto usersPreViewDto = new UsersPreViewDto();

            usersPreViewDto.setEmail(users.getEmail());
            usersPreViewDto.setName(users.getName());
            return usersPreViewDto;
        }).collect(Collectors.toList());
    }

    public Users getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow();
    }

    public String getDepartmentNameByUserId(Long userId) {
        String departmentName = departmentsRepository.getDepartmentNameByUserId(userId);
        if (departmentName == null) {
            throw new NotFoundException("Department not found for user ");
        }
        return departmentName;
    }

    public Users updateUser(String email, UsersDto usersDto) {
        Users user = userRepository.findByEmail(email).orElseThrow();
        user.setEmail(usersDto.getEmail());
        user.setName(usersDto.getName());
        return userRepository.save(user);
    }

    public Long countUsers() {
        return userRepository.count();
    }

    public Long getUsersIdByEmail(String email) {
        return userRepository.getIdByEmail(email);
    }




}



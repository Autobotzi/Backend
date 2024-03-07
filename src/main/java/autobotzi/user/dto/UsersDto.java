package autobotzi.user.dto;

import autobotzi.user.Utils.Role;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class UsersDto {

    private String name;

    private String email;

    private Role role;


}

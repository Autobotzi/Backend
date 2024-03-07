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
public class UsersAdminViewDto {

    private String name;

    private String email;

    private Role role;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date created_at;
}

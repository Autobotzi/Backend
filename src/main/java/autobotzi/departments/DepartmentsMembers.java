package autobotzi.departments;

import autobotzi.user.Users;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "departments_members")
public class DepartmentsMembers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Departments department;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;
}


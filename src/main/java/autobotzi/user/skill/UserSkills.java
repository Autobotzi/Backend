package autobotzi.user.skill;

import autobotzi.skill.Skills;
import autobotzi.user.Users;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_skills")
public class UserSkills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer level;
    private String experience;
    private String endorsements;
    private Boolean validated;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;
    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skills skill;
}

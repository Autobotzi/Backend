package autobotzi.project.skill;

import autobotzi.project.Projects;
import autobotzi.skill.Skills;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "project_skills")
public class ProjectSkills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer level;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Projects project;

    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skills skill;
}

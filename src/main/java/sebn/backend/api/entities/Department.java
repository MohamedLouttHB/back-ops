package sebn.backend.api.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "DEPARTMENT")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_department;
    @Column(length = 30, nullable = false, unique = true)
    private String name_department;
    @OneToMany(mappedBy = "department")
    private List<KPI> KPIS;

}

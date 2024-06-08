package sebn.backend.api.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "KPI")
public class KPI {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_kpi;
    @Column(length = 50, nullable = false)
    private String name_kpi;
    private String rule;
    private float target;
    @ManyToOne
    @JoinColumn(name = "id_department")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Department department;
    @OneToMany(mappedBy = "kpi")
    private List<KpiValue> kpiValues;
    

}

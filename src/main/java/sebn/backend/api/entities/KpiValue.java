package sebn.backend.api.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "KPI_VALUE")
public class KpiValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_KpiValue;
    @Column(nullable = false)
    private float kpi_value;
    @Temporal(TemporalType.DATE)
    private Date date;
    @ManyToOne
    @JoinColumn(name = "id_kpi")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private KPI kpi;
}

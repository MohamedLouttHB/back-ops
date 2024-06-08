package sebn.backend.api.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sebn.backend.api.Repositories.DepartmentRepository;
import sebn.backend.api.Repositories.KPIRepository;
import sebn.backend.api.Repositories.KpiValueRepository;
import sebn.backend.api.entities.Department;
import sebn.backend.api.entities.KPI;
import sebn.backend.api.entities.KpiValue;

import java.util.List;

@Service
@AllArgsConstructor
public class KpiValueServiceImpl implements KpiValueService {
    private KpiValueRepository kpiValueRepository;
    private KPIRepository kpiRepository;
    private DepartmentRepository departmentRepository;

    @Override
    public KpiValue addKpiValue(KpiValue kpiValue) {
        return kpiValueRepository.save(kpiValue);
    }

    @Override
    public List<KpiValue> getAllKpiValues() {
        return kpiValueRepository.findAll();
    }

    @Override
    public KpiValue getKpiValueById(Long kpiValueId) {
        return kpiValueRepository.findById(kpiValueId).orElse(null);
    }

    @Override
    public KpiValue updateKpiValue(KpiValue kpiValue) {
        KpiValue existingkpiValue = kpiValueRepository.findById(kpiValue.getId_KpiValue()).get();
        existingkpiValue.setKpi_value(kpiValue.getKpi_value());
        existingkpiValue.setDate(kpiValue.getDate());
        KpiValue updatedkpiValue = kpiValueRepository.save(existingkpiValue);
        return updatedkpiValue;

    }

    @Override
    public void deleteKpiValue(Long kpiValueId) {
        kpiValueRepository.deleteById(kpiValueId);
    }

    @Override
    public List<KpiValue> getKpiValues(Long kpiId) {
        KPI kpi = kpiRepository.findById(kpiId).orElse(null);
        if (kpi == null) {
            throw new RuntimeException("KPI not exist !");
        }
        List<KpiValue> kpiValues = kpi.getKpiValues();
        return kpiValues;
    }

/*    public List<KpiValue> getDepartmentKpiValues(Long departmentId, Long kpiId) {

        Department department = departmentRepository.findById(departmentId).orElse(null);
        if (department == null) {
            throw new RuntimeException("Department not exist !");
        }
        List<KPI> departmentKPIs = department.getKPIS();
        KPI kpi = kpiRepository.findById(kpiId).orElse(null);

        if (!departmentKPIs.contains(kpi)) {
            throw new RuntimeException("KPI not exist !");
        }
        List<KpiValue> kpiValues = kpi.getKpiValues();
        return kpiValues;
    }*/
    public List<KpiValue> getDepartmentKpiValues(Long departmentId, Long kpiId) {

        Department department = departmentRepository.findById(departmentId).orElse(null);
        if (department == null) {
            throw new RuntimeException("Department not exist !");
        }
        List<KPI> departmentKPIs = department.getKPIS();

        KPI kpi = kpiRepository.findById(kpiId).orElse(null);

        if (!departmentKPIs.contains(kpi)) {
            throw new RuntimeException("KPI not exist !");
        }
        List<KpiValue> kpiValues = kpi.getKpiValues();
        return kpiValues;
    }
}

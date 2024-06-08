package sebn.backend.api.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sebn.backend.api.Repositories.DepartmentRepository;
import sebn.backend.api.Repositories.KPIRepository;
import sebn.backend.api.entities.Department;
import sebn.backend.api.entities.KPI;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class KPIServiceImpl implements KPIService {
    private KPIRepository kpiRepository;
    private DepartmentRepository departmentRepository;

    @Override
    public KPI addKPI(KPI kpi) {
        return kpiRepository.save(kpi);
    }

    @Override
    public KPI getKPIById(Long kpiId) {
        Optional<KPI> optionalKPI = kpiRepository.findById(kpiId);
        return optionalKPI.orElse(null);
    }

    @Override
    public List<KPI> getAllKPIs() {
        return kpiRepository.findAll();
    }

    @Override
    public KPI updateKPI(KPI kpi) {
        KPI existingKPI = kpiRepository.findById(kpi.getId_kpi()).get();
        existingKPI.setName_kpi(kpi.getName_kpi());
        existingKPI.setRule(kpi.getRule());
        existingKPI.setTarget(kpi.getTarget());
        KPI updatedKPI = kpiRepository.save(existingKPI);
        return updatedKPI;
    }

    @Override
    public void deleteKPI(Long kpiId) {
        kpiRepository.deleteById(kpiId);
    }

    @Override
    public List<KPI> getDepartmentKPIs(Long departmentId) {
        Department department = departmentRepository.findById(departmentId).orElse(null);
        if (department == null) {
            throw new RuntimeException("Department not exist !");
        }
        List<KPI> departmentKPIs = department.getKPIS();
        return departmentKPIs;

    }
}

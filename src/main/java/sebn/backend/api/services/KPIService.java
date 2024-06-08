package sebn.backend.api.services;

import sebn.backend.api.entities.KPI;

import java.util.List;

public interface KPIService {
    KPI addKPI(KPI KPI);
    KPI getKPIById(Long indicatorId);
    List<KPI> getAllKPIs();
    KPI updateKPI(KPI KPI);
    void deleteKPI(Long indicatorId);

    List<KPI> getDepartmentKPIs(Long departmentId);
}

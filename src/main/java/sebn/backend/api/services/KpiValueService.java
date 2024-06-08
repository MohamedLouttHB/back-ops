package sebn.backend.api.services;

import sebn.backend.api.entities.KpiValue;

import java.util.List;

public interface KpiValueService {

    KpiValue addKpiValue(KpiValue kpiValue);
    List<KpiValue> getAllKpiValues();
    KpiValue getKpiValueById(Long kpiValueId);
    KpiValue updateKpiValue(KpiValue kpiValue);
    void deleteKpiValue(Long kpiValueId);
    List<KpiValue> getKpiValues(Long kpiId);

    List<KpiValue> getDepartmentKpiValues(Long departmentId, Long kpiId);
}

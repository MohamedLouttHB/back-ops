
package sebn.backend.api.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sebn.backend.api.entities.KPI;
import sebn.backend.api.services.KPIService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/kpis")
@CrossOrigin("*")
public class KPIController {

    private KPIService kpiService;

    // create Indicator endpoint

    @PostMapping
    public KPI addKPI(@RequestBody KPI kpi) {
        return kpiService.addKPI(kpi);
    }

    // Get KPI by Id endpoint
    @GetMapping("{id}")
    public KPI getKPIById(@PathVariable("id") Long indicatorId) {
        return kpiService.getKPIById(indicatorId);
    }

    // Get All KPI endpoint
    @GetMapping
    public List<KPI> getAllKPIs() {
        return kpiService.getAllKPIs();
    }

    //Update KPI endpoint
    @PutMapping("{id}")
    public KPI updateKPI(@PathVariable("id") Long kpiId, @RequestBody KPI kpi) {
        kpi.setId_kpi(kpiId);
        KPI updatedKPI = kpiService.updateKPI(kpi);
        return updatedKPI;
    }

    //Delete KPI endpoint
    @DeleteMapping("{id}")
    public void deleteKPI(@PathVariable("id") Long kpiId){
        kpiService.deleteKPI(kpiId);
    }

    @GetMapping("department-kpis/{departmentId}")
    public List<KPI> departmentKPIS(@PathVariable Long departmentId){
        List<KPI> depKpis = kpiService.getDepartmentKPIs(departmentId);
        return depKpis;
    }


}


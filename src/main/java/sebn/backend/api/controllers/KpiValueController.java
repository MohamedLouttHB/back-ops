package sebn.backend.api.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sebn.backend.api.entities.KPI;
import sebn.backend.api.entities.KpiValue;
import sebn.backend.api.services.KPIService;
import sebn.backend.api.services.KpiValueService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/kpi-value")
@CrossOrigin("*")
public class KpiValueController {
    private KpiValueService kpiValueService;
    private KPIService kpiService;
    @PostMapping
    public KpiValue addKpiValue(@RequestBody KpiValue kpiValue) {
        return kpiValueService.addKpiValue(kpiValue);
    }

    // Get KPIValue by Id endpoint
    @GetMapping("{id}")
    public KpiValue getKpiValueById(@PathVariable("id") Long kpiValueId) {
        return kpiValueService.getKpiValueById(kpiValueId);
    }

    // Get All KPIValue endpoint
    @GetMapping
    public List<KpiValue> getAllKpiValues() {
        return kpiValueService.getAllKpiValues();
    }

    //Update KPIValue endpoint
    @PutMapping("{id}")
    public KpiValue updateKpiValue(@PathVariable("id") Long kpiValueId, @RequestBody KpiValue kpiValue) {
        kpiValue.setId_KpiValue(kpiValueId);
        KpiValue updatedKpiValue = kpiValueService.updateKpiValue(kpiValue);
        return updatedKpiValue;
    }

    //Delete KPIValue endpoint
    @DeleteMapping("{id}")
    public void deleteDepartment(@PathVariable("id") Long kpiDetailId){
        kpiValueService.deleteKpiValue(kpiDetailId);
    }

    @GetMapping("department/{kpiId}")
    public List<KpiValue> getKpiValues(@PathVariable Long kpiId){
        List<KpiValue> kpiValues = kpiValueService.getKpiValues(kpiId);
        return kpiValues;
    }

  /*  @GetMapping("{departmentId}/{kpiId}")
    public List<KpiValue> getDepartmentKpiValues(@PathVariable Long departmentID, @PathVariable Long kpiId){
        List<KpiValue> kpiValues =  kpiValueService.getDepartmentKpiValues(departmentID, kpiId);
        return kpiValues;
    }*/
  @GetMapping("kpivals/{departmentId}")
  public List<KpiValue> getDepartmentKpiValues(@PathVariable Long departmentID){

      List<KpiValue> kpiValues =  kpiValueService.getKpiValues(departmentID);
      return kpiValues;
  }
}

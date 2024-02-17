package com.example.buysell.controllers;


import com.example.buysell.models.Equipment;
import com.example.buysell.models.Maintenance;
import com.example.buysell.services.MaintenanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor

public class MaintenanceController {
    private MaintenanceService maintenanceService;

    @GetMapping("/maintenance")
    public List<Maintenance> maintenances()
    {
        return maintenanceService.listMaintenance();
    }

    @GetMapping("/maintenance/{id}")
    public Maintenance MaintenanceInfo(@PathVariable Long id)
    {
        return maintenanceService.getMaintenanceById(id);
    }

    @PostMapping("/maintenance/create")
    public Maintenance createMaintence(@RequestBody Maintenance maintenance)
    {
        return maintenanceService.saveMaintenance(maintenance);
    }

    @DeleteMapping("/maintenance/delete/{id}")
    public Maintenance deleteMaintenance(@PathVariable Long id)
    {
        return maintenanceService.deleteMaintenance(id);
    }
    @PutMapping("/maintenance/update/{id}")
    public Maintenance updateMaintenanceById(@RequestBody Maintenance maintenance,@PathVariable Long id)
    {
        return maintenanceService.updateMaintenanceById(maintenance,id);
    }
}

package com.example.buysell.controllers;


import com.example.buysell.models.Equipment;
import com.example.buysell.models.Responsible;
import com.example.buysell.services.EquipmentService;
import com.example.buysell.services.ResponsibleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class EquipmentController {

    private  EquipmentService equipmentService;

    @GetMapping("/equipments")
    public List<Equipment> equipments()
    {
        return equipmentService.listEquipment();
    }

    @GetMapping("/equipments/{id}")
    public Equipment equipmentInfo(@PathVariable Long id)
    {
        return equipmentService.getEquipmentById(id);
    }
    @PostMapping("/equipments/create")
    public Equipment createEquipment(@RequestBody Equipment equipment)
    {
        return equipmentService.saveEquipment(equipment);
    }
    @DeleteMapping("/equipments/delete/{id}")
    public Equipment deleteEquipment(@PathVariable Long id)
    {
        return equipmentService.deleteEquipment(id);
    }
    @PutMapping("/equipments/update/{id}")
    public Equipment responsibleId(@RequestBody Equipment equipment,@PathVariable Long id)
    {
        return equipmentService.updateEquipment(equipment);
    }

    @GetMapping("/equipments-period")
    public List<Equipment> getRepairedEquipmentInPeriod(@RequestParam String startDate, @RequestParam String endDate) {
        Date start = Date.valueOf(startDate);
        Date end = Date.valueOf(endDate);
        return equipmentService.getRepairedEquipmentInPeriod(start, end);
    }
}

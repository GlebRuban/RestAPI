package com.example.buysell.services;

import com.example.buysell.models.Equipment;
import com.example.buysell.repository.EquipmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
public class EquipmentService {
    private final EquipmentRepository equipmentRepository;
    public EquipmentService(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
        init();
    }
    public void init()
    {
        equipmentRepository.save(new Equipment("PC","Cleaning dirt and replacing components", LocalDate.of(2022,8,15)));
        equipmentRepository.save(new Equipment("printer","Replacement of components",LocalDate.of(2022,10,16)));
        equipmentRepository.save(new Equipment("Harvester","Replacing components",LocalDate.of(2022,5,18)));
        equipmentRepository.save(new Equipment("Tractor","Replacing components",LocalDate.of(2022,4,30)));
        equipmentRepository.save(new Equipment("Harvester","Replacing components",LocalDate.of(2022,7,25)));
    }
    public List<Equipment> listEquipment() { return equipmentRepository.findAll(); }
    public List<Equipment> getRepairedEquipmentInPeriod(Date startDate, Date endDate)
    {
        return equipmentRepository.findByRepairPeriod(startDate, endDate);
    }
    public Equipment saveEquipment(Equipment equipments)
    {
        equipmentRepository.save(equipments);
        return equipments;
    }
    public List<Equipment> getEquipmentForInventory() {
        return null;
    }

    public Equipment deleteEquipment(Long id) {
        Equipment product=equipmentRepository.findById(id).orElse(null);
        if(product!=null) {
            equipmentRepository.deleteById(id);
            return product;
        }
        else
            return null;
    }

    public Equipment getEquipmentById(Long id) {
        return equipmentRepository.findById(id).orElse(null);
    }
    public Equipment updateEquipment(Equipment equipmentData){
        Equipment equipment=equipmentRepository.findById(id).orELse(null);
        if(equipment!=null) {
            equipment.setId(equipmentData.getId());
            equipment.setDescription(equipmentData.getDescription());
            equipment.setTitle(equipmentData.getTitle());
            equipment.setData(equipmentData.getData());
            equipmentRepository.save(equipment);
            return equipment;
        }
        else
            return null;
    }
}


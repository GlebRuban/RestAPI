package com.example.buysell.services;
import com.example.buysell.models.Maintenance;
import com.example.buysell.repository.MaintenanceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
public class MaintenanceService {
    private final MaintenanceRepository maintenanceRepository;

    public MaintenanceService(MaintenanceRepository maintenanceRepository) {
        this.maintenanceRepository = maintenanceRepository;
        init();
    }

    public void init()
    {
        maintenanceRepository.save(new Maintenance("Cleaning","type of service", LocalDate.of(2021,7,15)));
        maintenanceRepository.save(new Maintenance("Cleaning","type of service",LocalDate.of(2022,10,25)));
        maintenanceRepository.save(new Maintenance("Replacement","type of service",LocalDate.of(2023,12,30)));
        maintenanceRepository.save(new Maintenance("Replacement","type of service",LocalDate.of(2023,8,8)));
    }
    public List<Maintenance> listMaintenance() { return maintenanceRepository.findAll(); }

    public Maintenance saveMaintenance(Maintenance maintenance)
    {
        maintenanceRepository.save(maintenance);
        return maintenance;
    }

    public Maintenance deleteMaintenance(Long id) {
        Maintenance product=maintenanceRepository.findById(id).orElse(null);
        if(product!=null) {
            maintenanceRepository.deleteById(id);
            return product;
        }
        else
            return null;
    }

    public Maintenance getMaintenanceById(Long id) {
        return maintenanceRepository.findById(id).orElse(null);
    }

    public Maintenance updateMaintenanceById(Maintenance productData, Long id){
        Maintenance product=maintenanceRepository.findById(id).orElse(null);
        if(product!=null) {
            product.setId(productData.getId());
            product.setDescription(productData.getDescription());
            product.setTitle(productData.getTitle());
            product.setEquipment(productData.getEquipment());
            product.setResponsible(productData.getResponsible());
            maintenanceRepository.save(product);
            return product;
        }
        else
            return null;
    }

}

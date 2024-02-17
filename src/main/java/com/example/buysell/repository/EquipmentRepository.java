package com.example.buysell.repository;

import com.example.buysell.models.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface EquipmentRepository extends JpaRepository<Equipment,Long>
{
    List<Equipment> findById(int id);
    List<Equipment> findByTitle(String title);
    List<Equipment> findByDescription(String description);
    List<Equipment> findByData(Date data);

    List<Equipment> findByRepairPeriod(java.sql.Date startDate, java.sql.Date endDate);
}

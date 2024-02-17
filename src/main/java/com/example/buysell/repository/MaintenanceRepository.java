package com.example.buysell.repository;

import com.example.buysell.models.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface MaintenanceRepository extends JpaRepository<Maintenance,Long>
{
    List<Maintenance> findAll();
    List<Maintenance> findById(int id);
    List<Maintenance> findByTitle(String title);
    List<Maintenance> findByDescription(String Description);
    List<Maintenance> findByData(Date date);
}

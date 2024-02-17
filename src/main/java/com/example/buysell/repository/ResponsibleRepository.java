package com.example.buysell.repository;

import com.example.buysell.models.Responsible;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResponsibleRepository extends JpaRepository<Responsible,Long>
{
    List<Responsible> findAll();
    List<Responsible> findById(int id);
    List<Responsible> findByTitle(String title);
    List<Responsible> findByDescription(String description);
    List<Responsible> findByBool(Boolean bool);
}
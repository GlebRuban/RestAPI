package com.example.buysell.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "maintenance")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Maintenance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "Maintenance_name")
    private String title;
    @Column(name = "Type_Maintenance",columnDefinition = "text")
    private String description;
    @Column(name = "Date_Maintenance")
    private LocalDate data;
    @ManyToOne(cascade = CascadeType.REFRESH)
    private Responsible responsible;
    @ManyToOne(cascade = CascadeType.REFRESH)
    private Equipment equipment;

    public Maintenance(String title, String description, LocalDate data) {
        this.title = title;
        this.description = description;
        this.data = data;
    }
}

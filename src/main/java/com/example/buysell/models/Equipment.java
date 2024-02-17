package com.example.buysell.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "equipment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private Long id;
    @Column(name = "name_equipment")
    private String title;
    @Column(name = "type_equipment",columnDefinition = "text")
    private String description;
    @Column(name = "Date_of_arrival")
    private LocalDate data;

    public Equipment(String title, String description, LocalDate data) {
        this.title = title;
        this.description = description;
        this.data = data;
    }

}

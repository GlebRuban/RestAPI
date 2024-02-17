package com.example.buysell.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "responsible")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Responsible {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "responsible_name")
    private String title;
    @Column(name = "job_title",columnDefinition = "text")
    private String description;
    @Column(name = "Status_maintenance")
    private int bool;

    public Responsible( String title, String description) {
        this.title = title;
        this.description = description;
    }
}

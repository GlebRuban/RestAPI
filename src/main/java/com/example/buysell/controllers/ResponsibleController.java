package com.example.buysell.controllers;


import com.example.buysell.models.Responsible;
import com.example.buysell.services.ResponsibleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor

public class ResponsibleController {
    private ResponsibleService responsibleService;

    @GetMapping("/")
    public List<Responsible> responsibles ()
    {
        return responsibleService.responsibleList();
    }
    @GetMapping("/responce/{id}")
    public Responsible responsibleInfo(@PathVariable Long id)
    {
        return responsibleService.getResponceById(id);
    }
    @PostMapping("/responce/create")
    public Responsible createResponce(@RequestBody Responsible responsible)
    {
        return responsibleService.saveResponce(responsible);
    }
    @DeleteMapping("/responce/delete/{id}")
    public Responsible deleteResponce(@PathVariable Long id)
    {
        return responsibleService.deleteresponce(id);
    }
    @PutMapping("/responce/update/{id}")
    public Responsible responsibleId(@RequestBody Responsible responsible,@PathVariable Long id)
    {
        return responsibleService.updateResponeById(responsible,id);
    }
}

package com.example.buysell.services;

import com.example.buysell.models.Responsible;
import com.example.buysell.repository.ResponsibleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ResponsibleService {
    private final ResponsibleRepository responsibleRepository;

    public ResponsibleService(ResponsibleRepository responsibleRepository) {
        this.responsibleRepository = responsibleRepository;
        init();
    }
    public void init()
    {
        responsibleRepository.save(new Responsible("Oleg Ivanov","Chief Engineer"));
        responsibleRepository.save(new Responsible("Ivan Petrov","Junior engineer"));
        responsibleRepository.save(new Responsible("Albert Popsov","Handyman"));
        responsibleRepository.save(new Responsible("Albert Pupsov","Worker"));

    }
    public  List<Responsible> responsibleList(){return  responsibleRepository.findAll(); }
    public Responsible saveResponce(Responsible product) {
        responsibleRepository.save(product);
        return product;
    }

    public Responsible deleteresponce(Long id) {
        Responsible responsible=responsibleRepository.findById(id).orElse(null);
        if(responsible!=null) {
            responsibleRepository.deleteById(id);
            return responsible;
        }
        else
            return null;
    }

    public Responsible getResponceById(Long id) {
        return responsibleRepository.findById(id).orElse(null);
    }
    public Responsible updateResponeById(Responsible responsibleData, Long id){
        Responsible product=responsibleRepository.findById(id).orElse(null);
        if(product!=null) {
            product.setId(responsibleData.getId());
            product.setDescription(responsibleData.getDescription());
            product.setTitle(responsibleData.getTitle());
            product.setBool(responsibleData.getBool());
            responsibleRepository.save(product);
            return product;
        }
        else
            return null;
    }
}

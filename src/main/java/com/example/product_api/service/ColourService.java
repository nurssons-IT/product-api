package com.example.product_api.service;

import com.example.product_api.model.Colour;
import com.example.product_api.repository.ColourRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColourService {

    private final ColourRepository colourRepository;

    public ColourService(ColourRepository colourRepository) {
        this.colourRepository = colourRepository;
    }

    public List<Colour> getAllColours() {
        return colourRepository.findAll();
    }
    
    public List<Colour> getColoursByIds(List<Long> ids) {
        return colourRepository.findAllById(ids);
    }
}


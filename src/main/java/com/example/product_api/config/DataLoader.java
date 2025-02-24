package com.example.product_api.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.product_api.model.Colour;
import com.example.product_api.model.ProductType;
import com.example.product_api.repository.ColourRepository;
import com.example.product_api.repository.ProductTypeRepository;

@Component
public class DataLoader implements CommandLineRunner {

    private final ProductTypeRepository productTypeRepository;
    private final ColourRepository colourRepository;

    public DataLoader(ProductTypeRepository productTypeRepository, ColourRepository colourRepository) {
        this.productTypeRepository = productTypeRepository;
        this.colourRepository=colourRepository;
    }

    @Override
    public void run(String... args) {
        if (productTypeRepository.count() == 0) {
              productTypeRepository.save(new ProductType(null,"Sofa",null));
              productTypeRepository.save(new ProductType(null,"Bed",null));
              productTypeRepository.save(new ProductType(null,"Lamp",null));
            
            
        }

        if (colourRepository.count() == 0) {
            colourRepository.save(new Colour(null,"blue",null));
            colourRepository.save(new Colour(null,"red",null));
            colourRepository.save(new Colour(null,"green",null));
          
          
      }
    }
}

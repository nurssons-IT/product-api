package com.example.product_api.controller;

import com.example.product_api.model.Product;
import com.example.product_api.model.ProductType;
import com.example.product_api.model.Colour;
import com.example.product_api.service.ProductService;
import com.example.product_api.service.ProductTypeService;
import com.example.product_api.service.ColourService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;
    private final ProductTypeService productTypeService;
    private final ColourService colourService;

    public ProductController(ProductService productService, ProductTypeService productTypeService, ColourService colourService) {
        this.productService = productService;
        this.productTypeService = productTypeService;
        this.colourService = colourService;
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
       
        Optional<ProductType> productType = productTypeService.getProductTypeById(product.getProductType().getId());
        
    

        List<Colour> colours = colourService.getColoursByIds(
                product.getColours().stream().map(Colour::getId).toList()
        );

        
        
        product.setProductType(productType.get());
        product.setColours(colours);
        Product savedProduct = productService.addProduct(product);
       
        return ResponseEntity.ok(savedProduct);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> product = productService.getProductById(id);
        
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}


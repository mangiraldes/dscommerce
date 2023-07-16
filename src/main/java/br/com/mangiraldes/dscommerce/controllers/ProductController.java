package br.com.mangiraldes.dscommerce.controllers;

import br.com.mangiraldes.dscommerce.DTO.ProductDTO;
import br.com.mangiraldes.dscommerce.entities.Product;
import br.com.mangiraldes.dscommerce.repositories.ProductRepository;
import br.com.mangiraldes.dscommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value="/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    public String teste(){
        return "CAcildis";
    }
    @GetMapping(value = "{Id}")
    public ProductDTO findByID(@PathVariable Long Id){

        return productService.findByID(Id);

    }
}

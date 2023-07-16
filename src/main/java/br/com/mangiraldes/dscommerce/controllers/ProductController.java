package br.com.mangiraldes.dscommerce.controllers;

import br.com.mangiraldes.dscommerce.DTO.ProductDTO;
import br.com.mangiraldes.dscommerce.entities.Product;
import br.com.mangiraldes.dscommerce.repositories.ProductRepository;
import br.com.mangiraldes.dscommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
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
    @GetMapping
    public Page<ProductDTO> findAll(Pageable pageable){

        return productService.findAll(pageable);

    }


}

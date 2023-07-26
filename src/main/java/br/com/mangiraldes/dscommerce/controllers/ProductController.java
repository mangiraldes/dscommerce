package br.com.mangiraldes.dscommerce.controllers;

import br.com.mangiraldes.dscommerce.DTO.ProductDTO;
import br.com.mangiraldes.dscommerce.entities.Product;
import br.com.mangiraldes.dscommerce.repositories.ProductRepository;
import br.com.mangiraldes.dscommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriBuilder;

import java.net.URI;
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
    public ResponseEntity<ProductDTO> findByID(@PathVariable Long Id){
        var productDTO = productService.findByID(Id);
        return ResponseEntity.ok(productDTO);

    }
    @PutMapping(value = "product/{Id}")
    public ResponseEntity<ProductDTO> update(@PathVariable Long Id,@RequestBody ProductDTO dto){
        var productDTO = productService.findByID(Id);
        productDTO = productService.update(Id,dto);
        return ResponseEntity.ok(productDTO);
    }
    @DeleteMapping(value = "{Id}")
    public ResponseEntity<ProductDTO> delete(@PathVariable Long Id){
        productService.delete(Id);

        return ResponseEntity.noContent().build();
    }
    @GetMapping
    public Page<ProductDTO> findAll(Pageable pageable){

        return productService.findAll(pageable);

    }
    @PostMapping
    public ResponseEntity<ProductDTO> insert(@RequestBody ProductDTO dto){

        dto = productService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);

    }




}

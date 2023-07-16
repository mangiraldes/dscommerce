package br.com.mangiraldes.dscommerce.services;

import br.com.mangiraldes.dscommerce.DTO.ProductDTO;
import br.com.mangiraldes.dscommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Transactional
    public ProductDTO findByID(Long Id){
         return new ProductDTO(productRepository.findById(Id).get());

    }
    @Transactional
    public Page<ProductDTO> findAll(Pageable pageable){
         return productRepository.findAll(pageable).map(x -> new ProductDTO(x));

    }
}

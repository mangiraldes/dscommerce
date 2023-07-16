package br.com.mangiraldes.dscommerce.services;

import br.com.mangiraldes.dscommerce.DTO.ProductDTO;
import br.com.mangiraldes.dscommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Transactional
    public ProductDTO findByID(Long Id){
         return new ProductDTO(productRepository.findById(Id).get());

    }
}

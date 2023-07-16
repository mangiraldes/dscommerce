package br.com.mangiraldes.dscommerce.repositories;

import br.com.mangiraldes.dscommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long>{
}

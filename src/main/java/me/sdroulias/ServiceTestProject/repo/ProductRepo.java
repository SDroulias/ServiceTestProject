package me.sdroulias.ServiceTestProject.repo;

import me.sdroulias.ServiceTestProject.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Integer> {

    List<Product> findAllByOrderByPriceAsc();
    List<Product> findAllByOrderByPriceDesc();
    List<Product> findByNameContaining(String name);
    Product findByCodeEquals(String code);

}

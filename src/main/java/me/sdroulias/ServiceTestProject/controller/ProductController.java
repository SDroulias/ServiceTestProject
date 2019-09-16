package me.sdroulias.ServiceTestProject.controller;

import me.sdroulias.ServiceTestProject.exception.ProductNotFoundException;
import me.sdroulias.ServiceTestProject.model.Product;
import me.sdroulias.ServiceTestProject.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductRepo productRepo;

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productRepo.findAll();
    }

    @PostMapping("/products")
    public Product createProduct(@Valid @RequestBody Product product) {
        return productRepo.save(product);
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable int id) throws ProductNotFoundException {
        return productRepo.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }

    @GetMapping("/products/asc")
    public List<Product> getAllByPriceAsc(){
        return productRepo.findAllByOrderByPriceAsc();
    }

    @GetMapping("/products/desc")
    public List<Product> getAllByPriceDesc(){
        return  productRepo.findAllByOrderByPriceDesc();
    }

    @GetMapping("/products/name/{name}")
    public List<Product> getAllByName(@PathVariable String name){
        return productRepo.findByNameContaining(name);
    }

    @GetMapping("/products/code/{code}")
    public Product getByCode(@PathVariable String code){
        return productRepo.findByCodeEquals(code); //TODO how to throw exception in case none is found
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable int id) throws ProductNotFoundException{
        productRepo.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
        productRepo.deleteById(id);
        return ResponseEntity.ok().build();
    }

    //could have use patch annotation instead
    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable int id, @Valid @RequestBody Product productInfo) throws ProductNotFoundException{
        Product product = productRepo.findById(id).orElseThrow(()-> new ProductNotFoundException(id));
        product.setName(productInfo.getName());
        product.setPrice(productInfo.getPrice());
        product.setCode(productInfo.getCode());
        product.setAvDate(productInfo.getAvDate());
        product.setExpDate(productInfo.getExpDate());

        Product updatedProduct = productRepo.save(product);
        return updatedProduct;
    }
}

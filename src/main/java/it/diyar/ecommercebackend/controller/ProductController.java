package it.diyar.ecommercebackend.controller;


import it.diyar.ecommercebackend.models.Product;
import it.diyar.ecommercebackend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductRepository repo;

    @GetMapping
    private List<Product> getAllProducts(){
        return repo.findAll();
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return repo.save(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateProduct(@PathVariable(value="id") long productId,
                                         @RequestBody Product productDetails){
        Product product=repo.findById(productId).get();
        product.setName(productDetails.getName());
        product.setPrice(productDetails.getPrice());
        product.setDescription(productDetails.getDescription());
        repo.save(product);
        return ResponseEntity.ok().body("prodotto aggiornato correttamente");
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteProduct(@PathVariable Long productId){
        repo.deleteById(productId);
        return ResponseEntity.ok().build();
    }


}

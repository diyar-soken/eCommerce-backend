package it.diyar.ecommercebackend.controller;

import it.diyar.ecommercebackend.models.Order;
import it.diyar.ecommercebackend.models.Product;
import it.diyar.ecommercebackend.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderRepository repo;

    @GetMapping
    private List<Order> getAllProducts(){
        return repo.findAll();
    }

    @PostMapping
    private Order addProduct(@RequestBody Order order){
        return repo.save(order);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateProduct(@PathVariable("id") Long id, @RequestBody Order order) {
        if(repo.findById(id).isPresent()){
            repo.save(order);
            return new ResponseEntity<>(order, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Non trovato",HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping
    private ResponseEntity deleteProduct(@PathVariable("id") Long id){
        repo.deleteById(id);
        return ResponseEntity.ok().build();
    }
}

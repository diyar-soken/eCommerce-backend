package it.diyar.ecommercebackend.controller;

import it.diyar.ecommercebackend.models.Order;
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
    public List<Order> getAllOrders(){
        return repo.findAll();
    }

    @PostMapping
    public Order addOrder(@RequestBody Order order){
        return repo.save(order);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateOrder(@PathVariable("id") Long id, @RequestBody Order order) {
        if(repo.findById(id).isPresent()){
            order.setOrderId(id); // Ensure the ID is set correctly
            repo.save(order);
            return new ResponseEntity<>(order, HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Non trovato",HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable("id") Long id){
        repo.deleteById(id);
        return ResponseEntity.ok().build();
    }
}

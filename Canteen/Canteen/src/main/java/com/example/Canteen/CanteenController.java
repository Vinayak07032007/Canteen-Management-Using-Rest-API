package com.example.Canteen;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/canteen")
@CrossOrigin(origins = "*")
public class CanteenController {

    @Autowired
    private CanteenService canteenService;

    
    @PostMapping("/menu")
    public MenuItem addMenuItem(@RequestBody MenuItem item) {
        return canteenService.addMenuItem(item);
    }

    
    @GetMapping("/menu")
    public List<MenuItem> getAllMenuItems() {
        return canteenService.getAllMenuItems();
    }

   
    @PostMapping("/order")
    public OrderItem placeOrder(@RequestBody OrderItem order) {
       return canteenService.placeOrder(order);
    }

  
    @GetMapping("/orders")
    public List<OrderItem> getAllOrders() {
         return canteenService.getAllOrders();
    }
}

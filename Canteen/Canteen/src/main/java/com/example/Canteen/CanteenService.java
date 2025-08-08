package com.example.Canteen;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CanteenService {

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private OrderRepository orderRepository;

    
    public MenuItem addMenuItem(MenuItem item) {
        if (item == null || item.getName() == null || item.getPrice() <= 0) {
            throw new IllegalArgumentException("Invalid menu item details.");
        }
        return menuRepository.save(item);
    }

   
    public List<MenuItem> getAllMenuItems() {
        return menuRepository.findAll();
    }

    
    public OrderItem placeOrder(OrderItem order) {
        if (order == null || order.getItemName() == null || order.getQuantity() <= 0) {
            throw new IllegalArgumentException("Invalid order details.");
        }

       
        if (order.getTotal() <= 0) {
            
            MenuItem menuItem = menuRepository.findByName(order.getItemName());
            if (menuItem == null) {
                throw new IllegalArgumentException("Menu item not found: " + order.getItemName());
            }
            double total = menuItem.getPrice() * order.getQuantity();
            order.setTotal(total);
        }

        order.setOrderTime(LocalDateTime.now());
        
        return orderRepository.save(order);
    }

    
    public List<OrderItem> getAllOrders() {
        return orderRepository.findAll();
    }
}

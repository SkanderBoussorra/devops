package io.order.manager.food.order.manager.ressources;

import io.order.manager.food.order.manager.dto.FoodOrderDTO;
import io.order.manager.food.order.manager.services.FoodOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/orders")
public class OrderRessources {
    @Autowired
    private FoodOrderService foodService;


    @GetMapping
    // Affiche Liste des ordres
    public List<FoodOrderDTO> allOrders() {
        return foodService.getAllOrders();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    //Ajouter order:
    public ResponseEntity<FoodOrderDTO> addOrder(@RequestBody FoodOrderDTO order) {
        return new ResponseEntity<>(foodService.saveOrder(order), HttpStatus.OK);

    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> updateFoodOrder(@PathVariable(value = "id") int id, @RequestBody FoodOrderDTO foodOrderDTO) {
        foodService.updateOrder(id, foodOrderDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteFoodOrder(@PathVariable(value = "id") int id) {
        foodService.deleteOrder(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

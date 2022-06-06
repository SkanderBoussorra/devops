package io.order.manager.food.order.manager.services.impl;

import io.order.manager.food.order.manager.dto.FoodOrderDTO;
import io.order.manager.food.order.manager.entities.Food_Order;
import io.order.manager.food.order.manager.mappers.FoodOrderMapper;
import io.order.manager.food.order.manager.repositories.FoodOrderRepositories;
import io.order.manager.food.order.manager.services.FoodOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class FoodOrderServiceImp implements FoodOrderService {
    @Autowired
    private FoodOrderRepositories foodOrderRepositories;
    @Autowired
    private FoodOrderMapper foodOrderMapper;


    // Delete Order
    @Override
    public String deleteOrder(int id) {
        if (foodOrderRepositories.findById(id).isPresent()) {
            foodOrderRepositories.deleteById(id);
            return "order supprimé";
        } else {
            return "order non supprimé";
        }
    }
    @Override
    public List<FoodOrderDTO> getAllOrders() {
        List<Food_Order> allOrders = foodOrderRepositories.findAll();
        return allOrders.stream().map(x -> foodOrderMapper.convertEntityToDto(x)).collect(Collectors.toList());
    }

    @Override
    public FoodOrderDTO findOneOrder(int id) {
        return null;
    }

    @Override
    public FoodOrderDTO saveOrder(FoodOrderDTO foodOrderDTO) {
        Food_Order food_order = foodOrderRepositories.save(foodOrderMapper.convertDtoToEntity(foodOrderDTO));
        return foodOrderMapper.convertEntityToDto(food_order);
    }
   /* @Override
    public FoodOrderDTO findOneOrder(int id) {
        return foodOrderMapper.convertEntityToDto(foodOrderRepositories.findById(id));
    }*/



    @Override
    public void updateOrder(int id, FoodOrderDTO foodOrderDTO) {
        if(!Objects.equals(id, foodOrderDTO.getId())){
            throw new IllegalArgumentException("IDs don't match");
        }
        Food_Order food_order = foodOrderMapper.convertDtoToEntity(foodOrderDTO);
        foodOrderRepositories.save(food_order);
    }





}

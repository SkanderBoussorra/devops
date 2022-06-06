package io.order.manager.food.order.manager.mappers;

import io.order.manager.food.order.manager.dto.FoodOrderDTO;
import io.order.manager.food.order.manager.dto.UserDTO;
import io.order.manager.food.order.manager.entities.Food_Order;
import io.order.manager.food.order.manager.entities.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodOrderMapper {
    @Autowired
    private ModelMapper modelMapper;

    public FoodOrderDTO convertEntityToDto(Food_Order food_order){

        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        FoodOrderDTO foodOrderDTO = new FoodOrderDTO();
        foodOrderDTO = modelMapper.map(food_order, FoodOrderDTO.class);
        return foodOrderDTO;
    }

    public Food_Order convertDtoToEntity(FoodOrderDTO foodOrderDTO){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        Food_Order food_order = new Food_Order();
        food_order = modelMapper.map(foodOrderDTO, Food_Order.class);
        return food_order;
    }
}

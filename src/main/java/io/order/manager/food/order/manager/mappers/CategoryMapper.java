package io.order.manager.food.order.manager.mappers;

import io.order.manager.food.order.manager.dto.CategoryDTO;
import io.order.manager.food.order.manager.dto.FoodOrderDTO;
import io.order.manager.food.order.manager.entities.Category;
import io.order.manager.food.order.manager.entities.Food_Order;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryMapper {
    @Autowired
    private ModelMapper modelMapper;

    public CategoryDTO convertEntityToDto(Category category){

        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO = modelMapper.map(category, CategoryDTO.class);
        return categoryDTO;
    }

    public Category convertDtoToEntity(CategoryDTO categoryDTO){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        Category category = new Category();
        category = modelMapper.map(categoryDTO, Category.class);
        return category;
    }
}

package io.order.manager.food.order.manager.repositories;

import io.order.manager.food.order.manager.entities.Food_Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodOrderRepositories extends JpaRepository<Food_Order,Integer> {
}

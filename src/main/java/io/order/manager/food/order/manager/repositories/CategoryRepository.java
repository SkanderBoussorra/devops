package io.order.manager.food.order.manager.repositories;

import io.order.manager.food.order.manager.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import javax.transaction.Transactional;
import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("SELECT nom FROM Category")
    public List<String> CatNames();
    @Modifying
    @Transactional
    @Query("UPDATE Category c SET c.nom=:nom1 where c.id=:categoryID")
    public void mettreAjourEmailByEmployeIdJPQL(@Param("nom1")String email, @Param("categoryID")Long categoryID);
}

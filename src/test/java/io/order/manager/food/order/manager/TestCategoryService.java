package io.order.manager.food.order.manager;

import io.order.manager.food.order.manager.entities.Category;
import io.order.manager.food.order.manager.services.impl.CategoryServicesImp;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertNotEquals;
import java.util.List;
import java.text.ParseException;
import java.util.Optional;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCategoryService {
    @Autowired
    CategoryServicesImp categorySerImp;
    @Test
    public void getAllCatNamesJPQL() {
        List<String> actual_names = categorySerImp.getAllCatNamesJPQL();
        Assert.assertTrue(actual_names.size() > 0);
    }
    @Test
    public void getAllCatigories() {
        List<Category> employees = categorySerImp.getAllEmployes();
        Assert.assertNotNull(employees);
    }
    @Test
    public void ajouterCategorie() throws ParseException {

        Category em = new Category("did", "bsr");
        Long employeId = categorySerImp.ajouterEmploye(em);
        assertEquals("check ajout employé ",employeId);
    }
    @Test
    public void mettreAjourNOMCategoryIdJPQL() {
        String newnom = "sko@mail.com";
        categorySerImp.mettreAjourEmailByEmployeId(newnom, categorySerImp.getAllEmployes().get(0).getId());
        String nomupdated = categorySerImp.getAllEmployes().get(0).getNom();

        Assert.assertEquals("check updated mail ", newnom, nomupdated);
    }


}

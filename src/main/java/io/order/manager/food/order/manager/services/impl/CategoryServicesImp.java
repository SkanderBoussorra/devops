package io.order.manager.food.order.manager.services.impl;


import io.order.manager.food.order.manager.dto.CategoryDTO;
import io.order.manager.food.order.manager.entities.Category;
import io.order.manager.food.order.manager.entities.Food_Order;
import io.order.manager.food.order.manager.mappers.CategoryMapper;
import io.order.manager.food.order.manager.repositories.CategoryRepository;
import io.order.manager.food.order.manager.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CategoryServicesImp implements CategoryService {
    private static final Logger log = Logger.getLogger(CategoryServicesImp.class);

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<CategoryDTO> listAll() {
        List<Category> allOrders = categoryRepository.findAll();
        return allOrders.stream().map(x -> categoryMapper.convertEntityToDto(x)).collect(Collectors.toList());
    }

    @Override
    public CategoryDTO save(CategoryDTO cat) {
        Category category = categoryRepository.save(categoryMapper.convertDtoToEntity(cat));
        return categoryMapper.convertEntityToDto(category);
    }

    @Override
    public void update(Long id, CategoryDTO categoryDTO) {
        if(!Objects.equals(id, categoryDTO.getId())){
            throw new IllegalArgumentException("IDs don't match");
        }
        Category category = categoryMapper.convertDtoToEntity(categoryDTO);
        categoryRepository.save(category);
    }

    @Override
    public String delete(Long id) {
        if (categoryRepository.findById(id).isPresent()) {
            categoryRepository.deleteById(id);
            return "order supprimé";
        } else {
            return "order non supprimé";
        }
    }

    @Override
    public List<String> getAllCatNamesJPQL() {
        log.info("** start  getAllCatNamesJPQL : ");
        List<String> names = null;
        try {
            names = categoryRepository.CatNames();
            log.debug(" -- N° 1 : Names of category : "+names);
            log.info("** end  getAllCatNamesJPQL without error ");
        }catch(Exception e ){
            log.info("** end  getAllCatNamesJPQL with error : "+e);
        }
        return names;
    }
    @Override
    public List<Category> getAllEmployes() {
        log.info("** start  getAllEmployees : ");
        List<Category> employeeList = null;
        try {
            employeeList = (List<Category>) categoryRepository.findAll();
            log.debug(" -- N° 1 : the employee list count :" +employeeList.size() );
            log.info("** end  getAllEmployees without error ");
        }catch(Exception e ){
            log.info("** end  getAllEmployees with error  : "+e);
        }
        return employeeList ;
    }
    @Override
    public Long ajouterEmploye(Category category) {
        log.info("Dans ajouterEmploye() : ");
        log.debug("Ajout de l'emplyé " + category);
        try {
            categoryRepository.save(category);
            log.debug("Ajout Employé fait !!!");
            log.info("Sortie de ajouterEmployé sans erreurs");

        } catch (Exception e) {
            log.error("Erreure dans ajouterEmploye() : " + e);
        }

        return category.getId();
    }
    @Override
    public void mettreAjourEmailByEmployeId(String nom, Long categoryID) {
        log.info("** start  UpdateEmailByEmployeeIdJPQL : ");
        try {
            log.debug(" -- N° 1 : the employee :" + categoryID +" will have a new mail :" + nom );
            categoryRepository.mettreAjourEmailByEmployeIdJPQL(nom, categoryID);
            log.debug(" -- N° 2 : the employee :" + categoryID +" updated successfully " );
            log.info("** end  UpdateEmailByEmployeeIdJPQL without error ");
        }catch (Exception e ){
            log.info("** end  UpdateEmailByEmployeeIdJPQL with error : "+e);
        }

    }
}

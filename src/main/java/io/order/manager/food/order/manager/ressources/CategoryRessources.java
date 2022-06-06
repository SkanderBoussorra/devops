package io.order.manager.food.order.manager.ressources;

import io.order.manager.food.order.manager.dto.CategoryDTO;
import io.order.manager.food.order.manager.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/category")
public class CategoryRessources {
    @Autowired
    CategoryService categoryService;

    @GetMapping
// Affiche Liste des category
    public List<CategoryDTO> allOffers() {
        return categoryService.listAll();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    //Ajouter category:
    public ResponseEntity<CategoryDTO> addcategory(@RequestBody CategoryDTO categoryDTO) {
        return new ResponseEntity<>(categoryService.save(categoryDTO), HttpStatus.OK);    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    // Update category
    public ResponseEntity<String> updateCategory(@PathVariable(value = "id") Long id, @RequestBody CategoryDTO categoryDTO) {
        categoryService.update(id, categoryDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    // Delete category
    public ResponseEntity<String> deletecategory(@PathVariable(value = "id") Long id) {
        categoryService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

package se.lexicon.marketplaceapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.marketplaceapi.domain.dto.CategoryDTOForm;
import se.lexicon.marketplaceapi.domain.dto.CategoryDTOView;
import se.lexicon.marketplaceapi.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<CategoryDTOView> createCategory(@RequestBody CategoryDTOForm dto) {
        CategoryDTOView createdCategory = categoryService.createCategory(dto);
        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTOView> getCategoryById(@PathVariable Long id) {
        CategoryDTOView category = categoryService.findById(id);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTOView>> getAllCategories() {
        List<CategoryDTOView> categories = categoryService.findAll();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDTOView> updateCategory(@PathVariable Long id, @RequestBody CategoryDTOForm dto) {
        CategoryDTOView updatedCategory = categoryService.updateCategory(id, dto);
        return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

package se.lexicon.marketplaceapi.service;

import se.lexicon.marketplaceapi.domain.dto.CategoryDTOForm;
import se.lexicon.marketplaceapi.domain.dto.CategoryDTOView;

import java.util.List;

public interface CategoryService {
    CategoryDTOView createCategory(CategoryDTOForm dto);
    CategoryDTOView findById(Long id);
    List<CategoryDTOView> findAll();
    CategoryDTOView updateCategory(Long id, CategoryDTOForm dto);
    void deleteCategory(Long id);
}

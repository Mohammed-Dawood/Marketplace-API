package se.lexicon.marketplaceapi.service.impl;

import org.springframework.stereotype.Service;
import se.lexicon.marketplaceapi.converter.CategoryConverter;
import se.lexicon.marketplaceapi.domain.dto.CategoryDTOForm;
import se.lexicon.marketplaceapi.domain.dto.CategoryDTOView;
import se.lexicon.marketplaceapi.domain.entity.Category;
import se.lexicon.marketplaceapi.repository.CategoryRepository;
import se.lexicon.marketplaceapi.service.CategoryService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryConverter categoryConverter;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryConverter categoryConverter) {
        this.categoryRepository = categoryRepository;
        this.categoryConverter = categoryConverter;
    }

    @Override
    public CategoryDTOView createCategory(CategoryDTOForm dto) {
        Category category = categoryConverter.toEntity(dto);
        Category savedCategory = categoryRepository.save(category);
        return categoryConverter.toCategoryDTO(savedCategory);
    }

    @Override
    public CategoryDTOView findById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Category not found with ID: " + id));
        return categoryConverter.toCategoryDTO(category);
    }

    @Override
    public List<CategoryDTOView> findAll() {
        return categoryRepository.findAll()
                .stream()
                .map(categoryConverter::toCategoryDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTOView updateCategory(Long id, CategoryDTOForm dto) {
        Category existingCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Category not found with ID: " + id));
        Category updatedCategory = categoryConverter.toEntity(dto);
        updatedCategory.setId(existingCategory.getId());
        Category savedCategory = categoryRepository.save(updatedCategory);
        return categoryConverter.toCategoryDTO(savedCategory);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}

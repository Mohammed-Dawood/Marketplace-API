package se.lexicon.marketplaceapi.converter;

import org.springframework.stereotype.Component;
import se.lexicon.marketplaceapi.domain.dto.CategoryDTOForm;
import se.lexicon.marketplaceapi.domain.dto.CategoryDTOView;
import se.lexicon.marketplaceapi.domain.entity.Category;

@Component
public class CategoryConverterImpl implements CategoryConverter {
    @Override
    public CategoryDTOView toCategoryDTO(Category entity) {
        return CategoryDTOView.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    @Override
    public Category toEntity(CategoryDTOForm dto) {
        return Category.builder()
                .id(dto.getId())
                .name(dto.getName())
                .build();
    }
}

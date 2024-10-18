package se.lexicon.marketplaceapi.converter;

import org.springframework.stereotype.Component;
import se.lexicon.marketplaceapi.domain.dto.CategoryDTOForm;
import se.lexicon.marketplaceapi.domain.dto.CategoryDTOView;
import se.lexicon.marketplaceapi.domain.entity.Category;

@Component
public interface CategoryConverter {
    CategoryDTOView toCategoryDTO(Category entity);
    Category toEntity(CategoryDTOForm dto);
}

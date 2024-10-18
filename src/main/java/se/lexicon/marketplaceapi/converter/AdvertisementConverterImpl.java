package se.lexicon.marketplaceapi.converter;

import org.springframework.stereotype.Component;
import se.lexicon.marketplaceapi.domain.dto.AdvertisementDTOForm;
import se.lexicon.marketplaceapi.domain.dto.AdvertisementDTOView;
import se.lexicon.marketplaceapi.domain.entity.Advertisement;
import se.lexicon.marketplaceapi.domain.entity.User;
import se.lexicon.marketplaceapi.domain.entity.Category;
import se.lexicon.marketplaceapi.repository.UserRepository;
import se.lexicon.marketplaceapi.repository.CategoryRepository;

import java.util.Optional;

@Component
public class AdvertisementConverterImpl implements AdvertisementConverter {

    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    public AdvertisementConverterImpl(UserRepository userRepository, CategoryRepository categoryRepository) {
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public AdvertisementDTOView toAdvertisementDTO(Advertisement entity) {
        return AdvertisementDTOView.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .price(entity.getPrice())
                .expirationDate(entity.getExpirationDate())
                .userUsername(entity.getUser().getUsername())  // Fetch the user's username
                .categoryName(entity.getCategory().getName())  // Fetch the category name
                .build();
    }

    @Override
    public Advertisement toEntity(AdvertisementDTOForm dto) {

        // Find the User by ID from the repository
        Optional<User> userOptional = userRepository.findById(dto.getUserId());
        User user = userOptional.orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + dto.getUserId()));

        // Find the Category by ID from the repository
        Optional<Category> categoryOptional = categoryRepository.findById(dto.getCategoryId());
        Category category = categoryOptional.orElseThrow(() -> new IllegalArgumentException("Category not found with ID: " + dto.getCategoryId()));

        // Build the Advertisement entity
        return Advertisement.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .expirationDate(dto.getExpirationDate())
                .user(user)  // Set the user entity
                .category(category)  // Set the category entity
                .build();
    }
}

package se.lexicon.marketplaceapi.repository;

import se.lexicon.marketplaceapi.domain.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    // Find category by name
    Optional<Category> findByName(String name);
}

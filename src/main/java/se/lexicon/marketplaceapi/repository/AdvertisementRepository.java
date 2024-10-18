package se.lexicon.marketplaceapi.repository;

import se.lexicon.marketplaceapi.domain.entity.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {

    // Find advertisements by user (using email for authentication)
    List<Advertisement> findByUser_Email(String email);

    // Find advertisements by category
    List<Advertisement> findByCategory_Id(Long categoryId);

    // Find advertisements by expiration date (to remove expired ones)
    List<Advertisement> findByExpirationDateBefore(LocalDate date);

    // Find advertisements by title or description (for search/filtering)
    List<Advertisement> findByTitleContainingOrDescriptionContaining(String title, String description);
}

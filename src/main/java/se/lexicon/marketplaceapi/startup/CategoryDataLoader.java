package se.lexicon.marketplaceapi.startup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.lexicon.marketplaceapi.domain.entity.Category;
import se.lexicon.marketplaceapi.repository.CategoryRepository;

@Component
public class CategoryDataLoader implements CommandLineRunner {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryDataLoader(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println(" ");
        System.out.println("##############################");
        System.out.println("Save 10 categories in database");
        categoryRepository.save(new Category("Electronics"));
        categoryRepository.save(new Category("Furniture"));
        categoryRepository.save(new Category("Clothing"));
        categoryRepository.save(new Category("Books"));
        categoryRepository.save(new Category("Toys"));
        categoryRepository.save(new Category("Automotive"));
        categoryRepository.save(new Category("Home Appliances"));
        categoryRepository.save(new Category("Sports"));
        categoryRepository.save(new Category("Music Instruments"));
        categoryRepository.save(new Category("Food & Beverages"));

    }
}

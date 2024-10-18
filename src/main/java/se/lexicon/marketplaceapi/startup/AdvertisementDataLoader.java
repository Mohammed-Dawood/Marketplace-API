package se.lexicon.marketplaceapi.startup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.lexicon.marketplaceapi.domain.entity.Advertisement;
import se.lexicon.marketplaceapi.domain.entity.Category;
import se.lexicon.marketplaceapi.domain.entity.User;
import se.lexicon.marketplaceapi.repository.AdvertisementRepository;
import se.lexicon.marketplaceapi.repository.CategoryRepository;
import se.lexicon.marketplaceapi.repository.UserRepository;

import java.time.LocalDate;

@Component
public class AdvertisementDataLoader implements CommandLineRunner {

    private final AdvertisementRepository advertisementRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public AdvertisementDataLoader(AdvertisementRepository advertisementRepository, UserRepository userRepository, CategoryRepository categoryRepository) {
        this.advertisementRepository = advertisementRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Fetch users and categories (assuming these already exist in the DB)
        User user1 = userRepository.findByEmail("john.doe@example.com").orElse(null);
        User user2 = userRepository.findByEmail("jane.smith@example.com").orElse(null);
        User user3 = userRepository.findByEmail("mike.jones@example.com").orElse(null);
        User user4 = userRepository.findByEmail("lisa.white@example.com").orElse(null);
        User user5 = userRepository.findByEmail("david.brown@example.com").orElse(null);
        User user6 = userRepository.findByEmail("emily.black@example.com").orElse(null);
        User user7 = userRepository.findByEmail("will.smith@example.com").orElse(null);
        User user8 = userRepository.findByEmail("nancy.davis@example.com").orElse(null);
        User user9 = userRepository.findByEmail("paul.taylor@example.com").orElse(null);
        User user10 = userRepository.findByEmail("rachel.martin@example.com").orElse(null);

        Category electronics = categoryRepository.findByName("Electronics").orElse(null);
        Category furniture = categoryRepository.findByName("Furniture").orElse(null);
        Category clothing = categoryRepository.findByName("Clothing").orElse(null);
        Category books = categoryRepository.findByName("Books").orElse(null);
        Category toys = categoryRepository.findByName("Toys").orElse(null);
        Category automotive = categoryRepository.findByName("Automotive").orElse(null);
        Category homeAppliances = categoryRepository.findByName("Home Appliances").orElse(null);
        Category sports = categoryRepository.findByName("Sports").orElse(null);
        Category musicInstruments = categoryRepository.findByName("Music Instruments").orElse(null);
        Category foodBeverages = categoryRepository.findByName("Food & Beverages").orElse(null);

        System.out.println(" ");
        System.out.println("#########################");
        System.out.println("Save 10 advertisements in database");
        advertisementRepository.save(new Advertisement("Samsung Galaxy S21", "Brand new Samsung Galaxy S21, unlocked", 900, LocalDate.now().plusMonths(1), user1, electronics));
        advertisementRepository.save(new Advertisement("Luxury Sofa Set", "Comfortable sofa set, perfect for living room", 1500, LocalDate.now().plusMonths(1), user2, furniture));
        advertisementRepository.save(new Advertisement("Nike Running Shoes", "Men's Nike running shoes, size 10", 75, LocalDate.now().plusMonths(1), user3, clothing));
        advertisementRepository.save(new Advertisement("The Great Gatsby", "A classic novel, hardcover", 20, LocalDate.now().plusMonths(1), user4, books));
        advertisementRepository.save(new Advertisement("Remote Control Car", "High-speed RC car for kids", 40, LocalDate.now().plusMonths(1), user5, toys));
        advertisementRepository.save(new Advertisement("Car Tires", "Set of 4 car tires, brand new", 200, LocalDate.now().plusMonths(1), user6, automotive));
        advertisementRepository.save(new Advertisement("Blender", "High-performance blender for smoothies", 120, LocalDate.now().plusMonths(1), user7, homeAppliances));
        advertisementRepository.save(new Advertisement("Basketball", "Official size basketball, great for outdoor play", 30, LocalDate.now().plusMonths(1), user8, sports));
        advertisementRepository.save(new Advertisement("Electric Guitar", "Used electric guitar, includes amp", 300, LocalDate.now().plusMonths(1), user9, musicInstruments));
        advertisementRepository.save(new Advertisement("Organic Juice", "Freshly squeezed organic juice, 100% natural", 5, LocalDate.now().plusMonths(1), user10, foodBeverages));

    }
}

package se.lexicon.marketplaceapi.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "category")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    // One category can have multiple advertisements
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Advertisement> advertisements = new HashSet<>();

    // Constructor for creating Category without advertisements
    public Category(String name) {
        this.name = name;
    }

    // Helper method to add advertisements to this category
    public void addAdvertisement(Advertisement... advertisements) {
        if (advertisements.length == 0)
            throw new IllegalArgumentException("Advertisements cannot be empty");
        for (Advertisement advertisement : advertisements) {
            this.advertisements.add(advertisement);
            advertisement.setCategory(this); // Ensure the advertisement's category reference is set to this category
        }
    }

    // Helper method to remove advertisements from this category
    public void removeAdvertisement(Advertisement... advertisements) {
        if (advertisements.length == 0)
            throw new IllegalArgumentException("Advertisements cannot be empty");
        for (Advertisement advertisement : advertisements) {
            this.advertisements.remove(advertisement);
            advertisement.setCategory(null); // Unset the category reference in advertisement
        }
    }
}

package se.lexicon.marketplaceapi.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "advertisement")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Advertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Integer price;

    // Add expiration date for each advertisement
    @Column(nullable = false)
    private LocalDate expirationDate;

    // One advertisement is associated with one user
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false) // Foreign key to User table
    private User user;

    // One advertisement is associated with one category
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false) // Foreign key to Category table
    private Category category;

    // Constructor with User and Category
    public Advertisement(String title, String description, Integer price, LocalDate expirationDate, User user, Category category) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.expirationDate = expirationDate;
        this.user = user;
        this.category = category;
    }

    // Constructor for creating Advertisement without User and Category
    public Advertisement(String title, String description, Integer price, LocalDate expirationDate) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.expirationDate = expirationDate;
    }
}

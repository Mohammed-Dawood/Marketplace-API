package se.lexicon.marketplaceapi.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
@Entity
public class Advertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime expirationDate;

    @Column(nullable = false, length = 500) // Add description column
    private String description;

    // Many-to-One relationship with Category: Each Advertisement belongs to one Category
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false) // foreign key in Advertisement table
    private Category category;

    // Many-to-One relationship with User: Each Advertisement is created by one User
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false) // foreign key in Advertisement table
    private User user;

    // Constructor
    public Advertisement(String title, LocalDateTime createdAt, LocalDateTime expirationDate, String description, Category category, User user) {
        this.title = title;
        this.createdAt = createdAt;
        this.expirationDate = expirationDate;
        this.description = description;
        this.category = category;
        this.user = user;
    }

    // Helper method to update the description of the advertisement
    public void updateDescription(String newDescription) {
        if (newDescription == null || newDescription.trim().isEmpty()) {
            throw new IllegalArgumentException("Description cannot be empty or null");
        }
        this.description = newDescription;
    }
}

package se.lexicon.marketplaceapi.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    // One-to-Many relationship with Advertisement
    @OneToMany
    @JoinColumn(name = "user_id") // foreign key in Advertisement table
    private List<Advertisement> advertisements = new ArrayList<>();

    // Constructor
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    // Helper method to add an advertisement
    public void addAdvertisement(Advertisement advertisement) {
        if (advertisement == null) {
            throw new IllegalArgumentException("Advertisement cannot be null");
        }
        advertisements.add(advertisement);
        // Ensure the relationship is bidirectional
        if (advertisement.getUser() != this) {
            advertisement.setUser(this);
        }
    }

    // Helper method to remove one or more advertisements
    public void removeAdvertisement(Advertisement... ads) {
        if (Objects.requireNonNull(ads).length == 0)
            throw new IllegalArgumentException("Advertisements cannot be empty");
        for (Advertisement ad : ads) {
            if (this.advertisements.remove(ad)) {
                ad.setUser(null); // Remove the association with this User
            }
        }
    }
}

package se.lexicon.marketplaceapi.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    // One user can have multiple advertisements.
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Advertisement> advertisements = new HashSet<>();

    // Constructor to initialize User without advertisements
    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    // Helper method to add advertisements to this user
    public void addAdvertisement(Advertisement... advertisements) {
        if (advertisements.length == 0)
            throw new IllegalArgumentException("Advertisements cannot be empty");
        for (Advertisement advertisement : advertisements) {
            this.advertisements.add(advertisement);
            advertisement.setUser(this); // Ensure advertisement’s user reference is set to this user
        }
    }

    // Helper method to remove advertisements from this user
    public void removeAdvertisement(Advertisement... advertisements) {
        if (advertisements.length == 0)
            throw new IllegalArgumentException("Advertisements cannot be empty");
        for (Advertisement advertisement : advertisements) {
            this.advertisements.remove(advertisement);
            advertisement.setUser(null); // Unset advertisement’s user reference
        }
    }
}

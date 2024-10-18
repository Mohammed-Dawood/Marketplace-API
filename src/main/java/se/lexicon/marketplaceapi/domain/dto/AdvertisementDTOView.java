package se.lexicon.marketplaceapi.domain.dto;

import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class AdvertisementDTOView {

    private Long id;
    private String title;
    private String description;
    private Integer price;
    private LocalDate expirationDate;
    private String userUsername;  // To show the username of the user who posted the advertisement
    private String categoryName;  // To show the name of the category for the advertisement
}

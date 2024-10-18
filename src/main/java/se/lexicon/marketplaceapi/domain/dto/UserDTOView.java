package se.lexicon.marketplaceapi.domain.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserDTOView {

    private Long id;
    private String username;
    private String email;
}

package se.lexicon.marketplaceapi.domain.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CategoryDTOView {

    private Long id;
    private String name;
}

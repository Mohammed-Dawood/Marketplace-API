package se.lexicon.marketplaceapi.converter;

import org.springframework.stereotype.Component;
import se.lexicon.marketplaceapi.domain.dto.UserDTOForm;
import se.lexicon.marketplaceapi.domain.dto.UserDTOView;
import se.lexicon.marketplaceapi.domain.entity.User;

@Component
public interface UserConverter {
    UserDTOView toUserDTO(User entity);
    User toEntity(UserDTOForm dto);
}

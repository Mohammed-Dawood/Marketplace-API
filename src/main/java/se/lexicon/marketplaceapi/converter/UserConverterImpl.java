package se.lexicon.marketplaceapi.converter;

import org.springframework.stereotype.Component;
import se.lexicon.marketplaceapi.domain.dto.UserDTOForm;
import se.lexicon.marketplaceapi.domain.dto.UserDTOView;
import se.lexicon.marketplaceapi.domain.entity.User;

@Component
public class UserConverterImpl implements UserConverter {
    @Override
    public UserDTOView toUserDTO(User entity) {
        return UserDTOView.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .email(entity.getEmail())
                .build();
    }

    @Override
    public User toEntity(UserDTOForm dto) {
        return User.builder()
                .id(dto.getId())
                .username(dto.getUsername())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .build();
    }
}

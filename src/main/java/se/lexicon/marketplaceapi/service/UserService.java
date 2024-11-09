package se.lexicon.marketplaceapi.service;

import se.lexicon.marketplaceapi.domain.dto.UserDTOForm;
import se.lexicon.marketplaceapi.domain.dto.UserDTOView;

import java.util.List;

public interface UserService {
    UserDTOView createUser(UserDTOForm dto);
    UserDTOView findById(Long id);
    List<UserDTOView> findAll();
    UserDTOView updateUser(Long id, UserDTOForm dto);
    void deleteUser(Long id);
}

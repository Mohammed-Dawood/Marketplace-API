package se.lexicon.marketplaceapi.service.impl;

import org.springframework.stereotype.Service;
import se.lexicon.marketplaceapi.converter.UserConverter;
import se.lexicon.marketplaceapi.domain.dto.UserDTOForm;
import se.lexicon.marketplaceapi.domain.dto.UserDTOView;
import se.lexicon.marketplaceapi.domain.entity.User;
import se.lexicon.marketplaceapi.repository.UserRepository;
import se.lexicon.marketplaceapi.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;

    public UserServiceImpl(UserRepository userRepository, UserConverter userConverter) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
    }

    @Override
    public UserDTOView createUser(UserDTOForm dto) {
        User user = userConverter.toEntity(dto);
        User savedUser = userRepository.save(user);
        return userConverter.toUserDTO(savedUser);
    }

    @Override
    public UserDTOView findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + id));
        return userConverter.toUserDTO(user);
    }

    @Override
    public List<UserDTOView> findAll() {
        return userRepository.findAll()
                .stream()
                .map(userConverter::toUserDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTOView updateUser(Long id, UserDTOForm dto) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + id));
        User updatedUser = userConverter.toEntity(dto);
        updatedUser.setId(existingUser.getId());
        User savedUser = userRepository.save(updatedUser);
        return userConverter.toUserDTO(savedUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}

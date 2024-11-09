package se.lexicon.marketplaceapi.service.impl;

import org.springframework.stereotype.Service;
import se.lexicon.marketplaceapi.converter.AdvertisementConverter;
import se.lexicon.marketplaceapi.domain.dto.AdvertisementDTOForm;
import se.lexicon.marketplaceapi.domain.dto.AdvertisementDTOView;
import se.lexicon.marketplaceapi.domain.entity.Advertisement;
import se.lexicon.marketplaceapi.repository.AdvertisementRepository;
import se.lexicon.marketplaceapi.service.AdvertisementService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdvertisementServiceImpl implements AdvertisementService {

    private final AdvertisementRepository advertisementRepository;
    private final AdvertisementConverter advertisementConverter;

    public AdvertisementServiceImpl(AdvertisementRepository advertisementRepository, AdvertisementConverter advertisementConverter) {
        this.advertisementRepository = advertisementRepository;
        this.advertisementConverter = advertisementConverter;
    }

    @Override
    public AdvertisementDTOView createAdvertisement(AdvertisementDTOForm dto) {
        Advertisement advertisement = advertisementConverter.toEntity(dto);
        Advertisement savedAdvertisement = advertisementRepository.save(advertisement);
        return advertisementConverter.toAdvertisementDTO(savedAdvertisement);
    }

    @Override
    public AdvertisementDTOView findById(Long id) {
        Advertisement advertisement = advertisementRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Advertisement not found with ID: " + id));
        return advertisementConverter.toAdvertisementDTO(advertisement);
    }

    @Override
    public List<AdvertisementDTOView> findAll() {
        return advertisementRepository.findAll()
                .stream()
                .map(advertisementConverter::toAdvertisementDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AdvertisementDTOView updateAdvertisement(Long id, AdvertisementDTOForm dto) {
        Advertisement existingAdvertisement = advertisementRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Advertisement not found with ID: " + id));
        Advertisement updatedAdvertisement = advertisementConverter.toEntity(dto);
        updatedAdvertisement.setId(existingAdvertisement.getId());
        Advertisement savedAdvertisement = advertisementRepository.save(updatedAdvertisement);
        return advertisementConverter.toAdvertisementDTO(savedAdvertisement);
    }

    @Override
    public void deleteAdvertisement(Long id) {
        advertisementRepository.deleteById(id);
    }
}

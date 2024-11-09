package se.lexicon.marketplaceapi.service;

import se.lexicon.marketplaceapi.domain.dto.AdvertisementDTOForm;
import se.lexicon.marketplaceapi.domain.dto.AdvertisementDTOView;

import java.util.List;

public interface AdvertisementService {
    AdvertisementDTOView createAdvertisement(AdvertisementDTOForm dto);
    AdvertisementDTOView findById(Long id);
    List<AdvertisementDTOView> findAll();
    AdvertisementDTOView updateAdvertisement(Long id, AdvertisementDTOForm dto);
    void deleteAdvertisement(Long id);
}

package se.lexicon.marketplaceapi.converter;

import org.springframework.stereotype.Component;
import se.lexicon.marketplaceapi.domain.dto.AdvertisementDTOForm;
import se.lexicon.marketplaceapi.domain.dto.AdvertisementDTOView;
import se.lexicon.marketplaceapi.domain.entity.Advertisement;

@Component
public interface AdvertisementConverter {
    AdvertisementDTOView toAdvertisementDTO(Advertisement entity);
    Advertisement toEntity(AdvertisementDTOForm dto);
}

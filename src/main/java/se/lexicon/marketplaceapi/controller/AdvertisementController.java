package se.lexicon.marketplaceapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.marketplaceapi.domain.dto.AdvertisementDTOForm;
import se.lexicon.marketplaceapi.domain.dto.AdvertisementDTOView;
import se.lexicon.marketplaceapi.service.AdvertisementService;

import java.util.List;

@RestController
@RequestMapping("/api/advertisements")
public class AdvertisementController {

    private final AdvertisementService advertisementService;

    public AdvertisementController(AdvertisementService advertisementService) {
        this.advertisementService = advertisementService;
    }

    @PostMapping
    public ResponseEntity<AdvertisementDTOView> createAdvertisement(@RequestBody AdvertisementDTOForm dto) {
        AdvertisementDTOView createdAdvertisement = advertisementService.createAdvertisement(dto);
        return new ResponseEntity<>(createdAdvertisement, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdvertisementDTOView> getAdvertisementById(@PathVariable Long id) {
        AdvertisementDTOView advertisement = advertisementService.findById(id);
        return new ResponseEntity<>(advertisement, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AdvertisementDTOView>> getAllAdvertisements() {
        List<AdvertisementDTOView> advertisements = advertisementService.findAll();
        return new ResponseEntity<>(advertisements, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdvertisementDTOView> updateAdvertisement(@PathVariable Long id, @RequestBody AdvertisementDTOForm dto) {
        AdvertisementDTOView updatedAdvertisement = advertisementService.updateAdvertisement(id, dto);
        return new ResponseEntity<>(updatedAdvertisement, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdvertisement(@PathVariable Long id) {
        advertisementService.deleteAdvertisement(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

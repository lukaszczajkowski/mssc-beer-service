package guru.springframework.msscbeerservice.bootstrap;

import guru.springframework.msscbeerservice.domain.Beer;
import guru.springframework.msscbeerservice.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Component
public class BeerLoader implements CommandLineRunner {

    public static final String BEER_1_UPC = "0631234200036";
    public static final String BEER_2_UPC = "0631234200019";
    public static final String BEER_3_UPC = "0083783375213";

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (beerRepository.count() == 0) {
            loadBeerObjects();
        }
    }

    private void loadBeerObjects() {
        beerRepository.save(Beer.builder()
                .beerName("Mango Bobs")
                .beerStyle("IPA")
                .quantityToBrew(200)
                .upc(BEER_1_UPC)
                .price(new BigDecimal("12.95"))
                .minOnHand(12)
                .build());

        beerRepository.save(Beer.builder()
                .beerName("Galaxy Cat")
                .beerStyle("PALE_ALE")
                .quantityToBrew(200)
                .upc(BEER_2_UPC)
                .price(new BigDecimal("11.95"))
                .minOnHand(12)
                .build());
        beerRepository.save(Beer.builder()
                .beerName("No Hammers On The Bar")
                .beerStyle("PALE_ALE")
                .quantityToBrew(200)
                .upc(BEER_3_UPC)
                .price(new BigDecimal("11.95"))
                .minOnHand(12)
                .build());
    }
}

package guru.springframework.msscbeerservice.services.order;

import guru.sfg.brewery.model.BeerOrderDto;
import guru.springframework.msscbeerservice.repositories.BeerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BeerOrderValidator {

    private final BeerRepository beerRepository;

    public boolean validateOrder(BeerOrderDto beerOrderDto) {
        return beerOrderDto.getBeerOrderLines().stream()
                .map(order -> order.getUpc())
                .filter(upc -> beerRepository.findAllByUpc(upc).isEmpty())
                .collect(Collectors.toList())
                .isEmpty();
    }
}

package com.slippery.ecs.service;

import com.slippery.ecs.dto.ShopItemDto;
import com.slippery.ecs.models.ShopItem;
import com.slippery.ecs.repository.ShopItemRepository;
import com.slippery.ecs.service.impl.ShopItemServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ShopItemServiceTests {
    @Mock
    private ShopItemRepository repository;
    @InjectMocks
    private ShopItemServiceImpl service;

    @Test
    public void testShopItemCreation(){
        ArrayList<String > imagesArrays =new ArrayList<>();
        imagesArrays.add("https://bit.ly/4gcpHZ3");
        imagesArrays.add("https://bit.ly/4gPhABR");
        imagesArrays.add("https://bit.ly/4iqCNUd");
        imagesArrays.add("https://bit.ly/3ZOvUEP");
        imagesArrays.add("https://bit.ly/4fcvgp3");
        imagesArrays.add("https://bit.ly/3ZB63ix");
        ShopItem item =ShopItem.builder()
                .name("Washed hat")
                .images(imagesArrays)
                .price(BigDecimal.valueOf(49.999))
                .offer(false)
                .offerAmount(BigDecimal.valueOf(0.00))
                .category("MEN")
                .status("available")
                .quantity(100L)
                .size("XL")
                .moreDetails("100% cotton twill Low profile One size fits most")
                .sizeAndFit("XXL,S,L")
                .qualityGuarantee("Quality is guaranteed. If there is a print error or visible quality issue, we'll replace or refund it. Because the products are made to order, we do not accept general returns or sizing-related returns.")
                .description("This hat has many talents. It can keep the sun out of your eyes and stay on your head..")
                .build();
        when(repository.save(Mockito.any(ShopItem.class))).thenReturn(item);
        ShopItemDto response =service.createNewItem(item);
        System.out.println(response);
        Assertions.assertThat(response.getErrorMessage()).isNull();

    }
    @Test
    public void findItemByIdReturnsShopItemDto() {
        ArrayList<String > imagesArrays =new ArrayList<>();
        imagesArrays.add("https://bit.ly/4gcpHZ3");
        imagesArrays.add("https://bit.ly/4gPhABR");
        imagesArrays.add("https://bit.ly/4iqCNUd");
        imagesArrays.add("https://bit.ly/3ZOvUEP");
        imagesArrays.add("https://bit.ly/4fcvgp3");
        imagesArrays.add("https://bit.ly/3ZB63ix");
        ShopItem item =ShopItem.builder()
                .name("Washed hat")
                .images(imagesArrays)
                .price(BigDecimal.valueOf(49.999))
                .offer(false)
                .offerAmount(BigDecimal.valueOf(0.00))
                .category("MEN")
                .status("available")
                .quantity(100L)
                .size("XL")
                .moreDetails("100% cotton twill Low profile One size fits most")
                .sizeAndFit("XXL,S,L")
                .qualityGuarantee("Quality is guaranteed. If there is a print error or visible quality issue, we'll replace or refund it. Because the products are made to order, we do not accept general returns or sizing-related returns.")
                .description("This hat has many talents. It can keep the sun out of your eyes and stay on your head..")
                .build();
        when(repository.findById(1L)).thenReturn(Optional.ofNullable(item));

        ShopItemDto response = service.findItemById(1L);
        System.out.println(response);
        Assertions.assertThat(response.getErrorMessage()).isNull();

    }
}

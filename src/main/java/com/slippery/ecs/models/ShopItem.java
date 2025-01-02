package com.slippery.ecs.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ShopItem {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    @Lob
    private List<String> images;
    private String name;
    private  BigDecimal price;
    private Boolean offer;
    private BigDecimal offerAmount;
    private String category;
    private String status;
    private Long quantity;
    private String size;
    @Lob
    private String moreDetails;
    private String sizeAndFit;
    @Lob
    private String qualityGuarantee;
    @Lob
    private String description;

}

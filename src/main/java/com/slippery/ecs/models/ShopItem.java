package com.slippery.ecs.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ShopItem {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;
    @ElementCollection
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

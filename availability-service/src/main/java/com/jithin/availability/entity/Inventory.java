package com.jithin.availability.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(indexName = "inventory")
public class Inventory {

    @Id
    private String sku;

    @Field(type = FieldType.Text, name = "product_name")
    private String productName;

    private GeoPoint location;

}

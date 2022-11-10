package com.grupo4.hotels.model;

import com.grupo4.hotels.model.CompositeKeys.RelationShipProductAttributteId;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "products_attributes")
@IdClass(RelationShipProductAttributteId.class)
public class ProductAttribute implements Serializable {

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_product")
    private Product product;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_attribute")
    private Attribute attribute;

    @Override
    public String toString() {
        return "ProductAttribute{" +
                "product=" + product.getTitle() +
                ", attribute=" + attribute.getTitle() +
                '}';
    }
}




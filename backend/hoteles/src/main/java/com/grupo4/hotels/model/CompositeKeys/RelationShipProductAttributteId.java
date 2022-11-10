package com.grupo4.hotels.model.CompositeKeys;

import com.grupo4.hotels.model.Attribute;
import com.grupo4.hotels.model.Product;

import javax.persistence.JoinColumn;
import java.io.Serializable;

public class RelationShipProductAttributteId implements Serializable {

    @JoinColumn(name = "id_product")
    private Product product;

    @JoinColumn(name = "id_attribute")
    private Attribute attribute;
}

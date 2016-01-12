package pl.edu.agh.fiss.android.rest.dto;

import java.util.List;

/**
 * Created by wemstar on 2016-01-12.
 */
public class BasketDTO {

    private List<ProductCountDTO> products;

    public List<ProductCountDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductCountDTO> products) {
        this.products = products;
    }
}

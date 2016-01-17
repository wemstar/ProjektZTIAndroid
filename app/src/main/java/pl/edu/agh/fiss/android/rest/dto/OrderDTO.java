package pl.edu.agh.fiss.android.rest.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wemstar on 2016-01-16.
 */
public class OrderDTO implements Serializable {
    private Long id;

    private List<ProductCountDTO> products;

    private OrderEntityState state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ProductCountDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductCountDTO> products) {
        this.products = products;
    }

    public OrderEntityState getState() {
        return state;
    }

    public void setState(OrderEntityState state) {
        this.state = state;
    }
}

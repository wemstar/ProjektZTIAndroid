package pl.edu.agh.fiss.android.rest.dto;

import java.io.Serializable;

/**
 * Created by wemstar on 2016-01-12.
 */
public class ProductCountDTO implements Serializable {

    private ProductDTO product;
    private Integer count;

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}

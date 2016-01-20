package pl.edu.agh.fiss.android.order.details.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.rest.RestService;
import pl.edu.agh.fiss.android.basket.item.BasketItemView;
import pl.edu.agh.fiss.android.basket.item.BasketItemView_;
import pl.edu.agh.fiss.android.rest.OrderService;
import pl.edu.agh.fiss.android.rest.dto.ProductCountDTO;
import pl.edu.agh.fiss.android.rest.handler.ErrorHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wemstar on 2016-01-16.
 */
@EBean
public class OrderDetailsAdapter extends BaseAdapter {

    List<ProductCountDTO> products = new ArrayList<ProductCountDTO>();

    @RestService
    OrderService orderService;

    @RootContext
    Context context;

    @Bean
    ErrorHandler errorHandler;

    @AfterInject
    void afterInject() {
        // TODO: Add activity execution to error handler
        orderService.setRestErrorHandler(errorHandler);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        BasketItemView productItemView;
        if (convertView == null) {
            productItemView = BasketItemView_.build(context);
        } else {
            productItemView = (BasketItemView) convertView;
        }

        productItemView.bind(getItem(position));

        return productItemView;
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public ProductCountDTO getItem(int position) {
        return products.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void setProducts(List<ProductCountDTO> products) {
        this.products = products;
        notifyDataSetChanged();
    }
}

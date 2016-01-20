package pl.edu.agh.fiss.android.basket.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import org.androidannotations.annotations.*;
import org.androidannotations.annotations.rest.RestService;
import pl.edu.agh.fiss.android.basket.item.BasketItemView;
import pl.edu.agh.fiss.android.basket.item.BasketItemView_;
import pl.edu.agh.fiss.android.rest.BasketService;
import pl.edu.agh.fiss.android.rest.dto.BasketDTO;
import pl.edu.agh.fiss.android.rest.dto.ProductCountDTO;
import pl.edu.agh.fiss.android.rest.handler.ErrorHandler;

/**
 * Created by wemstar on 2016-01-12.
 */
@EBean
public class BasketAdapter extends BaseAdapter {

    BasketDTO basket;

    @RestService
    BasketService basketService;

    @Bean
    ErrorHandler errorHandler;

    @RootContext
    Context context;

    @AfterInject
    void initAdapter() {
        // TODO: Add activity execution to error handler
        basketService.setRestErrorHandler(errorHandler);
        loadData();
    }

    @Background
    void loadData() {
        basket = basketService.getBasket();
        reloadList();
    }

    public void refresh() {
        loadData();
    }

    @UiThread
    void reloadList() {
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        BasketItemView basketItemView;
        if (convertView == null) {
            basketItemView = BasketItemView_.build(context);
        } else {
            basketItemView = (BasketItemView) convertView;
        }

        basketItemView.bind(getItem(position));

        return basketItemView;
    }

    @Override
    public int getCount() {
        if (basket != null) {
            return basket.getProducts().size();
        }
        return 0;
    }

    @Override
    public ProductCountDTO getItem(int position) {
        return basket.getProducts().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

}

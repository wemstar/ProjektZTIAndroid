package pl.edu.agh.fiss.android.product.list.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import org.androidannotations.annotations.*;
import org.androidannotations.annotations.rest.RestService;
import pl.edu.agh.fiss.android.product.list.item.ProductItemView;
import pl.edu.agh.fiss.android.product.list.item.ProductItemView_;
import pl.edu.agh.fiss.android.rest.ProductService;
import pl.edu.agh.fiss.android.rest.dto.ProductDTO;
import pl.edu.agh.fiss.android.rest.handler.ErrorHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wemstar on 2016-01-10.
 */
@EBean
public class ProductListAdapter extends BaseAdapter {

    List<ProductDTO> products = new ArrayList<ProductDTO>();

    @RestService
    ProductService productService;

    @RootContext
    Context context;

    @Bean
    ErrorHandler errorHandler;

    @AfterInject
    void initAdapter() {
        // TODO: Add activity execution to error handler
        productService.setRestErrorHandler(errorHandler);
        loadData();
    }

    @Background
    void loadData() {
        products = productService.getAllProducts();
        reloadList();
    }

    @UiThread
    void reloadList() {
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ProductItemView personItemView;
        if (convertView == null) {
            personItemView = ProductItemView_.build(context);
        } else {
            personItemView = (ProductItemView) convertView;
        }

        personItemView.bind(getItem(position));

        return personItemView;
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public ProductDTO getItem(int position) {
        return products.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}

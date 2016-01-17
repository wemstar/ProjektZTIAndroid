package pl.edu.agh.fiss.android.order.list.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import org.androidannotations.annotations.*;
import org.androidannotations.annotations.rest.RestService;
import pl.edu.agh.fiss.android.order.list.item.OrderItemView;
import pl.edu.agh.fiss.android.order.list.item.OrderItemView_;
import pl.edu.agh.fiss.android.rest.OrderService;
import pl.edu.agh.fiss.android.rest.dto.OrderDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wemstar on 2016-01-16.
 */
@EBean
public class OrderListAdapter extends BaseAdapter {

    List<OrderDTO> orders = new ArrayList<OrderDTO>();

    @RestService
    OrderService orderService;

    @RootContext
    Context context;

    @AfterInject
    void initAdapter() {
        loadData();
    }

    @Background
    void loadData() {
        orders = orderService.getAllOrder();
        reloadList();
    }

    @UiThread
    void reloadList() {
        notifyDataSetChanged();
    }

    public void refresh() {
        loadData();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        OrderItemView personItemView;
        if (convertView == null) {
            personItemView = OrderItemView_.build(context);
        } else {
            personItemView = (OrderItemView) convertView;
        }

        personItemView.bind(getItem(position));

        return personItemView;
    }

    @Override
    public int getCount() {
        return orders.size();
    }

    @Override
    public OrderDTO getItem(int position) {
        return orders.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}

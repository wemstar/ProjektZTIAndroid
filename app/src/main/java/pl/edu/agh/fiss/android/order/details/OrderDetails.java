package pl.edu.agh.fiss.android.order.details;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
import org.androidannotations.annotations.*;
import org.androidannotations.annotations.rest.RestService;
import org.w3c.dom.Text;
import pl.edu.agh.fiss.android.R;
import pl.edu.agh.fiss.android.order.details.adapter.OrderDetailsAdapter;
import pl.edu.agh.fiss.android.rest.OrderService;
import pl.edu.agh.fiss.android.rest.dto.OrderDTO;

@EActivity(R.layout.activity_order_details)
public class OrderDetails extends AppCompatActivity {

    public static final String DETAIL_KEY = "OrderDTOItem";
    private OrderDTO orderDTO;

    @ViewById
    ListView listView;

    @ViewById
    TextView statusLabel;

    @RestService
    OrderService orderService;

    @Bean
    OrderDetailsAdapter orderDetailAdapter;

    @AfterViews
    void bindDate() {
        orderDTO = (OrderDTO) getIntent().getSerializableExtra(DETAIL_KEY);
        statusLabel.setText(orderDTO.getState().toString());
        orderDetailAdapter.setProducts(orderDTO.getProducts());
        listView.setAdapter(orderDetailAdapter);
    }

    @Click(R.id.cancelOrderButton)
    void cancelOrderButtonClicked() {
        cancelOrder();
        closeActivity();
    }

    @Click(R.id.backButton)
    void backButtonClicked() {
        closeActivity();
    }


    @Background
    void cancelOrder() {
        orderService.cancelOrder(orderDTO.getId());
    }

    @UiThread
    void closeActivity() {
        finish();
    }

}

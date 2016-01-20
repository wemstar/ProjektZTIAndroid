package pl.edu.agh.fiss.android.order.details;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.*;
import org.androidannotations.annotations.*;
import org.androidannotations.annotations.rest.RestService;
import org.w3c.dom.Text;
import pl.edu.agh.fiss.android.R;
import pl.edu.agh.fiss.android.order.details.adapter.OrderDetailsAdapter;
import pl.edu.agh.fiss.android.rest.OrderAdminService;
import pl.edu.agh.fiss.android.rest.OrderService;
import pl.edu.agh.fiss.android.rest.dto.OrderDTO;
import pl.edu.agh.fiss.android.rest.dto.OrderEntityState;
import pl.edu.agh.fiss.android.rest.handler.ErrorHandler;
import pl.edu.agh.fiss.android.utils.SucessDialog;
import pl.edu.agh.fiss.android.utils.UserContext;

@EActivity(R.layout.activity_order_details)
public class OrderDetails extends AppCompatActivity {

    public static final String DETAIL_KEY = "OrderDTOItem";
    private OrderDTO orderDTO;

    @ViewById
    ListView listView;

    @ViewById
    Spinner statusSpinner;

    @ViewById
    Button updateOrderButton;

    @RestService
    OrderService orderService;

    @RestService
    OrderAdminService orderAdminService;

    @Bean
    OrderDetailsAdapter orderDetailAdapter;

    @Bean
    ErrorHandler errorHandler;

    @Bean
    UserContext userContext;

    @AfterViews
    void bindDate() {
        errorHandler.setActivity(this);
        orderService.setRestErrorHandler(errorHandler);
        orderDTO = (OrderDTO) getIntent().getSerializableExtra(DETAIL_KEY);
        orderDetailAdapter.setProducts(orderDTO.getProducts());
        listView.setAdapter(orderDetailAdapter);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.order_status_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        statusSpinner.setAdapter(adapter);
        statusSpinner.setSelection(orderDTO.getState().position());
        updateOrderButton.setEnabled(userContext.isAdmin());
        statusSpinner.setEnabled(userContext.isAdmin());

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

    @Click(R.id.updateOrderButton)
    void updateOrderClicked() {
        updateOrder();
    }


    @Background
    void cancelOrder() {
        orderService.cancelOrder(orderDTO.getId());
        SucessDialog.sucesfullReturn(this);
    }

    @Background
    void updateOrder() {
        orderDTO.setState(OrderEntityState.valueOf((String)statusSpinner.getSelectedItem()));
        orderAdminService.updateOrder(orderDTO);
        SucessDialog.sucesfullReturn(this);
    }

    @UiThread
    void closeActivity() {
        finish();
    }

}

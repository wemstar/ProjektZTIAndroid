package pl.edu.agh.fiss.android.basket;


import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.ListView;
import org.androidannotations.annotations.*;
import org.androidannotations.annotations.rest.RestService;
import pl.edu.agh.fiss.android.R;
import pl.edu.agh.fiss.android.basket.adapter.BasketAdapter;
import pl.edu.agh.fiss.android.rest.BasketService;
import pl.edu.agh.fiss.android.rest.OrderService;
import pl.edu.agh.fiss.android.rest.dto.ProductCountDTO;
import pl.edu.agh.fiss.android.rest.handler.ErrorHandler;
import pl.edu.agh.fiss.android.utils.SucessDialog;

@EFragment(R.layout.fragment_basket_list)
public class BasketList extends Fragment implements SwipeRefreshLayout.OnRefreshListener {


    public static final String TITLE = "Koszyk";

    @ViewById
    ListView listView;

    @ViewById
    SwipeRefreshLayout swipeContainer;

    @Bean
    BasketAdapter adapter;

    @RestService
    OrderService orderService;

    @RestService
    BasketService basketService;

    @Bean
    ErrorHandler errorHandler;

    @AfterViews
    void bindAdapter() {
        errorHandler.setActivity(getActivity());
        basketService.setRestErrorHandler(errorHandler);
        orderService.setRestErrorHandler(errorHandler);
        listView.setAdapter(adapter);
        swipeContainer.setOnRefreshListener(this);
    }

    @Click(R.id.placeOrderButton)
    void placeOrderClicked() {
        placeOrderAsync();
    }

    @ItemClick
    void listViewItemClicked(ProductCountDTO product) {
        removeFromBasket(product.getProduct().getId());
    }

    @Background
    void placeOrderAsync(){
        orderService.placeOrder();
        SucessDialog.sucesfullReturn(this.getActivity());
    }

    @Background
    void removeFromBasket(Long id) {
        basketService.removeFromBasket(id);
        SucessDialog.sucesfullReturn(this.getActivity());
    }


    @Override
    public void onRefresh() {
        adapter.refresh();
        swipeContainer.setRefreshing(false);
    }
}

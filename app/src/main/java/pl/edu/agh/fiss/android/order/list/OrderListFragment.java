package pl.edu.agh.fiss.android.order.list;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.ListView;
import org.androidannotations.annotations.*;
import pl.edu.agh.fiss.android.R;
import pl.edu.agh.fiss.android.order.details.OrderDetails;
import pl.edu.agh.fiss.android.order.details.OrderDetails_;
import pl.edu.agh.fiss.android.order.list.adapter.OrderListAdapter;
import pl.edu.agh.fiss.android.rest.dto.OrderDTO;

@EFragment(R.layout.fragment_order_list)
public class OrderListFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    public static final String TITLE = "Lista zamówień";

    @ViewById
    ListView listView;

    @ViewById
    SwipeRefreshLayout swipeContainer;

    @Bean
    OrderListAdapter adapter;

    @AfterViews
    void bindAdapter() {
        listView.setAdapter(adapter);
        swipeContainer.setOnRefreshListener(this);
    }

    @ItemClick
    void listViewItemClicked(OrderDTO order) {
        Intent intent = new Intent(getActivity(), OrderDetails_.class);
        intent.putExtra(OrderDetails.DETAIL_KEY,order);
        getActivity().startActivity(intent);
    }

    @Override
    public void onRefresh() {
        adapter.refresh();
        swipeContainer.setRefreshing(false);
    }
}

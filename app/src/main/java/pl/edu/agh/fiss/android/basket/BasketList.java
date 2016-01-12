package pl.edu.agh.fiss.android.basket;



import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.ListView;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;
import pl.edu.agh.fiss.android.R;
import pl.edu.agh.fiss.android.basket.adapter.BasketAdapter;

@EFragment(R.layout.fragment_basket_list)
public class BasketList extends Fragment implements SwipeRefreshLayout.OnRefreshListener {


    public static final String TITLE = "Koszyk";

    @ViewById
    ListView listView;

    @ViewById
    SwipeRefreshLayout swipeContainer;

    @Bean
    BasketAdapter adapter;

    @AfterViews
    void bindAdapter() {

        listView.setAdapter(adapter);
        swipeContainer.setOnRefreshListener(this);
    }


    @Override
    public void onRefresh() {
        adapter.refresh();
        swipeContainer.setRefreshing(false);
    }
}

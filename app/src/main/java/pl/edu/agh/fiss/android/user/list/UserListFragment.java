package pl.edu.agh.fiss.android.user.list;



import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.ListView;
import org.androidannotations.annotations.*;
import org.androidannotations.annotations.rest.RestService;
import pl.edu.agh.fiss.android.R;
import pl.edu.agh.fiss.android.rest.UserService;
import pl.edu.agh.fiss.android.rest.dto.UserDTO;
import pl.edu.agh.fiss.android.rest.handler.ErrorHandler;
import pl.edu.agh.fiss.android.user.details.UserDetailActivity;
import pl.edu.agh.fiss.android.user.details.UserDetailActivity_;
import pl.edu.agh.fiss.android.user.list.adpter.UserListAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
@EFragment(R.layout.fragment_user_list)
public class UserListFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener{

    public static final String TITLE = "Lista użytkowników";

    @ViewById
    ListView listView;

    @ViewById
    SwipeRefreshLayout swipeContainer;

    @Bean
    UserListAdapter adapter;

    @AfterViews
    void bindAdapter() {
        listView.setAdapter(adapter);
        swipeContainer.setOnRefreshListener(this);
    }

    @ItemClick
    void listViewItemClicked(UserDTO user) {
        Intent intent = new Intent(getActivity(), UserDetailActivity_.class);
        intent.putExtra(UserDetailActivity.DETAIL_KEY,user);
        getActivity().startActivity(intent);
    }

    @Override
    public void onRefresh() {
        adapter.refresh();
        swipeContainer.setRefreshing(false);
    }
}

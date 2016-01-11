package pl.edu.agh.fiss.android.product.list;



import android.support.v4.app.Fragment;
import android.widget.ListView;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;
import pl.edu.agh.fiss.android.R;
import pl.edu.agh.fiss.android.product.list.adapter.ProductListAdapter;

@EFragment(R.layout.fragment_product)
public class ProductFragment extends Fragment {

    public static final String TITLE = "Lista Produktów";

    @ViewById
    ListView listView;

    @Bean
    ProductListAdapter adapter;

    @AfterViews
    void bindAdapter() {
        listView.setAdapter(adapter);
    }
}

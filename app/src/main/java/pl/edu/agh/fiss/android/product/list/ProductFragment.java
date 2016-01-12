package pl.edu.agh.fiss.android.product.list;



import android.content.Intent;
import android.support.v4.app.Fragment;
import android.widget.ListView;
import org.androidannotations.annotations.*;
import pl.edu.agh.fiss.android.MainScreen_;
import pl.edu.agh.fiss.android.R;
import pl.edu.agh.fiss.android.product.detail.ProductDetail;
import pl.edu.agh.fiss.android.product.detail.ProductDetail_;
import pl.edu.agh.fiss.android.product.list.adapter.ProductListAdapter;
import pl.edu.agh.fiss.android.rest.dto.ProductDTO;

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

    @ItemClick
    void listViewItemClicked(ProductDTO product) {
        Intent intent = new Intent(getActivity(), ProductDetail_.class);
        intent.putExtra(ProductDetail.DETAIL_KEY,product);
        getActivity().startActivity(intent);
    }
}

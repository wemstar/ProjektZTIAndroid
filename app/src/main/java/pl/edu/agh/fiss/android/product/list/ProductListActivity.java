package pl.edu.agh.fiss.android.product.list;

import android.app.Activity;
import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import org.androidannotations.annotations.*;
import pl.edu.agh.fiss.android.R;
import pl.edu.agh.fiss.android.product.list.adapter.ProductListAdapter;
import pl.edu.agh.fiss.android.rest.dto.ProductDTO;

@EActivity(R.layout.activity_product_list)
public class ProductListActivity extends Activity {

    @ViewById
    ListView listView;

    @Bean
    ProductListAdapter adapter;

    @AfterViews
    void bindAdapter() {
        listView.setAdapter(adapter);
    }



    /*@ItemClick
    void personListItemClicked(ProductDTO product) {
        //makeText(this, person.firstName + " " + person.lastName, LENGTH_SHORT).show();
    }*/
}

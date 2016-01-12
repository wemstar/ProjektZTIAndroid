package pl.edu.agh.fiss.android.basket.item;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;
import pl.edu.agh.fiss.android.R;
import pl.edu.agh.fiss.android.rest.dto.ProductCountDTO;
import pl.edu.agh.fiss.android.rest.dto.ProductDTO;

/**
 * TODO: document your custom view class.
 */
@EViewGroup(R.layout.basket_item_view)
public class BasketItemView extends LinearLayout {

    @ViewById
    TextView nameTextView;

    @ViewById
    TextView descriptionTextView;

    public BasketItemView(Context context) {
        super(context);
    }

    public void bind(ProductCountDTO product) {
        nameTextView.setText(product.getProduct().getName());
        descriptionTextView.setText(product.getCount().toString());
    }
}

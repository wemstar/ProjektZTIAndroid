package pl.edu.agh.fiss.android.order.list.item;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;
import pl.edu.agh.fiss.android.R;
import pl.edu.agh.fiss.android.rest.dto.OrderDTO;

/**
 * TODO: document your custom view class.
 */
@EViewGroup(R.layout.order_item_view)
public class OrderItemView extends LinearLayout {

    @ViewById
    TextView nameTextView;

    @ViewById
    TextView descriptionTextView;

    @ViewById
    TextView productCountTextView;

    public OrderItemView(Context context) {
        super(context);
    }

    public void bind(OrderDTO order) {
        nameTextView.setText(order.getId().toString() + " Id");
        descriptionTextView.setText(order.getState().toString());
        productCountTextView.setText(""+order.getProducts().size()+" Products");
    }

}

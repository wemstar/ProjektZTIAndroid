package pl.edu.agh.fiss.android.product.list.item;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;
import pl.edu.agh.fiss.android.R;
import pl.edu.agh.fiss.android.rest.dto.ProductDTO;


@EViewGroup(R.layout.product_item_view)
public class ProductItemView extends LinearLayout {

    @ViewById
    TextView nameTextView;

    @ViewById
    TextView descriptionTextView;

    public ProductItemView(Context context) {
        super(context);
    }

    public void bind(ProductDTO product) {
        nameTextView.setText(product.getName());
        descriptionTextView.setText(product.getDescription());
    }

}

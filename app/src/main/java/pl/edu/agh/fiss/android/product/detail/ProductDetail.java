package pl.edu.agh.fiss.android.product.detail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import org.androidannotations.annotations.*;
import org.androidannotations.annotations.rest.RestService;
import pl.edu.agh.fiss.android.R;
import pl.edu.agh.fiss.android.rest.BasketService;
import pl.edu.agh.fiss.android.rest.dto.ProductDTO;

@EActivity(R.layout.activity_product_detail)
public class ProductDetail extends AppCompatActivity {

    public static final String DETAIL_KEY = "ProductDTOItem";

    private ProductDTO productDTO;

    @ViewById
    TextView nameLabel;

    @ViewById
    TextView detailLabel;

    @ViewById
    EditText ammountText;

    @ViewById
    Button confirmButton;

    @RestService
    BasketService basketService;

    @AfterViews
    void bindData() {
        productDTO = (ProductDTO) getIntent().getSerializableExtra(DETAIL_KEY);
        nameLabel.setText(productDTO.getName());
        detailLabel.setText(productDTO.getDescription());
    }

    @Click(R.id.confirmButton)
    void confirmClicked(){
        updateBasket();
    }

    @Background
    void updateBasket() {
        basketService.updateBasket(productDTO.getId(),Integer.parseInt(ammountText.getText().toString()));
        closeActivity();
    }

    @UiThread
    void closeActivity() {
        finish();
    }

    @Click(R.id.cancelButton)
    void cancelClicked(){
        closeActivity();
    }

}

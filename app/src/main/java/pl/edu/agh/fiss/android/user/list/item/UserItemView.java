package pl.edu.agh.fiss.android.user.list.item;

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
import org.androidannotations.annotations.EView;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;
import pl.edu.agh.fiss.android.R;
import pl.edu.agh.fiss.android.rest.dto.UserDTO;

/**
 * TODO: document your custom view class.
 */
@EViewGroup(R.layout.user_item_view)
public class UserItemView extends LinearLayout {

    @ViewById
    TextView loginTextView;

    @ViewById
    TextView roleTextView;

    public UserItemView(Context context) {
        super(context);
    }

    public void bind(UserDTO user) {
        loginTextView.setText(user.getLogin());
        roleTextView.setText(user.getRoles().iterator().next());
    }
}

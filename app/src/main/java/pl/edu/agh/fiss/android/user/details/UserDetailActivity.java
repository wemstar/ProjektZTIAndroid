package pl.edu.agh.fiss.android.user.details;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import org.androidannotations.annotations.*;
import org.androidannotations.annotations.rest.RestService;
import pl.edu.agh.fiss.android.R;
import pl.edu.agh.fiss.android.rest.UserService;
import pl.edu.agh.fiss.android.rest.dto.ProductDTO;
import pl.edu.agh.fiss.android.rest.dto.UserDTO;
import pl.edu.agh.fiss.android.rest.handler.ErrorHandler;
import pl.edu.agh.fiss.android.utils.SucessDialog;

@EActivity(R.layout.activity_user_detail)
public class UserDetailActivity extends AppCompatActivity {

    public static final String DETAIL_KEY = "USER_DTO_ACTIVITY";
    private Boolean updateState;

    @ViewById
    EditText loginEditText;

    @ViewById
    EditText passwordEditText;

    @ViewById
    EditText emailEditText;

    @ViewById
    EditText cityEditText;

    @ViewById
    EditText streetEditText;

    @ViewById
    Button ubdateButton;

    @RestService
    UserService userService;

    @Bean
    ErrorHandler errorHandler;

    @Click(R.id.ubdateButton)
    void updateUserClick() {
        updateUser();
    }

    UserDTO user = new UserDTO();

    @AfterViews
    void bindToModel() {
        errorHandler.setActivity(this);
        userService.setRestErrorHandler(errorHandler);
        UserDTO user = (UserDTO) getIntent().getSerializableExtra(DETAIL_KEY);
        updateState = user != null;
        ubdateButton.setText( updateState ? "Update": "Create");
        if(updateState) {
            this.user = user;
            loginEditText.setText(user.getLogin());
            passwordEditText.setText(user.getPassword());
            emailEditText.setText(user.getEmail());
            cityEditText.setText(user.getCity());
            streetEditText.setText(user.getStreet());
        }
    }

    @Background
    void updateUser() {
        user.setLogin(loginEditText.getText().toString());
        user.setPassword(passwordEditText.getText().toString());
        user.setEmail(emailEditText.getText().toString());
        user.setCity(cityEditText.getText().toString());
        user.setStreet(streetEditText.getText().toString());
        if(updateState)
            userService.update(user);
        else
            userService.createUser(user);
        SucessDialog.sucesfullReturn(this);
    }

}

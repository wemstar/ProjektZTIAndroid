package pl.edu.agh.fiss.android;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.MenuItem;
import android.widget.EditText;
import org.androidannotations.annotations.*;
import org.androidannotations.annotations.rest.RestService;
import pl.edu.agh.fiss.android.product.list.ProductListActivity_;
import pl.edu.agh.fiss.android.rest.LoginClient;
import pl.edu.agh.fiss.android.rest.ProductService;
import pl.edu.agh.fiss.android.rest.dto.TokenResponse;
import pl.edu.agh.fiss.android.utils.TokenContext;

@EActivity(R.layout.activity_main)
@OptionsMenu(R.menu.menu_main)
public class MainActivity extends Activity {


    @OptionsMenuItem
    MenuItem action_settings;

    @ViewById
    EditText loginText;

    @ViewById
    EditText passwordText;

    @RestService
    LoginClient loginService;

    @RestService
    ProductService productService;

    @Bean
    TokenContext tokenContext;

    @OptionsItem(R.id.action_settings)
    void myMethod() {
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("Alert");
        alertDialog.setMessage("Alert message to be shown");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    @Click(R.id.loginButton)
    void loginClicked() {
        loginAsync(loginText.getText().toString(),passwordText.getText().toString());
    }

    @Background
    void loginAsync(String login, String password) {
        loginService.setHeader("X-Auth-Username", "user");
        loginService.setHeader("X-Auth-Password", "user");
        TokenResponse resp = loginService.login();
        tokenContext.token = resp.token;
        startNextActivity();
    }

    void startNextActivity() {
        Intent intent = new Intent(this, ProductListActivity_.class);
        startActivity(intent);
    }



}
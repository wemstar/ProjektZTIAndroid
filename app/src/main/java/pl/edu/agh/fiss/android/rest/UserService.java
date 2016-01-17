package pl.edu.agh.fiss.android.rest;

import org.androidannotations.annotations.rest.Delete;
import org.androidannotations.annotations.rest.Post;
import org.androidannotations.annotations.rest.Put;
import org.androidannotations.annotations.rest.Rest;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import pl.edu.agh.fiss.android.rest.dto.UserDTO;
import pl.edu.agh.fiss.android.rest.interceptor.AuthenticateInterceptor;
import pl.edu.agh.fiss.android.utils.StringConstant;

/**
 * Created by wemstar on 2016-01-16.
 */
@Rest(rootUrl = StringConstant.SERVER_ADRES, converters = { MappingJackson2HttpMessageConverter.class,FormHttpMessageConverter.class },interceptors = { AuthenticateInterceptor.class })
public interface UserService {

    @Put("/user")
    UserDTO createUser(UserDTO user);

    @Post("/user")
    UserDTO update(UserDTO user);

    @Delete("/user")
    void deleteUser(String login);

}

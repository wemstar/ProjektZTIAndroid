package pl.edu.agh.fiss.android.rest;

import org.androidannotations.annotations.rest.*;
import org.androidannotations.api.rest.RestClientErrorHandling;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import pl.edu.agh.fiss.android.rest.dto.UserDTO;
import pl.edu.agh.fiss.android.rest.interceptor.AuthenticateInterceptor;
import pl.edu.agh.fiss.android.utils.StringConstant;

/**
 * Created by wemstar on 2016-01-16.
 */
@Rest(rootUrl = StringConstant.SERVER_ADRES, converters = { MappingJackson2HttpMessageConverter.class,FormHttpMessageConverter.class },interceptors = { AuthenticateInterceptor.class })
public interface UserService extends RestClientErrorHandling {

    @Get("/user")
    @RequiresHeader(value = {StringConstant.TOKEN_HEADER})
    UserDTO getUser();

    @Put("/user")
    @RequiresHeader(value = {StringConstant.TOKEN_HEADER})
    UserDTO createUser(UserDTO user);

    @Post("/user")
    @RequiresHeader(value = {StringConstant.TOKEN_HEADER})
    UserDTO update(UserDTO user);

    @Delete("/user")
    @RequiresHeader(value = {StringConstant.TOKEN_HEADER})
    void deleteUser(String login);

}

package pl.edu.agh.fiss.android.rest;



import org.androidannotations.annotations.rest.Post;
import org.androidannotations.annotations.rest.RequiresHeader;
import org.androidannotations.annotations.rest.Rest;
import org.androidannotations.api.rest.RestClientHeaders;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import pl.edu.agh.fiss.android.rest.dto.TokenResponse;

/**
 * Created by wemstar on 2016-01-03.
 */
@Rest(rootUrl = "http://192.168.0.13:8080/rest", converters = { MappingJackson2HttpMessageConverter.class,FormHttpMessageConverter.class })
public interface LoginClient extends RestClientHeaders {

    @Post("/authenticate")
    @RequiresHeader(value = {"X-Auth-Password","X-Auth-Username"})
    TokenResponse login();

}

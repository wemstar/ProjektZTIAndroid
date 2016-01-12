package pl.edu.agh.fiss.android.rest;

import org.androidannotations.annotations.rest.Get;
import org.androidannotations.annotations.rest.Post;
import org.androidannotations.annotations.rest.RequiresHeader;
import org.androidannotations.annotations.rest.Rest;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import pl.edu.agh.fiss.android.rest.dto.BasketDTO;
import pl.edu.agh.fiss.android.rest.interceptor.AuthenticateInterceptor;
import pl.edu.agh.fiss.android.utils.StringConstant;


/**
 * Created by wemstar on 2016-01-12.
 */
@Rest(rootUrl = StringConstant.SERVER_ADRES, converters = { MappingJackson2HttpMessageConverter.class,FormHttpMessageConverter.class },interceptors = { AuthenticateInterceptor.class })
public interface BasketService {

    @Get("/basket")
    @RequiresHeader(value = {StringConstant.TOKEN_HEADER})
    BasketDTO getBasket();

    @Post("/basket/{productId}/{amount}")
    @RequiresHeader(value = {StringConstant.TOKEN_HEADER})
    void updateBasket(Long productId,Integer amount);
}

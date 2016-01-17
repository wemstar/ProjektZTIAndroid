package pl.edu.agh.fiss.android.rest;

import org.androidannotations.annotations.rest.*;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import pl.edu.agh.fiss.android.rest.dto.OrderDTO;
import pl.edu.agh.fiss.android.rest.interceptor.AuthenticateInterceptor;
import pl.edu.agh.fiss.android.utils.StringConstant;

import java.util.List;

/**
 * Created by wemstar on 2016-01-16.
 */
@Rest(rootUrl = StringConstant.SERVER_ADRES, converters = { MappingJackson2HttpMessageConverter.class,FormHttpMessageConverter.class },interceptors = { AuthenticateInterceptor.class })
public interface OrderService {
    @Put("/order")
    @RequiresHeader(value = {StringConstant.TOKEN_HEADER})
    OrderDTO placeOrder();

    @Get("/order")
    @RequiresHeader(value = {StringConstant.TOKEN_HEADER})
    List<OrderDTO> getAllOrder();

    @Get("/order/{orderId}")
    @RequiresHeader(value = {StringConstant.TOKEN_HEADER})
    OrderDTO getOrder(Long orderId);

    @Delete("/order/{orderId}")
    @RequiresHeader(value = {StringConstant.TOKEN_HEADER})
    void cancelOrder(Long orderId);


}

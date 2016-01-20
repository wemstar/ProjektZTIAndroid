package pl.edu.agh.fiss.android.rest;

import org.androidannotations.annotations.rest.Get;
import org.androidannotations.annotations.rest.Post;
import org.androidannotations.annotations.rest.RequiresHeader;
import org.androidannotations.annotations.rest.Rest;
import org.androidannotations.api.rest.RestClientErrorHandling;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import pl.edu.agh.fiss.android.rest.dto.OrderDTO;
import pl.edu.agh.fiss.android.rest.interceptor.AuthenticateInterceptor;
import pl.edu.agh.fiss.android.utils.StringConstant;

import java.util.List;

/**
 * Created by wemstar on 2016-01-18.
 */

@Rest(rootUrl = StringConstant.SERVER_ADRES, converters = { MappingJackson2HttpMessageConverter.class,FormHttpMessageConverter.class },interceptors = { AuthenticateInterceptor.class })
public interface OrderAdminService extends RestClientErrorHandling {

    @Get("/admin/order")
    @RequiresHeader(value = {StringConstant.TOKEN_HEADER})
    List<OrderDTO> getAllOrder();

    @Get("/admin/order/{id}")
    @RequiresHeader(value = {StringConstant.TOKEN_HEADER})
    OrderDTO getOrder(Long id);

    @Post("/admin/order")
    @RequiresHeader(value = {StringConstant.TOKEN_HEADER})
    void updateOrder(OrderDTO order);
}

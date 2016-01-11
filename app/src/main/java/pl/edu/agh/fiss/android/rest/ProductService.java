package pl.edu.agh.fiss.android.rest;

import org.androidannotations.annotations.rest.Get;
import org.androidannotations.annotations.rest.Post;
import org.androidannotations.annotations.rest.RequiresHeader;
import org.androidannotations.annotations.rest.Rest;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import pl.edu.agh.fiss.android.rest.dto.ProductDTO;
import pl.edu.agh.fiss.android.rest.interceptor.AuthenticateInterceptor;
import pl.edu.agh.fiss.android.utils.StringConstant;

import java.util.List;

/**
 * Created by wemstar on 2016-01-04.
 */
@Rest(rootUrl = StringConstant.SERVER_ADRES, converters = { MappingJackson2HttpMessageConverter.class,FormHttpMessageConverter.class },interceptors = { AuthenticateInterceptor.class })
public interface ProductService {

    @Get("/product/all")
    @RequiresHeader(value = {StringConstant.TOKEN_HEADER})
    List<ProductDTO> getAllProducts();
}

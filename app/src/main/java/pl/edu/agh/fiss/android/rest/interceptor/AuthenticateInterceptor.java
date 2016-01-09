package pl.edu.agh.fiss.android.rest.interceptor;

import android.content.Context;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import pl.edu.agh.fiss.android.utils.TokenContext;

import java.io.IOException;

/**
 * Created by wemstar on 2016-01-04.
 */
@EBean
public class AuthenticateInterceptor implements ClientHttpRequestInterceptor {

    @Bean
    TokenContext tokenContext;

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] data, ClientHttpRequestExecution execution) throws IOException {
        request.getHeaders().set("X-Auth-Token",tokenContext.token);
        return execution.execute(request, data);
    }
}

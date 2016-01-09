package pl.edu.agh.fiss.android.utils;

import org.androidannotations.annotations.EBean;

/**
 * Created by wemstar on 2016-01-04.
 */
@EBean(scope = EBean.Scope.Singleton)
public class TokenContext {
    public String token;
}

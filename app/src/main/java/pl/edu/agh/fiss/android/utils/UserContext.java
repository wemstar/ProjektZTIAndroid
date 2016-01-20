package pl.edu.agh.fiss.android.utils;

import org.androidannotations.annotations.EBean;
import pl.edu.agh.fiss.android.rest.dto.UserDTO;

/**
 * Created by wemstar on 2016-01-18.
 */
@EBean(scope = EBean.Scope.Singleton)
public class UserContext {

    private UserDTO userDTO;

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public boolean isAdmin() {
        return userDTO.getRoles().contains(StringConstant.ROLE_ADMIN_USER);
    }
}

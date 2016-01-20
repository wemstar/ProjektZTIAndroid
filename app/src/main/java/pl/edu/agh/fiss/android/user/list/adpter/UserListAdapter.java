package pl.edu.agh.fiss.android.user.list.adpter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import org.androidannotations.annotations.*;
import org.androidannotations.annotations.rest.RestService;
import pl.edu.agh.fiss.android.rest.UserAdminService;
import pl.edu.agh.fiss.android.rest.dto.UserDTO;
import pl.edu.agh.fiss.android.rest.handler.ErrorHandler;
import pl.edu.agh.fiss.android.user.list.item.UserItemView;
import pl.edu.agh.fiss.android.user.list.item.UserItemView_;

import java.util.List;

/**
 * Created by wemstar on 2016-01-18.
 */
@EBean
public class UserListAdapter extends BaseAdapter {

    List<UserDTO> users;

    @RestService
     UserAdminService userService;

    @RootContext
    Context context;

    @Bean
    ErrorHandler errorHandler;

    @AfterInject
    void initAdapter() {
        // TODO
        userService.setRestErrorHandler(errorHandler);
        loadData();

    }

    @Background
    void loadData() {
        users = userService.getAllUsers();
        reloadList();
    }

    public void refresh() {
        loadData();
    }

    @UiThread
    void reloadList() {
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        UserItemView userItemView;
        if (convertView == null) {
            userItemView = UserItemView_.build(context);
        } else {
            userItemView = (UserItemView) convertView;
        }

        userItemView.bind(getItem(position));

        return userItemView;
    }

    @Override
    public int getCount() {
        if (users != null) {
            return users.size();
        }
        return 0;
    }

    @Override
    public UserDTO getItem(int position) {
        return users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}

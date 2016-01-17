package pl.edu.agh.fiss.android;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import org.androidannotations.annotations.*;
import org.androidannotations.annotations.rest.RestService;
import pl.edu.agh.fiss.android.basket.BasketList;
import pl.edu.agh.fiss.android.basket.BasketList_;
import pl.edu.agh.fiss.android.order.list.OrderListFragment;
import pl.edu.agh.fiss.android.order.list.OrderListFragment_;
import pl.edu.agh.fiss.android.product.detail.ProductDetail;
import pl.edu.agh.fiss.android.product.detail.ProductDetail_;
import pl.edu.agh.fiss.android.product.list.ProductFragment;
import pl.edu.agh.fiss.android.product.list.ProductFragment_;
import pl.edu.agh.fiss.android.rest.UserService;
import pl.edu.agh.fiss.android.rest.dto.UserDTO;
import pl.edu.agh.fiss.android.user.details.UserDetailActivity;
import pl.edu.agh.fiss.android.user.details.UserDetailActivity_;

import java.util.ArrayList;
import java.util.List;

@EActivity(R.layout.activity_main_screen)
@OptionsMenu(R.menu.menu_main_screen)
public class MainScreen extends AppCompatActivity {

    @ViewById
    Toolbar toolbar;

    @ViewById
    TabLayout tabs;

    @ViewById
    ViewPager viewPager;

    @RestService
    UserService userService;

    private UserDTO cureentUser;

    @AfterViews
    public void setupViewPager() {
        setSupportActionBar(toolbar);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ProductFragment_().builder().build(), ProductFragment.TITLE);
        adapter.addFragment(new BasketList_().builder().build(), BasketList.TITLE);
        adapter.addFragment(new OrderListFragment_().builder().build(), OrderListFragment.TITLE);
        viewPager.setAdapter(adapter);
        tabs.setupWithViewPager(viewPager);
        downloadUser();
    }

    @OptionsItem(R.id.action_user)
    void actionUserClicked() {
        Intent intent = new Intent(this, UserDetailActivity_.class);
        intent.putExtra(UserDetailActivity.DETAIL_KEY,cureentUser);
        startActivity(intent);
    }

    @Background
    void downloadUser() {
        cureentUser = userService.getUser();
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<Fragment>();
        private final List<String> mFragmentTitleList = new ArrayList<String>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}

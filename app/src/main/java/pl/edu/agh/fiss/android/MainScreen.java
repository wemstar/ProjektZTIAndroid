package pl.edu.agh.fiss.android;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import pl.edu.agh.fiss.android.basket.BasketList;
import pl.edu.agh.fiss.android.basket.BasketList_;
import pl.edu.agh.fiss.android.product.list.ProductFragment;
import pl.edu.agh.fiss.android.product.list.ProductFragment_;

import java.util.ArrayList;
import java.util.List;

@EActivity(R.layout.activity_main_screen)
public class MainScreen extends AppCompatActivity {

    @ViewById
    Toolbar toolbar;

    @ViewById
    TabLayout tabs;

    @ViewById
    ViewPager viewPager;

    @AfterViews
    public void setupViewPager() {
        setSupportActionBar(toolbar);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ProductFragment_().builder().build(), ProductFragment.TITLE);
        adapter.addFragment(new BasketList_().builder().build(), BasketList.TITLE);
        viewPager.setAdapter(adapter);
        tabs.setupWithViewPager(viewPager);
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

package com.example.tab_layout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


import com.example.tab_layout.Fragments.ItemListFragment;
import com.example.tab_layout.Fragments.DeletedItemListFragment;
import com.example.tab_layout.Fragments.ProfileFragment;

public class ViewPagerMessengerAdapter extends FragmentPagerAdapter {


    public ViewPagerMessengerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        if(position == 0){
            return new ItemListFragment();
        }
        else if(position == 1){
            return new DeletedItemListFragment();
        }
        else {
            return new ProfileFragment();
        }
    }

    @Override
    public int getCount() {
        return 3; // no of tabs (mainly number of fragments)
    }

    //
    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0) {
            return "Lists";
        } else  if(position == 1){
            return "Deleted List";
        }
        else{
            return "Profile";
        }

    }
}

package com.example.csiemessagingappv1;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/// This is an adaptor for switching between the two fragments

class AdapterPagerSections extends FragmentPagerAdapter {

    public AdapterPagerSections(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position)
        {
            case 0: FragmentFriends fragmentFriends = new FragmentFriends();
                return fragmentFriends;

            case 1: FragmentMessages fragmentMessages = new FragmentMessages();
                return fragmentMessages;

            //case 2: --- If further fragments are added


            default:
                return null;
        }
    }

    public CharSequence getPageTitle(int position) {
        ///We set the title of the tabs here
        switch(position)
        {
            case 0: return "FRIENDS";
            case 1: return "MESSAGES";
            //case 2: return "FRIEND REQUESTS"; --if we wanted to add one more, for example
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return 2; //because we have 2 tabs only
    }
}


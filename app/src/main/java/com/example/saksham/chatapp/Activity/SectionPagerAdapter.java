package com.example.saksham.chatapp.Activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

class SectionPagerAdapter extends FragmentPagerAdapter{

    public SectionPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch(position){
            case 0:
                com.example.saksham.chatapp.Fragments.RequestsFragments requestsFragments = new com.example.saksham.chatapp.Fragments.RequestsFragments();
                return requestsFragments;

            case 1:
                com.example.saksham.chatapp.Fragments.ChatsFragment chatsFragment = new com.example.saksham.chatapp.Fragments.ChatsFragment();
                return chatsFragment;

            case 2:
                com.example.saksham.chatapp.Fragments.FriendsFragment friendsFragment = new com.example.saksham.chatapp.Fragments.FriendsFragment();
                return friendsFragment;

            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return 3;
    }
    public CharSequence getPageTitle(int position){

        switch (position){
            case 0:
                return "REQUESTS";

            case 1:
                return "CHATS";

            case 2:
                return "FRIENDS";

            default:
                return null;
        }

    }

}

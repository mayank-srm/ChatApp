package com.example.chatapp.Activity;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

class SectionPagerAdapter extends FragmentPagerAdapter {

    public SectionPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch(position){
            case 0:
                com.example.chatapp.Fragments.RequestsFragments requestsFragments = new com.example.chatapp.Fragments.RequestsFragments();
                return requestsFragments;

            case 1:
                com.example.chatapp.Fragments.ChatsFragment chatsFragment = new com.example.chatapp.Fragments.ChatsFragment();
                return chatsFragment;

            case 2:
                com.example.chatapp.Fragments.FriendsFragment friendsFragment = new com.example.chatapp.Fragments.FriendsFragment();
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

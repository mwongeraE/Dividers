package com.example.mwongera.dividers;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class SampleFragmentPagerAdapter extends FragmentPagerAdapter {

    private final Context context;

    private final FragmentPage[] pages = {
            new FragmentPage(new SampleGridFragment(), R.string.movies_title),
            new FragmentPage(new SampleListFragment(), R.string.books_title),
    };

    public SampleFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override public android.support.v4.app.Fragment getItem(int position) {
        return pages[position].getFragment();
    }

    @Override public CharSequence getPageTitle(int position) {
        return context.getString(pages[position].getNameId());
    }

    @Override public int getCount() {
        return pages.length;
    }

    private class FragmentPage {
        private final Fragment fragment;
        private final int nameId;

        public FragmentPage(Fragment fragment, int nameId) {
            this.fragment = fragment;
            this.nameId = nameId;
        }

        public Fragment getFragment() {
            return fragment;
        }

        public int getNameId() {
            return nameId;
        }
    }

}
package com.spindriftgroup.martinmcl.sdweartestdev;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.support.wearable.view.CardFragment;
import android.support.wearable.view.FragmentGridPagerAdapter;
import android.support.wearable.view.ImageReference;

import java.util.ArrayList;

public class SimpleGridPagerAdapter extends FragmentGridPagerAdapter {

    private final Context mContext;
    private ArrayList<SimpleRow> mPages;

    public SimpleGridPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
        initPages();
    }

    private void initPages() {
        mPages = new ArrayList<SimpleRow>();

        SimpleRow row1 = new SimpleRow();
        row1.addPages(new SimplePage("Product Available", "Swipe right to dismiss, up to read more", R.drawable.ic_simple_alert,  R.drawable.ic_launcher));

        SimpleRow row2 = new SimpleRow();
        row2.addPages(new SimplePage("Macbook Air", "Swipe up to choose delivery address, right to dismiss", R.drawable.ic_locate,  R.drawable.ic_launcher));

        SimpleRow row3 = new SimpleRow();
        row3.addPages(new SimplePage("Deliver to:", "Swipe left to select address, right to dismiss", R.drawable.ic_locate,  R.drawable.ic_launcher));
        row3.addPages(new SimplePage("Home", "Swipe up to use this address, left to select alternative", R.drawable.ic_locate,  R.drawable.ic_launcher));
        row3.addPages(new SimplePage("Work", "Swipe up to use this address, right to select previous", R.drawable.ic_locate,  R.drawable.ic_launcher));

        SimpleRow row4 = new SimpleRow();
        row4.addPages(new SimplePage("Delivery Date", "Swipe left to choose date, right to dismiss", R.drawable.ic_date_del,  R.drawable.ic_launcher));
        row4.addPages(new SimplePage("Today", "Swipe up to confirm, left for next available date", R.drawable.ic_date_del,  R.drawable.ic_launcher));
        row4.addPages(new SimplePage("Tomorrow", "Swipe up to confirm, left for previous available date", R.drawable.ic_date_del,  R.drawable.ic_launcher));

        SimpleRow row5 = new SimpleRow();
        row5.addPages(new SimplePage("Payment Method", "Swipe left to select, right to dismiss", R.drawable.ic_pay_check,  R.drawable.ic_launcher));
        row5.addPages(new SimplePage("Registered Card", "Card ending 6619 - Swipe up to confirm", R.drawable.ic_pay_check,  R.drawable.ic_launcher));

        SimpleRow row6 = new SimpleRow();
        row6.addPages(new SimplePage("Confirm Order", "Swipe up to place order, right to cancel and dismiss", R.drawable.ic_query,  R.drawable.ic_launcher));

        SimpleRow row7 = new SimpleRow();
        row7.addPages(new SimplePage("Order placed", "Order confirmation has been emailed to you. Swipe right to close", R.drawable.ic_confirm_thumb,  R.drawable.ic_launcher));

        mPages.add(row1);
        mPages.add(row2);
        mPages.add(row3);
        mPages.add(row4);
        mPages.add(row5);
        mPages.add(row6);
        mPages.add(row7);
    }

    @Override
    public Fragment getFragment(int row, int col) {
        SimplePage page = ((SimpleRow)mPages.get(row)).getPages(col);
        CardFragment fragment = CardFragment.create(page.mTitle, page.mText, page.mIconId);
        return fragment;
    }

    @Override
    public ImageReference getBackground(int row, int col) {
        SimplePage page = ((SimpleRow)mPages.get(row)).getPages(col);
        return ImageReference.forDrawable(page.mBackgroundId);
    }

    @Override
    public int getRowCount() {
        return mPages.size();
    }

    @Override
    public int getColumnCount(int row) {
        return mPages.get(row).size();
    }
}

package com.hly.fragment;

import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private HpFragment hpFragment;
    private SellerFragment sellerFragment;
    private BookFragment bookFragment;
    private MineFragment mineFragment;

    private TextView  hptext;
    private TextView  sellertext;
    private TextView  booktext;
    private TextView  minetext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hptext = findViewById(R.id.hp_fragment);
        sellertext = findViewById(R.id.seller_fragment);
        booktext = findViewById(R.id.book_fragment);
        minetext = findViewById(R.id.mine_fragment);

        hptext.setOnClickListener(this);
        sellertext.setOnClickListener(this);
        booktext.setOnClickListener(this);
        minetext.setOnClickListener(this);

        setTabSelection(0);//第一次启动默认的tab(0)

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.hp_fragment:
                setTabSelection(0);
                break;

            case R.id.seller_fragment:
                setTabSelection(1);
                break;

            case R.id.book_fragment:
                setTabSelection(2);
                break;

            case R.id.mine_fragment:
                setTabSelection(3);
                break;
        }

    }

    private void setTabSelection(int index) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        clearSelection();
        hideFragments(transaction);
        switch (index){
            case 0 :
            hptext.setTextColor(Color.parseColor("#293754"));
             if (hpFragment == null){
                 hpFragment = new HpFragment();
                 transaction.add(R.id.content,hpFragment);
             }else{
               transaction.show(hpFragment);
             }
             break;

            case 1 :
                hptext.setTextColor(Color.parseColor("#293754"));
                if (sellerFragment == null){
                    sellerFragment = new SellerFragment();
                    transaction.add(R.id.content,sellerFragment);
                }else{
                    transaction.show(sellerFragment);
                }
                break;

            case 2 :
                hptext.setTextColor(Color.parseColor("#293754"));
                if (bookFragment == null){
                    bookFragment = new BookFragment();
                    transaction.add(R.id.content,bookFragment);
                }else{
                   transaction.show(bookFragment);
                }
                break;

            case 3 :
                hptext.setTextColor(Color.parseColor("#293754"));
                if (mineFragment == null){
                    mineFragment = new MineFragment();
                    transaction.add(R.id.content,mineFragment);
                }else{
                    transaction.show(mineFragment);
                }
                break;
        }

        transaction.commitAllowingStateLoss();

    }

    /**
     * 清除所有选中的状态
     */
    private void clearSelection() {

        hptext.setTextColor(Color.parseColor("#82858b"));

        sellertext.setTextColor(Color.parseColor("#82858b"));

        booktext.setTextColor(Color.parseColor("#82858b"));

        minetext.setTextColor(Color.parseColor("#82858b"));

    }

    /**
     * 将所有的Fragment设置隐藏状态,用于对Fragment执行操作的事务
     *
     * @param transaction
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (hpFragment != null) {
            transaction.hide(hpFragment);
        }
        if (sellerFragment != null) {
            transaction.hide(sellerFragment);
        }

        if (bookFragment != null) {
            transaction.hide(bookFragment);
        }
        if (mineFragment != null) {
            transaction.hide(mineFragment);
        }
    }


}

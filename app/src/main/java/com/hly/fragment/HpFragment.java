package com.hly.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * ~~~~~~文件描述:~~~~~~
 * ~~~~~~作者:huleiyang~~~~~~
 * ~~~~~~创建时间:2019/4/2~~~~~~
 * ~~~~~~更改时间:2019/4/2~~~~~~
 * ~~~~~~版本号:2.0~~~~~~
 */
public class HpFragment extends Fragment{

    private GirlFragment girlFragment;
    private BoyFragment boyFragment;

    private TextView classify_girl;
    private TextView classify_boy;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.hp_fragment_layout, container, false);

        classify_girl =view.findViewById(R.id.classify_girl);
        classify_boy = view.findViewById(R.id.classify_boy);

        classify_girl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTabSelection(0);
            }
        });

        classify_boy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTabSelection(1);
            }
        });

        setTabSelection(0);//第一次启动默认的tab(0)
        return view;
    }



    private void setTabSelection(int index){
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        clearSelection();
        hideFragments(transaction);
        switch (index){
            case 0 :
                classify_girl.setTextColor(Color.parseColor("#293754"));
                if (girlFragment == null){
                    girlFragment = new GirlFragment();
                    transaction.add(R.id.classify_content,girlFragment);
                }else{
                    transaction.show(girlFragment);
                }
                break;

            case 1 :
                classify_boy.setTextColor(Color.parseColor("#293754"));
                if (boyFragment == null){
                    boyFragment = new BoyFragment();
                    transaction.add(R.id.classify_content,boyFragment);
                }else{
                    transaction.show(boyFragment);
                }
                break;


        }
        transaction.commitAllowingStateLoss();
    }

    private void hideFragments(FragmentTransaction transaction) {
        if (girlFragment != null){
            transaction.hide(girlFragment);
        }
        if (boyFragment !=null){
            transaction.hide(boyFragment);
        }
    }

    private void clearSelection() {
      classify_girl.setTextColor(Color.parseColor("#82858b"));
      classify_boy.setTextColor(Color.parseColor("#82858b"));
    }


}

package com.mariammuhammad.chips;

import android.os.Bundle;

import android.os.Bundle;
import android.security.keystore.WrappedKeyEntry;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MobileAdapter adapter;
    List<MobileModel> mobileList,samsungList,oppoList,appleList;
    ChipGroup chipGroup;
    Chip samsung, oppo, apple;
    MobileAdapter.OnMobileClickListener listener;

    TextView textIcon;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        chipGroup = findViewById(R.id.chipGroup);
        //textIcon=findViewById(R.id.txtIcon);
        samsung = findViewById(R.id.chipSamsung);
        oppo = findViewById(R.id.chipOppo);
        apple = findViewById(R.id.chipApple);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mobileList = new ArrayList<>();
        mobileList.add(new MobileModel( "Oppo Mobile 1", "Small description","O"));
        mobileList.add(new MobileModel( "Oppo Mobile 2", "New version","O"));
        mobileList.add(new MobileModel( "Samsung Galaxy", "Latest model","S"));
        mobileList.add(new MobileModel( "Samsung A54", "Elegant model","S"));
        mobileList.add(new MobileModel( "iPhone 13", "Premium device","A"));
        mobileList.add(new MobileModel("iPhone 16", "Expensiive","A"));


        samsungList = new ArrayList<>();
        samsungList.add(new MobileModel( "Samsung Galaxy", "Latest model","S"));
        samsungList.add(new MobileModel( "Samsung A54", "Elegant model","S"));

        oppoList = new ArrayList<>();
        oppoList.add(new MobileModel( "Oppo Mobile 1", "Small description","O"));
        oppoList.add(new MobileModel( "Oppo Mobile 2", "New version","O"));
        appleList = new ArrayList<>();
        appleList.add(new MobileModel( "iPhone 13", "Premium device","A"));
        appleList.add(new MobileModel("iPhone 16", "Expensiive","A"));


        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(layoutManager);
        MobileAdapter mobileAdapter = new MobileAdapter(mobileList, listener);
        recyclerView.setAdapter(mobileAdapter);

        samsung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mobileAdapter.setMobileList(samsungList);
                mobileAdapter.notifyDataSetChanged();
            }
        });

        oppo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mobileAdapter.setMobileList(oppoList);
                mobileAdapter.notifyDataSetChanged();
            }
        });

        apple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mobileAdapter.setMobileList(appleList);
                mobileAdapter.notifyDataSetChanged();
            }
        });

//        adapter = new MobileAdapter(mobileList, new MobileAdapter.OnMobileClickListener() {
//            @Override
//            public void onMobileClick(MobileModel mobileModel) {
//                String brand = getBrandFromMobileTitle(mobileModel.getTitle());
//                if (brand != null) {
//                    moveChipToFirstPosition(brand);
//                } else {
//                    Toast.makeText(MainActivity.this, "Brand not found!", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//
//        recyclerView.setAdapter(adapter);
//    }


//    private String getBrandFromMobileTitle(String title) {
//        if (title.toLowerCase().contains("oppo")) return "Oppo";
//        if (title.toLowerCase().contains("samsung")) return "Samsung";
//        if (title.toLowerCase().contains("iphone") || title.toLowerCase().contains("apple"))
//            return "Apple";
//        return null;
//    }

//    private void moveChipToFirstPosition(String brand) {
//        for (int i = 0; i < chipGroup.getChildCount(); i++) {
//            View child = chipGroup.getChildAt(i);
//            if (child instanceof Chip) {
//                Chip chip = (Chip) child;
//                if (brand.equalsIgnoreCase(chip.getText().toString())) {
//                    chipGroup.removeView(chip);
//                    chipGroup.addView(chip, 0);
//                    break;
//                }
//            }
//        }
//    }
    }
}




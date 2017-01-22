package com.vigilinc.wishlist_v_0_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
    }
    public void goBack(View v){
        Intent intent = new Intent(this, IndexActivity.class);
        startActivity(intent);
    }
}

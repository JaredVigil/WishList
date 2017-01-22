package com.vigilinc.wishlist_v_0_1;


import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;


public class IndexActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.vigilinc.wishlist_v_0_1.MESSAGE";
    int numList = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indexr);
    }

    public void goFirendsList(View v){
        Intent intent = new Intent(this, friendsActivity.class);
        String message = "Friends";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void goUpdateList(View v){
        Intent intent = new Intent(this, UpdateActivity.class);
        String message = "Updates";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
    public void goSetting(View v){
        Intent intent = new Intent(this, settingsActivity.class);
        String message = "Settings";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
    public void  goList(View v){
        Intent intent = new Intent(this, ListActivity.class);
        String message = "Settings";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
    /**/
    public void addList(View v){
        TableLayout listTable = (TableLayout) findViewById(R.id.list_table);
        LinearLayout layout = (LinearLayout) findViewById(R.id.mid_layout);
        TableRow newRow = new TableRow(this);
        LinearLayout col = new LinearLayout(this);
        col.setOrientation(LinearLayout.HORIZONTAL);
        newRow.addView(col);
        TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
        newRow.setLayoutParams(lp);
        col.setWeightSum(3);
        Button newList = new Button(this);
        Button edit = new Button(this);
        Button del = new Button(this);
        RelativeLayout.LayoutParams rel_list = new RelativeLayout.LayoutParams(550, 150);
        RelativeLayout.LayoutParams rel_bottone = new RelativeLayout.LayoutParams(150, 150);
        newList.setLayoutParams(rel_list);
        edit.setLayoutParams(rel_bottone);
        del.setLayoutParams(rel_bottone);
        String listS = "List: " + numList;
        numList++;
        del.setOnClickListener(DeleatList(newRow));
        newList.setOnClickListener(goListListener(v));
        edit.setOnClickListener(EditListListener(newList, newList));
        newList.setText(listS);
        edit.setText("E");
        del.setText("D");
        col.addView(newList);
        col.addView(edit);
        col.addView(del);
        layout.getLayoutParams().height += 100;
        listTable.addView(newRow,0);
    }

    View.OnClickListener DeleatList(final View v)  {
        return new View.OnClickListener() {
                public void onClick(View v) {
                    AlertDialog diaBox = deletAlert(v);
                    diaBox.show();
                }

        };
    }

    View.OnClickListener goListListener(final View v)  {
        return new View.OnClickListener() {
            public void onClick(View v) {
                goList(v);
            }
        };
    }


    View.OnClickListener EditListListener(final View v, final Button list)  {
        return new View.OnClickListener() {
            public void onClick(View v) {
                editList(v,list);
            }
        };
    }

    public void editList(View v, Button list){

    }
    private AlertDialog deletAlert(final View v) {
        AlertDialog myQuittingDialogBox =new AlertDialog.Builder(this)
                //set message, title, and icon
                .setTitle("Delete")
                .setMessage("Are you sure you want to delete this List? All information on this list will be lost.")
                .setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        //your deleting code
                        LinearLayout layout = (LinearLayout) findViewById(R.id.mid_layout);
                        ((ViewGroup) v.getParent()).removeAllViews();
                        layout.getLayoutParams().height -= 100;
                        numList--;
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create();
        return myQuittingDialogBox;
    }

}

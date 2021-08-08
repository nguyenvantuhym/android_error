package com.example.newandroid;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class searchListView extends AppCompatActivity {
   SearchView searchView;
    ListView listView;
    String [] nameList = {"Văn Tú","Văn Tuấn","Văn Trò","Văn Chuyện","Văn Mạnh","Văn Chính","Văn Nhi",
            "Văn Giang", "Văn Sơn", "Văn Hưng", "Văn Hồng", "Văn Hoàng", "Văn tấn", "Văn Lưu",
            "Văn Tuấn","Văn Trò","Văn Chuyện","Văn Mạnh","Văn Chính"};
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("onCreate!!!");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_list_view);
        searchView = findViewById(R.id.searchview);
        listView = findViewById(R.id.listitem);
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                nameList);
        listView.setAdapter(adapter);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                System.out.println(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                System.out.println("tu " +newText);
                if(newText.equals("vantuhym")){
                    //todo something
                    Intent intent = new Intent(searchListView.this,MyActivity.class);
//                    Intent i = getIntent();
//                    intent.setClass(searchListView.this,MyActivity.class);
                    intent.putExtra("data",newText);
                    startActivityForResult(intent,-1);
                }
                return false;
            }
        });



    }

    // You can do the assignment inside onAttach or onCreate, i.e, before the activity is displayed
    ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    System.out.println("onActivityReslut");
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        // There are no request codes
                        Intent data = result.getData();
                        System.out.println("onActivityReslut");
                    }
                }
            });

//        public void openSomeActivityForResult() {
//            Intent intent = new Intent(this, SomeActivity.class);
//            someActivityResultLauncher.launch(intent);
//        }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        System.out.println("onActivityResult!!!");
        if(resultCode == Activity.RESULT_OK && requestCode == -1 ){
            System.out.println("onActivityResult!!!");
            data.getExtras();
        }
    }
}
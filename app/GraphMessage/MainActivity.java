package com.graphm.pablo.graphmessage;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {


    private ListView listView;
    private ArrayAdapter<String> arrayAdapter;
    private ArrayList<String> userList = new ArrayList<String>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        if(AccessToken.getCurrentAccessToken() == null){
            goLoginScreen();
        }

        listView = (ListView) findViewById(R.id.list_view);

        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,userList);

        listView.setAdapter(arrayAdapter);

        userList.add("Chattest");
        userList.add("Chattest2");
        userList.add("Chattest3");


        System.out.println(userList.get(2));

        arrayAdapter.notifyDataSetChanged();


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getApplicationContext(), ChatActivity.class);
                intent.putExtra("room_name",((TextView)view).getText().toString());
                startActivity(intent);
            }
        });
    }

    private void goLoginScreen() {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void logout(View view) {
        LoginManager.getInstance().logOut();
        goLoginScreen();
    }
}

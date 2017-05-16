package com.hoa.hoatranreportbasic;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    NetworkChangeReceiverUseJavaCode receiver; // dùng cho BroadcastReceiver use Java code
    Button start, stop;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView viewListDemo = (ListView) this.findViewById(R.id.listDemo);
        final ArrayList<String> listDemo = new ArrayList<String>();
        listDemo.add("FragmentTransitionAndServiceActivity");
        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                listDemo
        );
        viewListDemo.setAdapter(listViewAdapter);
        viewListDemo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if(listDemo.get(position).equals("FragmentTransitionAndServiceActivity")){
                   Intent intent = new Intent(MainActivity.this,FragmentTransitionAndServiceActivity.class);
                    startActivity(intent);
                }
            }
        });

        /*
         /* < Broadcast Receiver use Java code
        buttonSend = (Button) findViewById(buttonSend);
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("ACTION_HOA", "BroadcastReceiver Demo");
                intent.setAction("ACTION_HOA");
                sendBroadcast(intent);
            }
        });*/


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    @Override
    protected void onStart() {
        super.onStart();// ATTENTION: This was auto-generated to implement the App Indexing API.
// See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();

        /* < Broadcast Receiver use Java code */
        initBroadcastReceiver();
        /* Broadcast Receiver use Java code > */
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    /* < Broadcast Receiver use Java code */
    private void initBroadcastReceiver() { // Lắng nghe sự kiện thay đổi network
        receiver = new NetworkChangeReceiverUseJavaCode();
        IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"); // tạo action
        //intentFilter.addAction("ACTION_HOA");
        registerReceiver(receiver, intentFilter); // đăng ký lắng nghe
    }
    /* Broadcast Receiver use Java code > */

    @Override
    protected void onPause() {
        super.onPause();

        /* < Broadcast Receiver use Java code */
        unregisterReceiver(receiver); // Hàm này phải được gọi để tránh làm mất trạng thái của Activity gây ra lỗi
        /* Broadcast Receiver use Java code > */
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}

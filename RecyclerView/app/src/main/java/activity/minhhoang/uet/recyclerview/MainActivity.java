package activity.minhhoang.uet.recyclerview;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    public void initView(){
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        ArrayList<DataShop>arrayList = new ArrayList<>();
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        arrayList.add(new DataShop(R.drawable.apple,"Apple"));
        arrayList.add(new DataShop(R.drawable.banana,"Banana"));
        arrayList.add(new DataShop(R.drawable.mango,"Mango"));
        arrayList.add(new DataShop(R.drawable.orange,"Orange"));
        arrayList.add(new DataShop(R.drawable.watermelon,"WaterMelon"));

        ShopAdapter shopAdapter = new ShopAdapter(arrayList,getApplicationContext());
        recyclerView.setAdapter(shopAdapter);

    }
}

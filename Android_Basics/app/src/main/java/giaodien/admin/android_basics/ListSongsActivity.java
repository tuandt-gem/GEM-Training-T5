package giaodien.admin.android_basics;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ListSongsActivity extends AppCompatActivity {
    private ListView lstSongs;
    private ArrayList<Song> arrayList;
    private CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listening_music);
        addControls();
        addListView();
        addEvents();
    }

    public void addControls(){
        lstSongs = (ListView) findViewById(R.id.lstSongs);
    }

    public void addListView(){
        arrayList = new ArrayList<>();
        Song s1= new Song("Sau tất cả","Erik","Hot",R.drawable.pic_sautatca,R.raw.song_sautatca);
        Song s2= new Song("Lạc nhau có phải muôn đời","Erik","Mới",R.drawable.pic_lacnhau,R.raw.song_lacnhau);
        Song s3= new Song("Tôi là ai trong em","Erik","Hot",R.drawable.pic_toila,R.raw.song_erik);
        Song s4= new Song("Turn it up","Monstar","Hot",R.drawable.pic_turnitup,R.raw.song_turnitup);
        arrayList.add(s1);
        arrayList.add(s2);
        arrayList.add(s3);
        arrayList.add(s4);

        customAdapter = new CustomAdapter(this,R.layout.activity_song_row,arrayList);
        lstSongs.setAdapter(customAdapter);
    }

    public void addEvents(){
        lstSongs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                 Song song = arrayList.get(i);
                 Bundle bundle = new Bundle();
                 bundle.putSerializable("song",song);

                 Intent intent = new Intent(ListSongsActivity.this,SongDetailActivity.class);
                 intent.putExtra("next",bundle);
                 startActivity(intent);
            }
        });
    }

}

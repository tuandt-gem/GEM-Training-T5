package giaodien.admin.android_basics;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class SongDetailActivity extends AppCompatActivity {
    private ImageView imgSong;
    private TextView txtDTen, txtDCaSi;
    private ImageButton imgbPlay,imgbNext, imgbBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_detail);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("next");
        Song song = (Song) bundle.getSerializable("song");

        addControls();
        addInfo(song);
        playMusic(song.getLoi());
    }
    public void addControls(){
        imgSong = (ImageView) findViewById(R.id.imgSong);
        txtDTen = (TextView) findViewById(R.id.txtDTen);
        txtDCaSi = (TextView) findViewById(R.id.txtDCaSi);
        imgbBack = (ImageButton) findViewById(R.id.imgbBack);
        imgbPlay = (ImageButton) findViewById(R.id.imgbPlay);
        imgbNext = (ImageButton) findViewById(R.id.imgbNext);
        imgbPlay.setTag(R.drawable.ic_play);
    }

    public void addInfo(Song song) {
        txtDTen.setText(song.getTen());
        txtDCaSi.setText(song.getCaSi());
        imgSong.setImageResource(song.getImage());
    }

    private void playMusic(int loi) {
        final Intent myIntent = new Intent(SongDetailActivity.this, MyService.class);
        final int loi1 = loi;
        myIntent.putExtra("loi", loi);
        imgbPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getDrawableId(imgbPlay) == R.drawable.ic_play) {
                    imgbPlay.setImageResource(R.drawable.ic_stop);
                    imgbPlay.setTag(R.drawable.ic_stop);
                    SongDetailActivity.this.startService(myIntent);
                } else {
                    imgbPlay.setImageResource(R.drawable.ic_play);
                    imgbPlay.setTag(R.drawable.ic_play);
                    SongDetailActivity.this.stopService(myIntent);
                }
            }

        });
    }
    private int getDrawableId(ImageButton iv) {
        return (Integer) iv.getTag();
    }
}





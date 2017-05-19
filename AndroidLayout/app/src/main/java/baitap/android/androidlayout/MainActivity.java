package baitap.android.androidlayout;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {
    TextView labelBelow;
    LinearLayout mlinearLayoutTop;
    FrameLayout frame;

    final int MIN_DISTANCE = 50;
    float downX, downY, upX, upY;

    int currentValue;
    String[] currentLayout = new String[]{"Grid View",
            "Table Layout",
            "Linear Layout",
            "Reletive Layout",
            "Absolute Layout",
            };

    View[] arrayView;
    GridView grid;
    GridViewAdapter adapter = null;




    Integer[] arrayImageID = new Integer[]{
            R.drawable.a, R.drawable.b,
            R.drawable.c, R.drawable.d,
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mlinearLayoutTop = (LinearLayout) findViewById(R.id.linearLayoutTop);
        frame = (FrameLayout) findViewById(R.id.frame);
        labelBelow = (TextView) findViewById(R.id.textView3);
        mlinearLayoutTop.setOnTouchListener(linearLayoutTopOnTouch);

        View gridLayout = getLayoutInflater().inflate(R.layout.grid_view, null);
        grid = (GridView) gridLayout.findViewById(R.id.gridView);
        adapter = new GridViewAdapter(this);
        grid.setAdapter(adapter);

        View absolute_layout = getLayoutInflater().inflate(R.layout.absolute_layout,null);
        Button btRecyle = (Button)absolute_layout.findViewById(R.id.btRecycler);
        btRecyle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RecyclerActivity.class));
            }
        });

        arrayView = new View[]{
                gridLayout,
                LayoutInflater.from(getApplicationContext()).inflate(R.layout.table_layout, null),
                LayoutInflater.from(getApplicationContext()).inflate(R.layout.linear_layout, null),
                LayoutInflater.from(getApplicationContext()).inflate(R.layout.relative_layout, null),
               absolute_layout,
        };

        currentValue = 0;
        frame.addView(arrayView[currentValue]);
        labelBelow.setText(getResources().getString(R.string.labelBelow) + currentLayout[currentValue]);

    }



    View.OnTouchListener linearLayoutTopOnTouch = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN: {
                    downX = event.getX();
                    downY = event.getY();
                    return true;
                }
                case MotionEvent.ACTION_UP: {
                    upX = event.getX();
                    upY = event.getY();

                    float deltaX = downX - upX;
                    float deltaY = downY - upY;


                    if (Math.abs(deltaX) > Math.abs(deltaY)) //swipe horizontal
                    {
                        if (Math.abs(deltaX) > MIN_DISTANCE) {

                            if (deltaX < 0) { //left to right
                                if (currentValue > 0) {
                                    currentValue = currentValue - 1;
                                    frame.removeAllViewsInLayout();
                                    frame.addView(arrayView[currentValue]);
                                    labelBelow.setText(getResources().getString(R.string.labelBelow) + currentLayout[currentValue]);
                                }
                                Toast.makeText(getApplicationContext(), "Left to right", Toast.LENGTH_SHORT).show();
                            }
                            if (deltaX > 0) { // right to left
                                if (currentValue < arrayView.length - 1) {
                                    currentValue = currentValue + 1;
                                    frame.removeAllViewsInLayout();
                                    frame.addView(arrayView[currentValue]);
                                    labelBelow.setText(getResources().getString(R.string.labelBelow) + currentLayout[currentValue]);
                                }

                                Toast.makeText(getApplicationContext(), "Right to left", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            // not enough min_distance
                        }
                    } else {  // swipe vertical
                        if (Math.abs(deltaY) > MIN_DISTANCE) {
                            if (deltaY < 0) {  // top to bottom
                                Toast.makeText(getApplicationContext(), "Top to bottom", Toast.LENGTH_SHORT).show();
                            }
                            if (deltaY > 0) {  // bottom to top
                                Toast.makeText(getApplicationContext(), "Bottom to top", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            // not enough min_distance
                        }
                    }

                    return true;
                }

            }
            return true;
        }
    };

    class GridViewAdapter extends BaseAdapter {
        private Context mContext;

        // Constructor
        public GridViewAdapter(Context c) {
            mContext = c;
        }

        public int getCount() {
            return arrayImageID.length;
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        // create a new ImageView for each item referenced by the Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;

            if (convertView == null) {
                imageView = new ImageView(mContext);
                imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(8, 8, 8, 8);
            } else {
                imageView = (ImageView) convertView;
            }
            imageView.setImageResource(arrayImageID[position]);
            return imageView;
        }

        // Keep all Images in array

    }


}

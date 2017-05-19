package baitap.android.androidlayout;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class RecyclerActivity extends AppCompatActivity{

    private RecyclerView recyclerView;
    private CustomRecyclerAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private EditText editName;

    private List<Data> listData = new ArrayList<Data>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_recycler);

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        listData.add(new Data("ABC",R.drawable.a));
        listData.add(new Data("BCD", R.drawable.b));
        listData.add(new Data("CDE", R.drawable.c));
        listData.add(new Data("DEF", R.drawable.d));

        recyclerView.setHasFixedSize(true);


        layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);


        adapter = new CustomRecyclerAdapter(listData);
        recyclerView.setAdapter(adapter);


    }



    public class CustomRecyclerAdapter extends RecyclerView.Adapter<CustomRecyclerAdapter.RecyclerViewHolder> {

        private List<Data> listData = new ArrayList<Data>();

        public CustomRecyclerAdapter(List<Data> listData) {
            this.listData = listData;
        }

        @Override
        public int getItemCount() {
            return listData.size();
        }

        @Override
        public RecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup,
                                                     int position) {
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
            View itemView = inflater.inflate(R.layout.recycler_view_item, viewGroup, false);
            return new RecyclerViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(RecyclerViewHolder viewHolder, int position) {
            viewHolder.tvName.setText(listData.get(position).getName());
            viewHolder.img.setImageResource(listData.get(position).getIdImage());
           // viewHolder.tvOption.setText("O");
        }


        public class RecyclerViewHolder extends RecyclerView.ViewHolder{
            public ImageView img;
            public TextView tvName;
            public TextView tvOption;

            public RecyclerViewHolder(View itemView) {
                super(itemView);
                img=(ImageView)itemView.findViewById(R.id.imageView);
                tvName = (TextView) itemView.findViewById(R.id.tvName);
                tvOption = (TextView) itemView.findViewById(R.id.tvOption);
                tvOption.setOnClickListener(onClick);
            }
            View.OnClickListener onClick = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    PopupMenu popupMenu = new PopupMenu(RecyclerActivity.this, tvOption);
                    popupMenu.getMenuInflater().inflate(R.menu.popup,popupMenu.getMenu());
                    popupMenu.show();
                }
            };
        }
    }

    public class Data {
        private String name;
        private Integer idImage;

        public Data(String name) {
            this.name = name;
        }

        public Data(String name, Integer idImage) {
            this.name = name;
            this.idImage = idImage;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getIdImage() {
            return idImage;
        }

        public void setIdImage(Integer idImage) {
            this.idImage = idImage;
        }
    }

}


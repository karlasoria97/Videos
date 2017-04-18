package com.example.karla.seccion3lab.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;

import com.example.karla.seccion3lab.R;
import com.example.karla.seccion3lab.adapters.FruitAdapter;
import com.example.karla.seccion3lab.models.Fruit;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private FruitAdapter adapter;

    private List<Fruit> fruits;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fruits = this.getAllFruits();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);


        adapter = new FruitAdapter(fruits, R.layout.recycler_view_fruit_item, this, new FruitAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Fruit fruit, int position) {
                fruit.addQuantity(1);
                adapter.notifyItemChanged(position);
            }
        });

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }


        @Override
                public boolean onCreateOptionsMenu(Menu menu){
            getMenuInflater().inflate(R.menu.options_menu, menu);
            return true;
        }

        @Override
                public boolean onOptionsItemSelected(MenuItem item){
            switch (item.getItemId()){
                case R.id.add_fruit:
                    int position = fruits.size();
                    fruits.add(position, new Fruit("Plum "+(++counter), "Fruit added by the user", R.drawable.plum, R.mipmap.ic_plum, 0));
                    adapter.notifyItemInserted(position);
                    layoutManager.scrollToPosition(position);
                    return true;
                default:
                    return super.onOptionsItemSelected(item);
            }
        }

        private List<Fruit> getAllFruits(){
            return new ArrayList<Fruit>(){{
                add(new Fruit("Strawberry", "Strawberry description", R.drawable.strawberry, R.mipmap.ic_strawberry, 0));
                add(new Fruit("Orange", "Orange description", R.drawable.orange, R.mipmap.ic_orange, 0));
                add(new Fruit("Apple", "Apple description", R.drawable.apple, R.mipmap.ic_apple, 0));
                add(new Fruit("Banana", "Banana description", R.drawable.banana, R.mipmap.ic_banana, 0));
                add(new Fruit("Cherry", "Cherry description", R.drawable.cherry, R.mipmap.ic_cherry, 0));
                add(new Fruit("Pear", "Pear description", R.drawable.pear, R.mipmap.ic_pear, 0));
                add(new Fruit("Raspberry", "Raspberry description", R.drawable.raspberry, R.mipmap.ic_raspberry, 0));

            }};
        }
}

package com.example.listview;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    public final ArrayList<Integer> images = new ArrayList<>();
    public ArrayList<String> mtitle = new ArrayList<>();
    ListView listView;
    Button clearButton;
    Button addButton;
    EditText enterText;
    int count = 0;
    int count1 = 0;
    int count2 = 0;
    int count3 = 0;
    int count4 = 0;
    int count5 = 0;
    int count6 = 0;
    int count7 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);
        clearButton = findViewById(R.id.clear);
        enterText = findViewById(R.id.editText);
        addButton = findViewById(R.id.button);


        mtitle.add("Пржени компири");
        mtitle.add("Млеко");
        mtitle.add("Сладолед");
        mtitle.add("Лубеница");
        mtitle.add("Кока кола");
        mtitle.add("Чипс");
        mtitle.add("Сендвич");
        mtitle.add("Портокали");

        images.add(R.drawable.friess);
        images.add(R.drawable.milk);
        images.add(R.drawable.icecream);
        images.add(R.drawable.wmelon);
        images.add(R.drawable.coke);
        images.add(R.drawable.chips);
        images.add(R.drawable.burger);
        images.add(R.drawable.orange);

        final MyAdapter adapter = new MyAdapter(this, mtitle, images);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listView.setAdapter(null);
                adapter.notifyDataSetChanged();
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = enterText.getText().toString();
                images.add(R.drawable.np);
                mtitle.add(text);
                adapter.notifyDataSetChanged();
            }
        });
    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        ArrayList<String> rTitle;
        ArrayList<Integer> rImages;

        MyAdapter(Context c, ArrayList<String> title, ArrayList<Integer> images) {
            super(c, R.layout.row, R.id.text, title);
            this.context = c;
            this.rTitle = title;
            this.rImages = images;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);

            TextView myTitle = row.findViewById(R.id.text);
            ImageView images = row.findViewById(R.id.image);

            images.setImageResource(rImages.get(position));
            myTitle.setText(rTitle.get(position));

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if (position == 0) {
                        count++;
                        Toast.makeText(MainActivity.this, Integer.toString(count), Toast.LENGTH_SHORT).show();
                    }
                    if (position == 1) {
                        count1++;
                        Toast.makeText(MainActivity.this, Integer.toString(count1), Toast.LENGTH_SHORT).show();
                    }
                    if (position == 2) {
                        count2++;
                        Toast.makeText(MainActivity.this, Integer.toString(count2), Toast.LENGTH_SHORT).show();
                    }
                    if (position == 3) {
                        count3++;
                        Toast.makeText(MainActivity.this, Integer.toString(count3), Toast.LENGTH_SHORT).show();
                    }
                    if (position == 4) {
                        count4++;
                        Toast.makeText(MainActivity.this, Integer.toString(count4), Toast.LENGTH_SHORT).show();
                    }
                    if (position == 5) {
                        count5++;
                        Toast.makeText(MainActivity.this, Integer.toString(count5), Toast.LENGTH_SHORT).show();
                    }
                    if (position == 6) {
                        count6++;
                        Toast.makeText(MainActivity.this, Integer.toString(count6), Toast.LENGTH_SHORT).show();
                    }
                    if (position == 7) {
                        count7++;
                        Toast.makeText(MainActivity.this, Integer.toString(count7), Toast.LENGTH_SHORT).show();
                    }
                }
            });
            return row;
        }

    }

}
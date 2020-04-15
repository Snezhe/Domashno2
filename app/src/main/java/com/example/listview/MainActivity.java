package com.example.listview;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import io.paperdb.Paper;


public class MainActivity extends AppCompatActivity {

    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;
    public final ArrayList<Integer> images = new ArrayList<>();
    // MyAdapter adapter;
    // ListView listView;
    // Button clearButton;
    Button addButton;
    EditText enterText;
    TextView title;
    EditText enter;
    Button addProduct;
    Button openPage;
    int count = 0;
    int count1 = 0;
    int count2 = 0;
    int count3 = 0;
    int count4 = 0;
    int count5 = 0;
    int count6 = 0;
    int count7 = 0;
    int count8 = 0;
    // public ArrayList<String> mtitle = new ArrayList<String>();
    private ProductViewModel productViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Paper.init(this);
        setContentView(R.layout.activity_main);


        // clearButton = findViewById(R.id.clear);
        // listView = findViewById(R.id.listview);
        title = (TextView) findViewById(R.id.text);
        enterText = (EditText) findViewById(R.id.editText);
        enter = (EditText) findViewById(R.id.editText1);
        addButton = (Button) findViewById(R.id.button);
        addProduct = (Button) findViewById(R.id.addProduct1);
        openPage = (Button) findViewById(R.id.openPage);

        /*mtitle.add("Пржени компири");
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

        //listView.setAdapter(adapter);
        //adapter.notifyDataSetChanged();

       /* clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listView.setAdapter(null);
                adapter.notifyDataSetChanged();
            }
        }); */

        View frameLayoutView = findViewById(R.id.container);
        if (frameLayoutView != null) {
            FragmentMain fragmentMain = new FragmentMain();
            getFragmentManager().beginTransaction().add(R.id.container, fragmentMain).commit();
        } else {
            addButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openActivity();
                }
            });
        }


        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final ProductListAdapter adapter = new ProductListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        productViewModel = new ViewModelProvider(this).get(ProductViewModel.class);

        productViewModel.getAllProducts().observe(this, new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {
                adapter.setProductList(products);
            }
        });

    }

    public void openActivity() {
        Intent intent = new Intent(MainActivity.this, Activity2.class);
        startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            Product product = new Product(data.getStringExtra(Activity2.EXTRA_REPLY), R.drawable.np);
            productViewModel.insert(product);
        }
    }

    public void ChangeFragment(View view) {
        if (view == findViewById(R.id.button)) {
            FragmentMain fm = new FragmentMain();
            Fragment2 fr = new Fragment2();
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, fr);
            fragmentTransaction.commit();
        }
    }

    public void getResult(String text) {
        // mtitle.add(text);
        images.add(R.drawable.np);
        //adapter.notifyDataSetChanged();
    }

    public void web(View view) {
        Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
        startActivity(intent);
    }

    public void englishLanguage(View view) {
        Configuration conf = getResources().getConfiguration();
        conf.locale = new Locale("en");
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        Resources resources = new Resources(getAssets(), metrics, conf);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.app_name));
        title.setText(resources.getString(R.string.title));
        addButton.setText(resources.getString(R.string.enterButton));
        openPage.setText(resources.getString(R.string.openPage));
    }

    public void macedonianLanguage(View view) {
        Configuration conf = getResources().getConfiguration();
        conf.locale = new Locale("mk");
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        Resources resources = new Resources(getAssets(), metrics, conf);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.app_name));
        title.setText(resources.getString(R.string.title));
        addButton.setText(resources.getString(R.string.enterButton));
        openPage.setText(resources.getString(R.string.openPage));
    }

    public void spanishLanguage(View view) {
        Configuration conf = getResources().getConfiguration();
        conf.locale = new Locale("es");
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        Resources resources = new Resources(getAssets(), metrics, conf);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.app_name));
        title.setText(resources.getString(R.string.title));
        addButton.setText(resources.getString(R.string.enterButton));
        openPage.setText(resources.getString(R.string.openPage));
    }

    /*class MyAdapter extends ArrayAdapter<String> {

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

            TextView myTitle = row.findViewById(R.id.product);
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
                    if (position == 8) {
                        count8++;
                        Toast.makeText(MainActivity.this, Integer.toString(count8), Toast.LENGTH_SHORT).show();
                    }
                }
            });
            return row;
        }

    } */

}
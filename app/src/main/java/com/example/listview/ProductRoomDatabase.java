package com.example.listview;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Product.class}, version = 1, exportSchema = false)
public abstract class ProductRoomDatabase extends RoomDatabase {

    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    private static volatile ProductRoomDatabase INSTANCE;
    private static RoomDatabase.Callback roomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);

            databaseWriteExecutor.execute(() -> {
                ProductDao dao = INSTANCE.productDao();
                /* dao.deleteAll();

                Product product = new Product("Пржени компири", R.drawable.friess);
                Product product1 = new Product("Млеко", R.drawable.milk);
                Product product2 = new Product("Лубеница", R.drawable.wmelon);
                Product product3 = new Product("Сладолед", R.drawable.icecream);
                Product product4 = new Product("Кока кола", R.drawable.coke);
                Product product5 = new Product("Чипс", R.drawable.chips);
                Product product6 = new Product("Сендвич", R.drawable.burger);
                Product product7 = new Product("Портокали", R.drawable.orange);
                dao.insert(product);
                dao.insert(product1);
                dao.insert(product2);
                dao.insert(product3);
                dao.insert(product4);
                dao.insert(product5);
                dao.insert(product6);
                dao.insert(product7); */
            });
        }
    };

    static ProductRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ProductRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ProductRoomDatabase.class, "product_database")
                            .addCallback(roomDatabaseCallback).build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract ProductDao productDao();

}
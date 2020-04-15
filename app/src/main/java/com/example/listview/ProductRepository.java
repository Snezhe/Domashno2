package com.example.listview;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ProductRepository {

    private ProductDao productDao;
    private LiveData<List<Product>> allProducts;

    ProductRepository(Application application) {
        ProductRoomDatabase db = ProductRoomDatabase.getDatabase(application);
        productDao = db.productDao();
        allProducts = productDao.getProducts();
    }

    LiveData<List<Product>> getAllProducts() {
        return allProducts;
    }

    void insert(Product product) {
        ProductRoomDatabase.databaseWriteExecutor.execute(() ->  {
            productDao.insert(product);
        });
    }

}

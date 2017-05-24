package com.linhdt.helix.flickrsample;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by DangThanhLinh on 23/05/2017.
 */
@Database(name = MyDatabase.NAME, version = MyDatabase.VERSION)
public class MyDatabase {
    public static final String NAME = "RestClientDatabase";

    public static final int VERSION = 1;
}

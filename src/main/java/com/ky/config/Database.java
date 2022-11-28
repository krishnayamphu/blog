package com.ky.config;

import com.ky.database.PostTable;

public class Database {
    public static void run() {
//        UserTable.create();
        PostTable.create();
    }

    public static void destroy() {
//        UserTable.drop();
       // PostTable.drop();
    }
}

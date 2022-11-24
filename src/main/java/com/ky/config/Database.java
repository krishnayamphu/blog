package com.ky.config;

import com.ky.database.UserTable;

public class Database {
    public static void run(){
        UserTable.create();
    }
    public static void destroy(){
        UserTable.drop();
    }
}

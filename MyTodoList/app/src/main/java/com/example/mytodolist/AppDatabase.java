package com.example.mytodolist;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {Task.class}, version = 1, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {
    public abstract TaskDao taskDao();

    private static volatile AppDatabase instance;
    public static AppDatabase getDatabase(final Context context){
        if(instance == null){
            synchronized (AppDatabase.class) {
                if(instance == null){{
                    instance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "todolist_database")
                            .fallbackToDestructiveMigration()
                            .build();
                }}
            }
        }
        return instance;
    }
}

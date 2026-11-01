package com.example.mytodolist;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface TaskDao {
    @Insert
    void insertTask(Task task);

    @Query("SELECT * FROM TASKS ORDER BY id DESC")
    List<Task> getAllTasks();

    @Query("SELECT * FROM tasks WHERE terminat=0")
    List<Task> getUnfinishedTasks();

    @Update
    void updateTask(Task task);

    @Delete
    void DeleteTask(Task task);
}

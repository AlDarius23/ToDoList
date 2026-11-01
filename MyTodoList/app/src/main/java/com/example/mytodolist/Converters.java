package com.example.mytodolist;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.room.TypeConverter;
import java.time.LocalDate;
public class Converters {
    @RequiresApi(api = Build.VERSION_CODES.O)
    @TypeConverter
    public static LocalDate toDate(String value){
        if(value == null) return null;
        else return LocalDate.parse(value);
    }

    @TypeConverter
    public static String fromLocalDate(LocalDate data){
        if(data == null) return null;
        else return data.toString();
    }

    @TypeConverter
    public static Nivel toNivel(String urgenta){
        if(urgenta == null) return null;
        else return Nivel.valueOf(urgenta);
    }

    @TypeConverter
    public static String fromNivel(Nivel urgenta){
        if(urgenta == null) return null;
        else return urgenta.name();
    }
}

package com.example.football_league_app.pojo;

import androidx.room.TypeConverter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;

public class Converters {
    @TypeConverter
    public static List<Player> fromJsonToList(String value) {
        Type listType = new TypeToken<List<Player>>() {
        }.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromListToJson(List<Player> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }
}

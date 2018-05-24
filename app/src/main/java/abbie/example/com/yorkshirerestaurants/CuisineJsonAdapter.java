package abbie.example.com.yorkshirerestaurants;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

import abbie.example.com.yorkshirerestaurants.Data.Cuisine;

public class CuisineJsonAdapter implements JsonDeserializer<Cuisine> {
    @Override
    public Cuisine deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonElement jsonCuisine = json.getAsJsonObject().get("cuisine");
        return new Gson().fromJson(jsonCuisine, Cuisine.class);
    }
}

package it.mulders.spark;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import spark.Filter;

public class JsonParsingFilter
{
    public static final String REQUEST_DATA = "__request_data";

    private static final Gson gson = new GsonBuilder().create();

    public static Filter forType( final Class<?> type )
    {
        return ( request, response ) -> {
            var body = gson.fromJson( request.body(), type );
            request.attribute( REQUEST_DATA, body );
        };
    }
}
